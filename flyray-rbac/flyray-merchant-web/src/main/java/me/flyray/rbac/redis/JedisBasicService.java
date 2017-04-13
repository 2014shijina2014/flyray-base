package me.flyray.rbac.redis;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author bolei
 * @date：2017年4月9日 下午2:47:03 
 * @description Jedis基础服务
 */
@Service("jedisBasicService")
public class JedisBasicService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;


	/**
	 * 获取ping信息
	 *
	 * @return
	 */
	public String ping() {
		return redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
				return redisConnection.ping();
			}
		});
	}

	/**
	 * 查找所有满足pattern的key值
	 *
	 * @param pattern
	 * @return
	 */
	public Set<String> matchKeys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	/**
	 * 清空所有数据
	 *
	 * @return
	 */
	public Boolean flushDataBase() {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
				redisConnection.flushDb();
				return true;
			}
		});
	}

	/**
	 * 获取数据库的大小(数量),Key的数量
	 *
	 * @return
	 */
	public Long getDataBaseSize() {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
				return redisConnection.dbSize();
			}
		});
	}

	/**
	 * 根据key判断key-value是否存在
	 *
	 * @param key
	 * @return
	 */
	public Boolean existsKey(String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 设置key的生存周期(单位:秒)
	 *
	 * @param key
	 * @param expire
	 * @return
	 */
	public Boolean expire(String key, long expire) {
		return expire(key, expire, TimeUnit.SECONDS);
	}

	/**
	 * 设置key的生存周期(模式自定义)
	 *
	 * @param key
	 * @param expire
	 * @return
	 */
	public Boolean expire(String key, long expire, TimeUnit timeUnit) {
		return redisTemplate.expire(key, expire, timeUnit);
	}

	/**
	 * 设置key的到期时间(传入时间戳)
	 *
	 * @param key
	 * @param expire
	 * @return
	 */
	public Boolean expireAt(final String key, final long expire) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
				return redisConnection.expireAt(key.getBytes(), expire);
			}
		});
	}

	/**
	 * 设置key的到期时间(传入Date)
	 *
	 * @param key
	 * @param date
	 * @return
	 */
	public Boolean expireAt(String key, Date date) {
		return redisTemplate.expireAt(key, date);
	}

	/**
	 * 根据key返回其过期时间(时间戳)
	 *
	 * @param key
	 * @return
	 */
	public Long getExpireByKey(String key) {
		return redisTemplate.getExpire(key);
	}

	/**
	 * 根据key返回其过期时间(时间模式自定义)
	 *
	 * @param key
	 * @return
	 */
	public Long getExpireByKey(String key, TimeUnit timeUnit) {
		return redisTemplate.getExpire(key, timeUnit);
	}


}
