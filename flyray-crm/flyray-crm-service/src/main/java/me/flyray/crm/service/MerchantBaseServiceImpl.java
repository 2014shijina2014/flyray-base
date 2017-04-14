package me.flyray.crm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.BeanUtil;
import me.flyray.crm.api.MerchantBaseService;
import me.flyray.crm.dao.MerchantBaseDao;
import me.flyray.crm.model.MerchantBase;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:29:23 
* @description：商户基础信息
*/

@Service("merchantBaseService")
public class MerchantBaseServiceImpl implements MerchantBaseService{

	@Autowired
	private MerchantBaseDao merchantBaseDao;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		
		List<Map<String, Object>> resultMaps = new ArrayList<>();
		try {
			List<MerchantBase> merchantBases= merchantBaseDao.queryList(map);
			for (MerchantBase merchantBase : merchantBases) {
				Map<String, Object> resultMap = BeanUtil.objectToMap(merchantBase);
				resultMaps.add(resultMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMaps;
		
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return merchantBaseDao.queryTotal(map);
	}

	@Override
	public void save(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			MerchantBase merchantBase = (MerchantBase)BeanUtil.mapToObject(map, MerchantBase.class);
			merchantBaseDao.save(merchantBase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			MerchantBase merchantBase = (MerchantBase)BeanUtil.mapToObject(map, MerchantBase.class);
			merchantBaseDao.update(merchantBase);
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
		
		if (map == null)     
            return null;
		Map<String, Object> resultMap = null;
		try {
			MerchantBase merchantBase = (MerchantBase)BeanUtil.mapToObject(map, MerchantBase.class);
			resultMap = BeanUtil.objectToMap(merchantBaseDao.queryObject(merchantBase));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}

}
