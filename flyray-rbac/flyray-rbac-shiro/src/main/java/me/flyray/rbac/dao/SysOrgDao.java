package me.flyray.rbac.dao;

import java.util.List;

import me.flyray.rbac.entity.SysOrgEntity;

/** 
* @author: bolei
* @date：Jul 7, 2017 11:04:52 PM 
* @description：组织机构
*/

public interface SysOrgDao extends BaseDao<SysOrgEntity>{

	/**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Long> queryOrgIdList(Long parentId);
}
