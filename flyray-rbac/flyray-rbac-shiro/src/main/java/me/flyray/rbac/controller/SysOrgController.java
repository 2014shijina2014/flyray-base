package me.flyray.rbac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.rbac.entity.SysOrgEntity;
import me.flyray.rbac.service.SysOrgService;
import me.flyray.rbac.utils.Constant;
import me.flyray.rbac.utils.R;

/** 
* @author: bolei
* @date：Jul 7, 2017 10:42:43 PM 
* @description：组织机构
*/

@RestController
@RequestMapping("/sys/org")
public class SysOrgController extends AbstractController {

	@Autowired
	private SysOrgService sysOrgService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:org:list")
	public List<SysOrgEntity> list(){
		Map<String, Object> map = new HashMap<>();
		//如果不是超级管理员，则只能查询本部门及子部门数据
		if(getUserId() != Constant.SUPER_ADMIN){
			map.put("orgFilter", sysOrgService.getSubOrgIdList(getOrgId()));
		}
		List<SysOrgEntity> orgList = sysOrgService.queryList(map);

		return orgList;
	}

	/**
	 * 选择组织机构(添加、修改菜单)
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:org:select")
	public R select(){
		Map<String, Object> map = new HashMap<>();
		//如果不是超级管理员，则只能查询本部门及子部门数据
		if(getUserId() != Constant.SUPER_ADMIN){
			map.put("orgFilter", sysOrgService.getSubOrgIdList(getOrgId()));
		}
		List<SysOrgEntity> orgList = sysOrgService.queryList(map);

		//添加一级部门
		if(getUserId() == Constant.SUPER_ADMIN){
			SysOrgEntity root = new SysOrgEntity();
			root.setId(0L);
			root.setName("一级部门");
			root.setParentId(-1L);
			root.setOpen(true);
			orgList.add(root);
		}

		return R.ok().put("orgList", orgList);
	}

	/**
	 * 上级部门Id(管理员则为0)
	 */
	@RequestMapping("/info")
	@RequiresPermissions("sys:org:list")
	public R info(){
		long orgId = 0;
		if(getUserId() != Constant.SUPER_ADMIN){
			SysOrgEntity org = sysOrgService.queryObject(getOrgId());
			orgId = org.getParentId();
		}

		return R.ok().put("orgId", orgId);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{orgId}")
	@RequiresPermissions("sys:org:info")
	public R info(@PathVariable("orgId") Long orgId){
		SysOrgEntity org = sysOrgService.queryObject(orgId);
		return R.ok().put("org", org);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:org:save")
	public R save(@RequestBody SysOrgEntity org){
		sysOrgService.save(org);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:org:update")
	public R update(@RequestBody SysOrgEntity org){
		sysOrgService.update(org);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:org:delete")
	public R delete(long orgId){
		//判断是否有子部门
		List<Long> orgList = sysOrgService.queryOrgIdList(orgId);
		if(orgList.size() > 0){
			return R.error("请先删除子部门");
		}

		sysOrgService.delete(orgId);
		
		return R.ok();
	}
}
