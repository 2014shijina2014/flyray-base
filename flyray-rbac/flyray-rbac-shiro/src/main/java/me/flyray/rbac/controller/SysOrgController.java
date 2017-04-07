package me.flyray.rbac.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.rbac.annotation.SysLog;
import me.flyray.rbac.entity.SysOrgEntity;
import me.flyray.rbac.service.SysOrgService;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.Query;
import me.flyray.rbac.utils.R;

/** 
* @author: bolei
* @date：2017年4月4日 下午12:04:44 
* @description：组织机构
*/

@RestController
@RequestMapping("/sys/org")
public class SysOrgController extends AbstractController{

	@Autowired
	private SysOrgService sysOrgService;
	
	/**
	 * 所有机构组织列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:org:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<SysOrgEntity> orgList = sysOrgService.queryList(query);
		int total = sysOrgService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orgList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 组织机构信息
	 */
	@RequestMapping("/info/{orgId}")
	@RequiresPermissions("sys:org:info")
	public R info(@PathVariable("orgId") Long orgId){
		SysOrgEntity org = sysOrgService.queryObject(orgId);
		return R.ok().put("org", org);
	}
	
	/**
	 * 保存组织机构信息
	 */
	@SysLog("保存组织机构")
	@RequestMapping("/save")
	@RequiresPermissions("sys:org:save")
	public R save(@RequestBody SysOrgEntity org){
		sysOrgService.save(org);
		return R.ok();
	}
	
	/**
	 * 修改组织机构信息
	 */
	@SysLog("修改组织机构信息")
	@RequestMapping("/update")
	@RequiresPermissions("sys:org:update")
	public R update(@RequestBody SysOrgEntity org){
		sysOrgService.update(org);
		return R.ok();
	}
	
	/**
	 * 删除组织机构
	 */
	@SysLog("删除组织机构")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:org:delete")
	public R delete(@RequestBody Long[] orgIds){
		
		sysOrgService.deleteBatch(orgIds);
		
		return R.ok();
	}
}
