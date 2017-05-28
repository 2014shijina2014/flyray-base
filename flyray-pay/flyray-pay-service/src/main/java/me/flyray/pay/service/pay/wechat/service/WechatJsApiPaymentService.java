package me.flyray.pay.service.pay.wechat.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import me.flyray.common.exception.BusinessException;
import me.flyray.common.utils.Utils;
import me.flyray.pay.api.PayChannelConfigService;
import me.flyray.pay.api.PayObjectService;
import me.flyray.pay.dto.OnlinePaymentRequest;
import me.flyray.pay.model.PayChannelConfig;
import me.flyray.pay.service.pay.wechat.domain.RequestElement;
import me.flyray.pay.service.pay.wechat.util.WechatPayConfig;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/** 
* @author: bolei
* @date：2017年2月23日 上午11:42:34
* @description： 微信公众号、h5支付
*/

@Service("wechatJsApiPaymentService")
public class WechatJsApiPaymentService implements PayObjectService<OnlinePaymentRequest>{

	private static final Logger logger = LoggerFactory.getLogger(WechatJsApiPaymentService.class);
	
	@Autowired
	private PayChannelConfigService payChannelConfigService;
	@Autowired
	private WechatPayConfig wechatPayConfig;
	@Autowired
	private WechatSignatureService wechatSignatureService;
	

	@Override
	public Map<String, Object> pay(OnlinePaymentRequest request) {
		
		PayChannelConfig channelConfig = payChannelConfigService.getPayChannelConfig(request.getMerchantNo(), request.getPayChannelNo());
		if (channelConfig == null) {
		    throw new BusinessException("支付通道配置为空");
		}
		String notifyUrl = wechatPayConfig.getBackCallbackUrl() + "wechatCallback.api";

		String nonce_str = ObjectUtils.nullSafeToString((new Random().nextInt() * (99999 - 10000 + 1)) + 10000);

		// 根据获取的参数拼装XML信息
		RequestElement reqElement = new RequestElement();
		reqElement.setAppid(channelConfig.getMerAccount());
		reqElement.setBody(request.getProductName());
		reqElement.setMch_id(channelConfig.getMerchantNo());
		reqElement.setNonce_str(nonce_str);
		reqElement.setNotify_url(notifyUrl);
		reqElement.setOut_trade_no(request.getSerialNo());
		reqElement.setSpbill_create_ip(request.getExterInvokeIp());
		reqElement.setTotal_fee(Utils.changeToDivide(request.getOrderAmt().toString()));
		reqElement.setTrade_type("JSAPI");
		reqElement.setOpenid((String) request.getExtra().get("openId"));

		// 获取签名信息
		try {
			reqElement.setSign(wechatSignatureService.sign(reqElement, channelConfig));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String xmlStr = null;
		try {
			xmlStr = reqData2Xml(reqElement);
		} catch (JAXBException e) {
			logger.error("解析微信返回数据失败", e);
			throw new BusinessException("解析微信返回数据失败");
		}

		//调用微信统一下单接口
		String payUrl = wechatPayConfig.getWechatGatewayUrl();
		
		OkHttpClient client = new OkHttpClient();

	    MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/xml");
	    Request wxrequest = new Request.Builder()
	            .url(payUrl)
	            .post(RequestBody.create(MEDIA_TYPE_TEXT, xmlStr))
	            .build();

	    Response response;
	    Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			response = client.newCall(wxrequest).execute();
			if (!response.isSuccessful()) {
		        throw new IOException("服务器端错误: " + response);
		    }
		    
		    String info = response.body().string();
			resultMap = receiveResult(info, channelConfig, request.getSerialNo());
		    logger.info("发送成功，返回的结果：", resultMap);
		    
		    System.out.println(response.body().string());
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	    
		return resultMap;
	}
	
	/**
	 * 将请球参数转为Xml格式
	 * 
	 * @throws JAXBException
	 * @throws ParserConfigurationException
	 */
	private String reqData2Xml(RequestElement reqElement) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(RequestElement.class);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息（<?xml
																// version="1.0"
																// encoding="gb2312"
																// standalone="yes"?>）
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();

		StreamResult result = new StreamResult(outputstream);

		marshaller.marshal(reqElement, result);

		byte[] body = outputstream.toByteArray();

		return new String(body, Charset.forName("UTF-8"));
	}
	
	/**
	 * 解析获取的返回结果
	 * @param info
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private Map<String, Object> receiveResult(String info, PayChannelConfig channelConfig, String merOrderId) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputStream is = getStringStream(info);
		Document document = builder.parse(is);

		// 获取到document里面的全部结点
		NodeList allNodes = document.getFirstChild().getChildNodes();
		Node node;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		int i = 0;
		while (i < allNodes.getLength()) {
			node = allNodes.item(i);
			if (node instanceof Element) {
				paramMap.put(node.getNodeName(), node.getTextContent());
			}
			i++;
		}
		// Date dt=new Date();
		String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
		Random random = new Random();
		String nonceStr = ObjectUtils.nullSafeToString((random.nextInt() * (99999 - 10000 + 1)) + 10000);
		// 生成jssdk支付签名
		Map<String, Object> signMap = new HashMap<String, Object>();
		signMap.put("appId", paramMap.get("appid"));
		signMap.put("nonceStr", nonceStr);
		signMap.put("package", "prepay_id=" + paramMap.get("prepay_id"));
		signMap.put("signType", "MD5");
		signMap.put("timeStamp", timeStamp);
		// 返回
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("sign", wechatSignatureService.toSign(signMap, channelConfig));
		resultMap.put("appid", paramMap.get("appid"));
		resultMap.put("noncestr", nonceStr);
		resultMap.put("package", "Sign=WXPay");
		resultMap.put("timestamp", timeStamp);
		resultMap.put("prepayid", paramMap.get("prepay_id"));
		resultMap.put("partnerid", paramMap.get("mch_id"));
		resultMap.put("return_code", paramMap.get("return_code"));
		resultMap.put("return_msg", paramMap.get("return_msg"));
		resultMap.put("merOrderId", merOrderId);
		return resultMap;
	}
	
	private InputStream getStringStream(String sInputString) throws UnsupportedEncodingException {
		ByteArrayInputStream tInputStringStream = null;
		if (sInputString != null && !sInputString.trim().equals("")) {
			tInputStringStream = new ByteArrayInputStream(sInputString.getBytes("UTF-8"));
		}
		return tInputStringStream;
	}

}
