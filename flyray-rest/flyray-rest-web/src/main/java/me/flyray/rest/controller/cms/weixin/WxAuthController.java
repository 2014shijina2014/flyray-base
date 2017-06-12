package me.flyray.rest.controller.cms.weixin;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.cms.api.WeixinCommonService;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年3月11日 下午10:55:05 
* @description：微信授权
*/

@Controller
public class WxAuthController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WeixinCommonService weixinCommonService;
	
	
	/**
	 * 通过code获取用户授权信息
	 * 获取到微信授权重定向时的参数
	 * 同时建立微信openid与机构商户的关系
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/getWxUser", method = RequestMethod.POST)
	public Map<String, Object> getWxCode(@RequestBody Map<String, String> param) throws Exception {
		logger.info("通过code获取用户授权信息------start------{}",param);
		String code = param.get("code");
		String merchantNo = param.get("merchantNo");
		String orgNo = param.get("orgNo");
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("code", code);
		requestMap.put("merchantNo", merchantNo);
		Map<String, Object> userMap = null;//weixinCommonService.getOauthUserInfo(requestMap);
		logger.info("通过code获取用户授权信息------end------{}",userMap);
		return ResponseHelper.success(userMap, "00", "请求数据成功");
	} 
	
	
}
