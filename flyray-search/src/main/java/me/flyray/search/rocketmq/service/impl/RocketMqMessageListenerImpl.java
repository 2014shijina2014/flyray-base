package me.flyray.search.rocketmq.service.impl;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import me.flyray.search.rocketmq.service.RocketMqMessageListener;

/**
 * 消息处理实现类
 * Created by zhongcy on 2017-02-22.
 */
@Service
public class RocketMqMessageListenerImpl implements RocketMqMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(RocketMqMessageListenerImpl.class);

    @Override
    public boolean onMessage(List<MessageExt> messages, ConsumeConcurrentlyContext Context) {
        messages.forEach(messageExt -> logger.info(StringUtils.toEncodedString(messageExt.getBody(), Charset.defaultCharset())));
        return true;
    }
}
