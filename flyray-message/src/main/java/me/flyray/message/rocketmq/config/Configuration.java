package me.flyray.message.rocketmq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置文件值
 */
@Component
public class Configuration {

    @Value("${namesrvAddr}")
    private String namesrvAddr;

    @Value("${consumerGroup}")
    private String consumerGroup;

    @Value("${topic}")
    private String topic;

    @Value("${tag}")
    private String tag;

    @Value("${instanceName}")
    private String instanceName;

    @Value("${producerGroup}")
    private String producerGroup;

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public String getTopic() {
        return topic;
    }

    public String getTag() {
        return tag;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public String getProducerGroup() {
        return producerGroup;
    }
}
