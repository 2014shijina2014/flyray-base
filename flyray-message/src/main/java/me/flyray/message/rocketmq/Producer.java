package me.flyray.message.rocketmq;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.flyray.message.rocketmq.config.Configuration;

/**
 * 生产者
 * Created by zhongcy on 2017-02-22.
 */
@Component
public class Producer {
    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    private DefaultMQProducer defaultMQProducer;

    @Autowired
    private Configuration config;

    @PostConstruct
    public void init() throws MQClientException {
        this.defaultMQProducer = new DefaultMQProducer(config.getProducerGroup());
        defaultMQProducer.setNamesrvAddr(config.getNamesrvAddr());
        defaultMQProducer.setInstanceName(config.getInstanceName());
        //关闭VIP通道，避免出现connect to <:10909> failed导致消息发送失败
        defaultMQProducer.setVipChannelEnabled(false);
        defaultMQProducer.start();
        logger.info("RocketMq Producer start success");
    }

    @PreDestroy
    public void destroy() {
        defaultMQProducer.shutdown();
    }

    public DefaultMQProducer getDefaultMQProducer() {
        return defaultMQProducer;
    }
}
