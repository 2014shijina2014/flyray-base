package me.flyray.pay.service.pay.alipay.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.exception.BusinessException;
import me.flyray.pay.api.PayChannelConfigService;
import me.flyray.pay.api.PayObjectService;
import me.flyray.pay.dto.OnlinePaymentRequest;
import me.flyray.pay.model.PayChannelConfig;
import me.flyray.pay.service.pay.alipay.util.AliPayConfig;
import me.flyray.pay.service.pay.alipay.util.AlipayConfigDecorator;
import me.flyray.pay.service.pay.alipay.util.AlipaySubmit;

/** 
* @author: bolei
* @date：2017年4月30日 下午2:57:32
* @description：支付宝即使到账接口
*/

@Service("aliDirectPayService")
public class AliDirectPayService implements PayObjectService<OnlinePaymentRequest>{

	private static final Logger logger = LoggerFactory.getLogger(AliDirectPayService.class);
	
	@Autowired
    private AliPayConfig aliPayConfig;
    
    @Autowired
    private PayChannelConfigService payChannelConfigService;
    
	@Override
	public Map<String, Object> pay(OnlinePaymentRequest request) {
		PayChannelConfig channelConfig = payChannelConfigService.getPayChannelConfig(request.getMerchantNo(), request.getPayChannelNo());
        
        if(channelConfig == null){
            throw new BusinessException("支付通道配置为空");
        }
        
        AlipayConfigDecorator alipayConfigDecorator = new AlipayConfigDecorator(aliPayConfig,channelConfig);
        
        String returnUrl = alipayConfigDecorator.getFrontCallbackUrl() + "alipayFrontCallback.action";
        String notifyUrl = alipayConfigDecorator.getBackCallbackUrl() + "alipayBackCallback.api";
        
        Map<String, String> sParaTemp = new HashMap<String, String>();
            
        sParaTemp.put("service", "create_direct_pay_by_user");//接口名称
        sParaTemp.put("partner", alipayConfigDecorator.getPartner());//合作者身份ID
        sParaTemp.put("seller_email", alipayConfigDecorator.getSeller_email());//收款支付宝账号
        sParaTemp.put("_input_charset", aliPayConfig.getInput_charset());//参数编码字符集
        sParaTemp.put("payment_type", "1");//支付类型(商品购买)
        sParaTemp.put("notify_url", notifyUrl);//异步通知路径
        sParaTemp.put("return_url", returnUrl);//同步通知路径
        sParaTemp.put("out_trade_no", request.getSerialNo());//订单号
        sParaTemp.put("subject", request.getProductName());//商品名称
        sParaTemp.put("total_fee", request.getOrderAmt().toString());//交易金额
        sParaTemp.put("body", request.getBody());//商品描述
        sParaTemp.put("show_url", request.getProductUrl());//商品展示地址
        sParaTemp.put("anti_phishing_key", request.getAntiPhishingKey());//防钓鱼时间戳
        sParaTemp.put("exter_invoke_ip", request.getExterInvokeIp());//客户端IP      
        
        return AlipaySubmit.buildRequestParaObject(sParaTemp, alipayConfigDecorator);
	}

}
