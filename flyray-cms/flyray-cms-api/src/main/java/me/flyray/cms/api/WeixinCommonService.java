package me.flyray.cms.api;

import java.util.Map;

/** 
* @author: bolei
* @date：2017年5月25日 上午11:02:37 
* @description：微信基础处理接口
*/

public interface WeixinCommonService {

	/**
	 * 获取用户授权信息
	 * @param requestMap
	 * @return
	 */
	Map<String, Object> getOauthUserInfo(Map<String, Object> requestMap);
	
	/**
	 * 发送微信模板信息
	 * @param param
	 */
	void sendWxMpMessage(Map<String, Object> param);
}
