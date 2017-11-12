package me.flyray.rest.controller.crm.weixin;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.crm.api.WeixinCommonService;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年11月12日 上午9:13:56
* @description：微信分享链接生成参数
*/

@Controller
@RequestMapping("/api/crm/weixin/jssdk")
public class WxJsController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private WeixinCommonService weixinCommonService;
	@Value("${wx_appid}")
	private String appId;
	
    @ResponseBody
    @RequestMapping(value="/getShareParams", method = RequestMethod.POST)
    public Map<String, Object> getShareParams(@RequestBody Map<String, String> param){
    	String url = param.get("url");
    	String jsapi_ticket = weixinCommonService.getJsapiTicket();
    	
    	Map<String, String> ret = new HashMap<String, String>();
    	Map<String, Object> signatureInfo = weixinCommonService.getSignatureInfo(url);
    	String nonceStr = (String)signatureInfo.get("nonceStr");
    	long timestamp = (long)signatureInfo.get("timestamp");
    	String signature = (String)signatureInfo.get("signature");
    	
        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonceStr);
        ret.put("timestamp", String.valueOf(timestamp));
        ret.put("signature", signature);
        ret.put("appid", appId);
    	return ResponseHelper.success(ret,null, "00", "请求数据成功");
	}
    
}
