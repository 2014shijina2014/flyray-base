package me.flyray.common.service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import me.flyray.common.BeanUtil;
import me.flyray.common.dao.BaseDao;

/** 
* @author: bolei
* @date：2017年4月16日 下午9:29:30 
* @description：service公共类
*/

public abstract class AbstractBaseService<T> implements BaseService{
	
	@Autowired
	private BaseDao<T> baseDao;
	protected Class<T> clazz;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		List<Map<String, Object>> resultMaps = new ArrayList<>();
		try {
			List<T> ts= baseDao.queryList(map);
			for (T t : ts) {
				Map<String, Object> resultMap = BeanUtil.objectToMap(t);
				resultMaps.add(resultMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMaps;
		
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return baseDao.queryTotal(map);
	}

	@Override
	public void save(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
			@SuppressWarnings("unchecked")
			T t = (T)BeanUtil.mapToObject(map, clazz);
			baseDao.save(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = getClass();
			@SuppressWarnings("unchecked")
			T t = (T)BeanUtil.mapToObject(map, clazz);
			baseDao.update(t);
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
			@SuppressWarnings("rawtypes")
			Class clazz = getClass();
			@SuppressWarnings("unchecked")
			T t = (T)BeanUtil.mapToObject(map, clazz);
			resultMap = BeanUtil.objectToMap(baseDao.queryObject(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}
	
	@Override
	public Map<String, Object> queryById(Long id) {
		Map<String, Object> resultMap = null;
		try {
			resultMap = BeanUtil.objectToMap(baseDao.queryById(id));
		} catch (Exception e) {
			e.printStackTrace();
		};
		return resultMap;
	}
	
}
