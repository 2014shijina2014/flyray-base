package me.flyray.crm.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public Map<String, Object> getOauthUserInfo(Map<String, Object> param) {
		Map<String, Object> resultMap = null;
		try {
			logger.info("请求微信授权信息------{}",param);
			
			WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		    config.setAppId("wx0f6fa56da5e7fb62"); // 设置微信公众号的appid
		    config.setSecret("4629f914e5c005ef8babaa1de46e486b"); // 设置微信公众号的app corpSecret
		    wxMpService.setWxMpConfigStorage(config);
			//WxMpOAuth2AccessToken wxMpOAuth2AccessToken = weixinService.oauth2getAccessToken((String)param.get("code"));
			//WxMpUser wxMpUser = weixinService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
			/*wxMpUser.getCity() wxMpUser.getCountry()
			wxMpUser.getGroupId() wxMpUser.getHeadImgUrl() wxMpUser.getLanguage() wxMpUser.getNickname()
			wxMpUser.getOpenId() wxMpUser.getProvince() wxMpUser.getRemark() wxMpUser.getSex()
			wxMpUser.getSubscribe() wxMpUser.getTagIds() wxMpUser.getUnionId()*/
		    WxMpUser wxMpUser = new WxMpUser();
		    wxMpUser.setCity("333");
		    wxMpUser.setCountry("3232");
		    wxMpUser.setGroupId(1);
		    wxMpUser.setHeadImgUrl("333");
		    wxMpUser.setNickname("3333");
		    wxMpUser.setOpenId("222");
		    wxMpUser.setUnionId("2");
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
		templateMessage.setToUser("");
		templateMessage.setTemplateId("");
		templateMessage.setUrl("");
		templateMessage.getData().add(new WxMpTemplateData("", "", ""));
		templateMessage.getData().add(new WxMpTemplateData("", "", ""));
		try {
			wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}

}
