package me.flyray.pay.service.refund.wechat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.SSLContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.xml.sax.SAXException;

import me.flyray.common.exception.BusinessException;
import me.flyray.pay.api.PayChannelConfigService;
import me.flyray.pay.api.RefundHandlerService;
import me.flyray.pay.dto.RefundRequest;
import me.flyray.pay.dto.RefundResponse;
import me.flyray.pay.model.PayChannelConfig;
import me.flyray.pay.service.pay.wechat.service.WechatSignatureService;
import me.flyray.pay.service.pay.wechat.util.WechatPayConfig;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/** 
* @author: bolei
* @date：2017年2月23日 下午1:40:55 
* @description：类说明 
*/

@Service("wechatRefundService")
public class WechatRefundService implements RefundHandlerService{

	private static final Logger logger = LoggerFactory.getLogger(WechatRefundService.class);
	
	@Autowired
    private PayChannelConfigService payChannelConfigService;
    @Autowired
    private WechatSignatureService wechatSignatureService;
    @Autowired
    private WechatPayConfig wechatPayConfig;
	
	@Override
	public RefundResponse refund(RefundRequest request) {
		PayChannelConfig channelConfig = payChannelConfigService.getPayChannelConfig(request.getMerchantNo(),request.getPayChannelNo());
        if (channelConfig == null) {
            throw new BusinessException("支付通道参数未配置");
        }
        logger.info("支付通道配置信息：{}", channelConfig);
        
        RefundResponse refundResponse = new RefundResponse();
        
        WechatRefundRequest wechatRefundRequest = new WechatRefundRequest();
        wechatRefundRequest.setAppid(channelConfig.getMerAccount());
        wechatRefundRequest.setMch_id(channelConfig.getMerchantNo());
        wechatRefundRequest.setNonce_str(ObjectUtils.nullSafeToString((new Random().nextInt() * (99999 - 10000 + 1)) + 10000));
        wechatRefundRequest.setOp_user_id(channelConfig.getMerchantNo());
        try {
			wechatRefundRequest.setSign(wechatSignatureService.sign(wechatRefundRequest, channelConfig));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        String xmlStr = null;
		try {
			xmlStr = reqData2Xml(wechatRefundRequest);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        OkHttpClient client = new OkHttpClient();

	    MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/xml");
	    Request wxrequest = new Request.Builder()
	            .url(wechatPayConfig.getWechatGatewayRefundUrl())
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
		    logger.info("发送成功，返回的结果：", resultMap);
		    
		    System.out.println(response.body().string());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return refundResponse;
        
	}
	
	/**
     * 将请球参数转为Xml格式
     * @throws JAXBException 
     * @throws ParserConfigurationException 
     */
    private String reqData2Xml(WechatRefundRequest wechatRefundRequest) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(WechatRefundRequest.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");//编码格式
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化生成的xml串
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）
        
        ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(outputstream);
        marshaller.marshal(wechatRefundRequest, result);
        byte[] body = outputstream.toByteArray();
        
        return new String(body,Charset.forName("UTF-8"));
    }
    
    private WechatRefundResponse xmlToResponseData(InputStream inputStream) throws JAXBException{
        Reader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        JAXBContext context = JAXBContext.newInstance(WechatRefundResponse.class);
        try{
            Unmarshaller unmarshaller=  context.createUnmarshaller();
            return (WechatRefundResponse) unmarshaller.unmarshal(reader);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private SSLConnectionSocketFactory loadMerKey(String keyFilePath,String keyPwd){
        if(keyFilePath == null){
            logger.error("商户退款密钥证书未配置keyFilePath为空");
            throw new BusinessException("商户退款密钥证书未配置");
        }
        FileInputStream instream;
        try {
            instream = new FileInputStream(new File(keyFilePath));
        } catch (FileNotFoundException e) {
            logger.error("商户退款密钥证书未配置",e);
            throw new BusinessException("商户退款密钥证书未配置");
        }
        try {
            KeyStore keyStore  = KeyStore.getInstance("PKCS12");
            keyStore.load(instream, keyPwd.toCharArray());
            SSLContext sslcontext = SSLContexts.custom()
                    .loadKeyMaterial(keyStore, keyPwd.toCharArray())
                    .build();
            return new SSLConnectionSocketFactory(
                    sslcontext,
                    new String[] { "TLSv1" },
                    null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        }catch (Exception e) {
            logger.error("加载商户密钥证书失败",e);
            throw new BusinessException("加载商户密钥证书失败");
        } finally {
            try {
                instream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
