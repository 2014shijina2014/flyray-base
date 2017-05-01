package me.flyray.pay.service.refund.alipay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import me.flyray.common.exception.BusinessException;
import me.flyray.pay.api.PayChannelConfigService;
import me.flyray.pay.api.RefundHandleService;
import me.flyray.pay.dto.RefundHandleRequest;
import me.flyray.pay.dto.RefundHandleResponse;
import me.flyray.pay.model.PayChannelConfig;
import me.flyray.pay.service.pay.alipay.util.AliPayConfig;
import me.flyray.pay.service.pay.alipay.util.AlipayConfigDecorator;
import me.flyray.pay.service.pay.alipay.util.AlipaySubmit;

/** 
* @author: bolei
* @date：2017年2月23日 下午1:41:25 
* @description：类说明 
*/

@Service("alipayRefundService")
public class AlipayRefundService implements RefundHandleService{
	
	@Autowired
    private AliPayConfig aliPayConfig;

    @Autowired
    private PayChannelConfigService payChannelConfigService;
    
    @Value("${ali.refund.no.pwd.url}")
    private String url;

	@Override
	public RefundHandleResponse refund(RefundHandleRequest request) {
		String notifyUrl = aliPayConfig.getBackCallbackUrl() + "alipayRefundCallback.api";
        
        PayChannelConfig channelConfig = payChannelConfigService.getPayChannelConfig(request.getMerchantNo(), request.getPayChannelNo());
        
        if(channelConfig == null){
            throw new BusinessException("支付通道参数未配置");
        }
        
        AlipayConfigDecorator alipayConfigDecorator = new AlipayConfigDecorator(aliPayConfig,channelConfig);
        
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", "refund_fastpay_by_platform_pwd");
        sParaTemp.put("partner", alipayConfigDecorator.getPartner());
        sParaTemp.put("_input_charset", alipayConfigDecorator.getInput_charset());
        sParaTemp.put("notify_url", notifyUrl);
        sParaTemp.put("seller_email", alipayConfigDecorator.getSeller_email());
        sParaTemp.put("batch_num", "1");
        String detailData = getDetailData(request);
        
        sParaTemp.put("detail_data", detailData);
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认",alipayConfigDecorator);
        RefundHandleResponse refundResponse = new RefundHandleResponse();
        return refundResponse;
	}
	
	private String getDetailData(RefundHandleRequest refundRequest){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("^");
        stringBuilder.append("^");
        return stringBuilder.toString();
    }

}
