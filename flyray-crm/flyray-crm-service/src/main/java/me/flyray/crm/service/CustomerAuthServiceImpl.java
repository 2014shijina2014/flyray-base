package me.flyray.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.common.utils.CRC16M;
import me.flyray.common.utils.SnowFlake;
import me.flyray.crm.api.CustomerAuthService;
import me.flyray.crm.api.CustomerBaseExtendService;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.dao.CustomerAuthDao;
import me.flyray.crm.model.CustomerAuth;
import me.flyray.crm.model.CustomerBase;
import me.flyray.crm.model.CustomerBaseExtend;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:24:22 
* @description：类说明 
*/

@Service("customerAuthService")
public class CustomerAuthServiceImpl extends AbstractBaseService<CustomerAuth> implements CustomerAuthService{

	@Autowired
	private CustomerAuthDao customerAuthDao;
	@Autowired
	private CustomerBaseService customerBaseService;
	@Autowired
	private CustomerBaseExtendService CustomerBaseExtendService;

	@Override
	public void save(CustomerAuth customerAuth) {
		customerAuthDao.save(customerAuth);
	}

	@Override
	public CustomerBase customerAuth(Map<String, Object> map) {
		//保存会员信息
		long customerId = SnowFlake.getId();//商户号crc自校验数据 目的防止伪造造成脏数据
		String customerIdStr = String.valueOf(customerId);
		String customerNo = CRC16M.getCRCNo(customerIdStr);
		CustomerBase customerBase = new CustomerBase();
		customerBase.setCustomerNo(customerNo);
		customerBase.setId(customerIdStr);
		customerBase.setAddress(map.get("country")+"-"+map.get("province")+"-"+map.get("city"));
		//customerBase.setAge((String)map.get("age"));
		customerBase.setAvatar((String)map.get("headImgUrl"));
		//customerBase.setBirthday((String)userMap.get("country"));
		//customerBase.setCustName((String)userMap.get("country"));
		customerBase.setNickname((String)map.get("nickname"));
		customerBase.setMerchantId((String)map.get("merchantId"));
		customerBase.setOrgId((String)map.get("orgId"));
		//customerBase.setPhone(phone);
		customerBase.setSex((String)map.get("sex"));
		//先判断该用户是否已经授权过
		String openId = (String)map.get("openId");
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("credential", openId);
		List<CustomerAuth> list = customerAuthDao.queryList(queryMap);
		if (list != null && list.size() > 0) {
			CustomerAuth customerAuth = list.get(0);
			return customerBaseService.queryByCustomerId(Long.valueOf(customerAuth.getCustomerId()));
		}
		CustomerBaseExtend customerBaseExtend = new CustomerBaseExtend();
		customerBaseExtend.setCustomerId(customerId);
		CustomerBaseExtendService.save(customerBaseExtend);
		customerBaseService.save(customerBase);
		//保存微信授权信息
		CustomerAuth customerAuth = new CustomerAuth();
		customerAuth.setCredential(openId);		//密码凭证（站内的保存密码，站外的不保存或保存token）
		customerAuth.setCustomerId(String.valueOf(customerId));		//客户（会员）编号
		customerAuth.setIdentifier((String)map.get("unionId"));		//标识（手机号 邮箱 用户名或第三方应用的唯一标识）
		customerAuth.setIdentityType("weixin");	//登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）
		this.save(customerAuth);
		return customerBase;
	}
	
	
}
