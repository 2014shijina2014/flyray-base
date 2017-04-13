package me.flyray.rbac.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;


import java.nio.charset.Charset;

/**
 * @author bolei
 * @date：2017年4月9日 下午2:47:03 s
 * @function fastjson serializer
 */
public class FastjsonSerializer<T> implements RedisSerializer<T> {

    private static final Logger log = LoggerFactory.getLogger(FastjsonSerializer.class);

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;

    public FastjsonSerializer() {
    }

    public FastjsonSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T deserialize(byte[] data) throws SerializationException {
        if (data == null || data.length == 0) {
            return null;
        } else {
			log.debug("尝试使用fastjson序列化器进行反序列化对象==>:" + clazz);
            String src = new String(data, DEFAULT_CHARSET);
            return JSON.parseObject(src, clazz);
        }
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        } else {
        	log.debug("尝试使用fastjson序列化器进行序列化对象==>:" + t);
            return JSON.toJSONBytes(t, SerializerFeature.WriteClassName);
        }
    }

}
