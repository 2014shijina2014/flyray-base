package me.flyray.message.rocketmq.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.message.rocketmq.Producer;
import me.flyray.message.rocketmq.config.Configuration;

/**
 * Controller
 */
@RestController
@RequestMapping("/rocketmq")
public class RocketMqController {

    private static final String SUCCESS = "success";

    private static final Logger logger = LoggerFactory.getLogger(RocketMqController.class);

    @Autowired
    private Configuration config;

    @Autowired
    private Producer producer;

    @RequestMapping("send")
    public String sendMessage(String msg) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        logger.info("send msg:{}", msg);
        Message message = new Message(config.getTopic(), config.getTag(), msg.getBytes());
        SendResult result = producer.getDefaultMQProducer().send(message);
        if (result.getSendStatus() == SendStatus.SEND_OK) {
            return SUCCESS;
        }
        return null;
    }
}
