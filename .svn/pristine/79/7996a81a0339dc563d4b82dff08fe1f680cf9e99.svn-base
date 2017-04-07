package me.flyray.rbac.service;

import java.util.List;
import java.util.Map;

import me.flyray.rbac.entity.SysOrgEntity;

/** 
* @author: bolei
* @date：2017年4月4日 上午11:53:07 
* @description：机构组织
*/

public interface SysOrgService {

SysOrgEntity queryObject(Long id);
	
	List<SysOrgEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysOrgEntity sysOrg);
	
	void update(SysOrgEntity sysOrg);
	
	void deleteBatch(Long[] orgIds);
}
