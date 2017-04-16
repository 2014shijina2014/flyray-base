package me.flyray.rest.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.esotericsoftware.reflectasm.MethodAccess;

import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.BaseModel;
import me.flyray.rest.model.Parameter;
import me.flyray.rest.model.TestUser;

/** 
* @author: bolei
* @date：2017年3月26日 下午2:03:16 
* @description：类说明 
*/

@Service("apiProvider")
public class ApiProviderImpl implements ApplicationContextAware, ApiProvider{

	private static final Logger logger = LoggerFactory.getLogger(ApiProviderImpl.class);
	
	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Override
	public Parameter execute(Parameter parameter) {
		
		logger.info("请求flyray-rest参数：{}", JSON.toJSONString(parameter));
		logger.info("调用服务名称：{}",parameter.getService());
		logger.info("调用服务方法：{}",parameter.getMethod());
		Object service = applicationContext.getBean(parameter.getService());
		logger.info("根据请求服务实例化对象：{}",service);
		try {
			Long id = parameter.getId();
			BaseModel model = parameter.getModel();
			List<?> list = parameter.getList();
			Map<?, ?> map = parameter.getMap();
			Object result = null;
			MethodAccess methodAccess = MethodAccess.get(service.getClass());
			if (id != null) {
				logger.info("调用服务参数：{}",parameter.getId());
				result = methodAccess.invoke(service, parameter.getMethod(), parameter.getId());
			} else if (model != null) {
				logger.info("调用服务参数：{}",parameter.getModel());
				result = methodAccess.invoke(service, parameter.getMethod(), parameter.getModel());
			} else if (list != null) {
				logger.info("调用服务参数：{}",parameter.getList());
				result = methodAccess.invoke(service, parameter.getMethod(), parameter.getList());
			} else if (map != null) {
				logger.info("调用服务参数：{}",parameter.getMap());
				result = methodAccess.invoke(service, parameter.getMethod(), parameter.getMap());
			} else {
				result = methodAccess.invoke(service, parameter.getMethod());
			}
			if (result != null) {
				Parameter response = new Parameter(result);
				logger.info("rest-api响应：{}", JSON.toJSONString(response));
				return response;
			}
			logger.info("空响应");
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * just test
	 */
	@Override
	public Parameter execute(TestUser parameter) {
		logger.info("请求：{}", JSON.toJSONString(parameter));
		return null;
	}

}
