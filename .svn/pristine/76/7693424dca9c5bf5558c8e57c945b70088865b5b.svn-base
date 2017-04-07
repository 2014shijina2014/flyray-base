package me.flyray.rbac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.rbac.dao.SysOrgDao;
import me.flyray.rbac.entity.SysOrgEntity;
import me.flyray.rbac.service.SysOrgService;

/** 
* @author: bolei
* @date：2017年4月4日 上午11:53:31 
* @description：机构组织
*/

@Service("sysOrgService")
public class SysOrgServiceImpl implements SysOrgService{

	@Autowired
	private SysOrgDao sysOrgDao;
	
	@Override
	public SysOrgEntity queryObject(Long id) {
		return sysOrgDao.queryObject(id);
	}

	@Override
	public List<SysOrgEntity> queryList(Map<String, Object> map) {
		return sysOrgDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysOrgDao.queryTotal(map);
	}

	@Override
	public void save(SysOrgEntity sysOrg) {
		sysOrgDao.save(sysOrg);
	}

	@Override
	public void update(SysOrgEntity sysOrg) {
		sysOrgDao.update(sysOrg);
	}

	@Override
	public void deleteBatch(Long[] orgIds) {
		sysOrgDao.deleteBatch(orgIds);
	}
}
