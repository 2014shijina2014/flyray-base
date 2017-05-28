package me.flyray.pay.service.pay;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.flyray.common.exception.BusinessException;
import me.flyray.common.service.SpringContextHolder;
import me.flyray.common.utils.BeanUtils;
import me.flyray.pay.api.PayChannelInterfaceService;
import me.flyray.pay.api.PayObjectService;
import me.flyray.pay.api.PayOrderService;
import me.flyray.pay.api.PaySerialService;
import me.flyray.pay.api.PaymentHandleService;
import me.flyray.pay.dto.OnlinePaymentRequest;
import me.flyray.pay.dto.PaymentHandleRequest;
import me.flyray.pay.dto.PaymentHandleResponse;
import me.flyray.pay.model.PayChannel;
import me.flyray.pay.model.PayChannelInterface;
import me.flyray.pay.model.PayOrder;
import me.flyray.pay.model.PaySerial;

/** 
* @author: bolei
* @date：2017年4月30日 上午10:43:54 
* @description：支付逻辑处理  
*/
@Service("paymentHandleService")
public class PaymentHandleServiceImpl implements PaymentHandleService{

	private static final Logger logger = LoggerFactory.getLogger(PaymentHandleServiceImpl.class);
	
	@Autowired
	private PayOrderService payOrderService;
	@Autowired
	private PaySerialService paySerialService;
	@Autowired
	private PayRouteService payRouteService;
	@Autowired
	private PayChannelInterfaceService payChannelInterfaceService;
	
	/**
	 * 1、根据支付渠编号道需要返回支付通道对象
	 * 2、根据支付通道对象调用相关支付通道支付
	 * 3、创建支付流水
	 */
	@Override
	public PaymentHandleResponse pay(PaymentHandleRequest request) {
		
		logger.info("获取支付通道对象 start");
		PayChannel payChannel = payRouteService.getRoute(request.getBankCode(), request.getPayMethod(), request.getMerchantNo());
      
	    if (payChannel == null) {
	       throw new BusinessException("无可用支付通道");
	    }
		
		logger.info("获取支付通道对象 end");
		
		//获取支付订单信息
		String payOrderNo = request.getPayOrderNo();
		logger.info("支付订单号为 :{}",payOrderNo);
		PayOrder payOrder = new PayOrder();
		payOrder.setPayOrderNo(payOrderNo);
		payOrder = payOrderService.queryByPayOrder(payOrder);
		
		logger.info("支付请求创建订单 start");
		Map<String, Object> reqMap = null;
		
		try {
			reqMap = BeanUtils.objectToMap(request);
			logger.info("请求参数：{}",reqMap);
		} catch (Exception e) {
			logger.error("请求支付异常：{}",e);
			e.printStackTrace();
		}
		if (reqMap == null && payOrder == null) {
			throw new BusinessException("请求参数为空");
		}
		PaySerial paySerial = new PaySerial();
		paySerial.setPayOrderNo(payOrderNo);
		paySerialService.insert(paySerial);
		logger.info("支付请求创建订单 end");
		
		PaymentHandleResponse response = new PaymentHandleResponse();
		Map<String,Object> retMap = getPayObject(payOrder, payChannel, paySerial, null);
		return response;
	}


	/**
	 * 获取支付对象
	 * 限额控制--限额检查
	 * 同一收款订单 ：创建支付流水之前，修改其他支付中支付流水为失败
	 */
	private Map<String, Object> getPayObject(PayOrder payOrder, PayChannel payChannel, PaySerial paySerial, Object object) {
		
        logger.info("支付通道：{}",payChannel);
    	PayChannelInterface payChannelInterface = payChannelInterfaceService.getPayChannelInterface(payChannel.getPayChannelNo());
        
        if(payChannelInterface == null){
            logger.error("查询支付通道接口为null,支付通道编号:{}",payChannel.getPayChannelNo());
            throw new BusinessException("查询支付通道接口为null");
        }
        
        logger.info("查询支付通道接口,支付接口:{}",payChannelInterface.getPayServiceName());
        
        if(!(SpringContextHolder.getBean(payChannelInterface.getPayServiceName()) instanceof PayObjectService)){
            logger.error("查询支付通道接口未实现PayObjectService,支付通道编号:{}",payChannel.getPayChannelNo());
            throw new BusinessException("查询支付通道接口未实现PayObjectService");
        }
        
        PayObjectService<OnlinePaymentRequest> payObjectService =  SpringContextHolder.getBean(payChannelInterface.getPayServiceName());
        
        OnlinePaymentRequest request = new OnlinePaymentRequest();
        
        request.setMerchantNo(payOrder.getMerchantNo());
        request.setPayChannelNo(payChannel.getPayChannelNo());
        
        request.setSerialNo(paySerial.getSerialNo());
        request.setOrderAmt(payOrder.getPayAmt());
        request.setProductName(payOrder.getBody());
        request.setTxTime(payOrder.getPayTime());
        String custIp="127.0.0.1";
        request.setExterInvokeIp(custIp);
        
        return payObjectService.pay(request);
        
	}

}
