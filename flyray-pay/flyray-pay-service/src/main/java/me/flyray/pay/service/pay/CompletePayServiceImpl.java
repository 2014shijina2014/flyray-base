package me.flyray.pay.service.pay;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.flyray.pay.api.CompletePayService;
import me.flyray.pay.dto.CompletePayRequest;
import me.flyray.pay.dto.CompletePayResponse;
import me.flyray.pay.util.mq.Configuration;
import me.flyray.pay.util.mq.Producer;

/** 
* @author: bolei
* @date：2017年5月7日 下午10:51:29 
* @description：类说明 
*/
@Service("completePayService")
public class CompletePayServiceImpl implements CompletePayService{

    private static final Logger logger = LoggerFactory.getLogger(CompletePayServiceImpl.class);

    @Autowired
    private Configuration config;

    @Autowired
    private Producer producer;
    
	@Override
	public CompletePayResponse CompletePay(CompletePayRequest request) {
		// TODO Auto-generated method stub
		CompletePayResponse response = new CompletePayResponse();
		String msg = "";
		logger.info("send msg:{}", msg);
        Message message = new Message(config.getTopic(), config.getTag(), msg.getBytes());
        SendResult result = null;
		try {
			result = producer.getDefaultMQProducer().send(message);
		} catch (MQClientException e) {
			e.printStackTrace();
		} catch (RemotingException e) {
			e.printStackTrace();
		} catch (MQBrokerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        if (result != null && result.getSendStatus() == SendStatus.SEND_OK) {
            return response;
        }
		return null;
	}

}
