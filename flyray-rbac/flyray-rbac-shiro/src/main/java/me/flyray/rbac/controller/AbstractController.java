package me.flyray.rbac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import me.flyray.rbac.entity.SysUserEntity;
import me.flyray.rbac.enums.UserType;
import me.flyray.rbac.service.SysMenuService;
import me.flyray.rbac.utils.ShiroUtils;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;

/**
 * Controller公共组件
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ApiProvider apiProvider;
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
	
	protected Long getOrgId() {
		return getUser().getOrgId();
	}
	
	protected Boolean isOrg() {
		SysUserEntity currUser = ShiroUtils.getUserEntity();
		String userType = currUser.getUserType();
		boolean flag = false;
		if (UserType.PLAT_ADMIN.getCode().equals(userType)) {
			flag = true;
		}
		return flag ;
	}
	
	protected Long getMerchantId() {
		SysUserEntity currUser = ShiroUtils.getUserEntity();
		String merchantNo = currUser.getUsername();
		//根据商户号找到商户Id
		Parameter parameter = new Parameter("merchantBaseService", "queryList");
		Map<String, Object> map = new HashMap<>();
		map.put("merchantNo", merchantNo);
		parameter.setMap(map);
		List<?> list = apiProvider.execute(parameter).getList();
		//一个商户号对应一条记录
		@SuppressWarnings("unchecked")
		Map<String, Object> resulMap= (Map<String, Object>)list.get(0);
		return (Long)resulMap.get("id");
	}
}
