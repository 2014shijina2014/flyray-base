package me.flyray.rest.api;

import me.flyray.rest.model.Parameter;
import me.flyray.rest.model.TestUser;

/** 
* @author: bolei
* @date：2017年3月26日 下午2:00:21 
* @description：dubbo服务统一入口
*/

public interface ApiProvider {

	public Parameter execute(Parameter parameter);
	
	public Parameter execute(TestUser parameter);
}
