package me.flyray.search.rocketmq.service;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 封装通用逻辑
 * Created by zhongcy on 2017-02-22.
 */
@Service
public class RocketMqMessageWrapper implements MessageListenerConcurrently {

    @Autowired
    private RocketMqMessageListener rocketMqMessageListener;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        if (rocketMqMessageListener.onMessage(list, consumeConcurrentlyContext)) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }
}
