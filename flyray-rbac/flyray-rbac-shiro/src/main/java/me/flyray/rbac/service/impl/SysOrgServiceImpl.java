package me.flyray.rbac.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiniu.util.StringUtils;

import me.flyray.rbac.dao.SysOrgDao;
import me.flyray.rbac.entity.SysOrgEntity;
import me.flyray.rbac.service.SysOrgService;

/** 
* @author: bolei
* @date：Jul 7, 2017 10:45:04 PM 
* @description：组织机构
*/

@Service("sysOrgService")
public class SysOrgServiceImpl implements SysOrgService{

	@Autowired
	private SysOrgDao sysOrgDao;
	
	@Override
	public SysOrgEntity queryObject(Long orgId) {
		return sysOrgDao.queryObject(orgId);
	}

	@Override
	public List<SysOrgEntity> queryList(Map<String, Object> map) {
		return sysOrgDao.queryList(map);
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
	public void delete(Long orgId) {
		sysOrgDao.delete(orgId);
	}

	@Override
	public List<Long> queryOrgIdList(Long parentId) {
		return sysOrgDao.queryOrgIdList(parentId);
	}

	@Override
	public String getSubOrgIdList(Long orgId) {
		//部门及子部门ID列表
		List<Long> orgIdList = new ArrayList<>();

		//获取子部门ID
		List<Long> subIdList = queryOrgIdList(orgId);
		getOrgTreeList(subIdList, orgIdList);

		//添加本部门
		orgIdList.add(orgId);

		String orgFilter = StringUtils.join(orgIdList, ",");
		return orgFilter;
	}
	
	/**
	 * 递归
	 */
	public void getOrgTreeList(List<Long> subIdList, List<Long> orgIdList){
		for(Long deptId : subIdList){
			List<Long> list = queryOrgIdList(deptId);
			if(list.size() > 0){
				getOrgTreeList(list, orgIdList);
			}
			orgIdList.add(deptId);
		}
	}

}
