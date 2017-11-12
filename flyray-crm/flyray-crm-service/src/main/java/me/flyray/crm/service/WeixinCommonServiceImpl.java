package me.flyray.crm.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import me.flyray.common.utils.BeanUtils;
import me.flyray.crm.api.WeixinCommonService;

/** 
* @author: bolei
* @date：2017年5月25日 上午11:05:50 
* @description：类说明 
*/

@Service("weixinCommonService")
public class WeixinCommonServiceImpl implements WeixinCommonService{

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WeixinService weixinService;
	@Autowired
	private WxMpService wxMpService;
	@Value("${wx_appid}")
	private String appId;
	@Value("${wx_appsecret}")
	private String appsecret;
	
	@Override
	public Map<String, Object> getOauthUserInfo(Map<String, Object> param) {
		Map<String, Object> resultMap = null;
		try {
			logger.info("请求微信授权信息------{}",param);
			
			WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		    config.setAppId(appId); // 设置微信公众号的appid
		    config.setSecret(appsecret); // 设置微信公众号的app corpSecret
		    wxMpService.setWxMpConfigStorage(config);
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = weixinService.oauth2getAccessToken((String)param.get("code"));
			WxMpUser wxMpUser = weixinService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
			/*wxMpUser.getCity() wxMpUser.getCountry()
			wxMpUser.getGroupId() wxMpUser.getHeadImgUrl() wxMpUser.getLanguage() wxMpUser.getNickname()
			wxMpUser.getOpenId() wxMpUser.getProvince() wxMpUser.getRemark() wxMpUser.getSex()
			wxMpUser.getSubscribe() wxMpUser.getTagIds() wxMpUser.getUnionId()*/
			/*WxMpUser wxMpUser = new WxMpUser();
		    wxMpUser.setCity("333");
		    wxMpUser.setCountry("3232");
		    wxMpUser.setGroupId(1);
		    wxMpUser.setHeadImgUrl("333");
		    wxMpUser.setNickname("3333");
		    wxMpUser.setOpenId("222");
		    wxMpUser.setUnionId("2");*/
			resultMap = BeanUtils.objectToMap(wxMpUser);
			logger.info("微信授权用户信息------{}",resultMap);
			/* 将用户信息保存到数据库 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public void sendWxMpMessage(Map<String, Object> param) {
		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		//OPENID
		templateMessage.setToUser((String)param.get("openId"));
		templateMessage.setTemplateId((String)param.get("templateId"));
		//模板跳转链接
		templateMessage.setUrl((String)param.get("url"));
		//String name, String value, String color "value":"巧克力","color":"#173177"
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>)param.get("listData");
		for (Map<String, Object> data : list) {
			WxMpTemplateData wxMpTemplateData = new WxMpTemplateData();
			wxMpTemplateData.setColor("#555");
			wxMpTemplateData.setName("keyword1");
			wxMpTemplateData.setValue("keyword3");
			templateMessage.getData().add(wxMpTemplateData);
		}
		try {
			WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
			config.setAppId(appId); // 设置微信公众号的appid
		    config.setSecret(appsecret); // 设置微信公众号的app corpSecret
		    wxMpService.setWxMpConfigStorage(config);
			wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getJsapiTicket() {
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId(appId); // 设置微信公众号的appid
	    config.setSecret(appsecret); // 设置微信公众号的app corpSecret
	    wxMpService.setWxMpConfigStorage(config);
	    String jsapiTicket = null;
	    try {
	    	jsapiTicket = wxMpService.getJsapiTicket(true);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		return jsapiTicket;
	}

	@Override
	public Map<String, Object> getSignatureInfo(String url) {
		Map<String, Object> resultMap = null;
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId(appId); // 设置微信公众号的appid
	    config.setSecret(appsecret); // 设置微信公众号的app corpSecret
	    wxMpService.setWxMpConfigStorage(config);
	    WxJsapiSignature signInfo = null;
		try {
			signInfo = wxMpService.createJsapiSignature(url);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		if (signInfo == null) {
			return null;
		}else{
			try {
				//signInfo.getSignature()
				resultMap = BeanUtils.objectToMap(signInfo);
			} catch (Exception e) {
				e.printStackTrace();
			};
			return resultMap;
		}
	}

}
