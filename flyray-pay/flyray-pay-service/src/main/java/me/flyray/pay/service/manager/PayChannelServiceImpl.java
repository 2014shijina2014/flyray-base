package me.flyray.pay.service.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.BeanUtil;
import me.flyray.pay.api.PayChannelService;
import me.flyray.pay.dao.PayChannelDao;
import me.flyray.pay.model.PayChannel;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:57:07 
* @description：支付通道
*/

@Service("payChannelService")
public class PayChannelServiceImpl implements PayChannelService{
	
	private static final Logger logger = LoggerFactory.getLogger(PayChannelServiceImpl.class);
	
	@Autowired
	private PayChannelDao payChannelDao;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		
		List<Map<String, Object>> resultMaps = new ArrayList<>();
		try {
			List<PayChannel> payChannels= payChannelDao.queryList(map);
			for (PayChannel payChannel : payChannels) {
				Map<String, Object> resultMap = BeanUtil.objectToMap(payChannel);
				resultMaps.add(resultMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMaps;
		
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return payChannelDao.queryTotal(map);
	}

	@Override
	public void save(Map<String, Object> map) {
		logger.info("flyray-pay保存支付通道信息----：{}",map);
		if (map == null)     
            return;
		try {
			PayChannel payChannel = (PayChannel)BeanUtil.mapToObject(map, PayChannel.class);
			payChannelDao.save(payChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Map<String, Object> map) {
		logger.info("flyray-pay更新支付通道信息----请求参数：{}",map);
		if (map == null)     
            return;
		try {
			PayChannel payChannel = (PayChannel)BeanUtil.mapToObject(map, PayChannel.class);
			payChannelDao.update(payChannel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBatch(Long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> queryObject(Map<String, Object> map) {
		logger.info("flyray-pay查询支付通道信息----请求参数：{}",map);
		if (map == null)     
            return null;
		Map<String, Object> resultMap = null;
		try {
			PayChannel payChannel = (PayChannel)BeanUtil.mapToObject(map, PayChannel.class);
			resultMap = BeanUtil.objectToMap(payChannelDao.queryObject(payChannel));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}

	@Override
	public Map<String, Object> queryById(Long id) {
		logger.info("flyray-pay根据ID查询支付通道信息----请求参数：{}",id);
		Map<String, Object> resultMap = null;
		try {
			resultMap = BeanUtil.objectToMap(payChannelDao.queryById(id));
		} catch (Exception e) {
			e.printStackTrace();
		};
		logger.info("flyray-pay根据ID查询支付通道信息----返回参数参数：{}",resultMap);
		return resultMap;
	}

}
