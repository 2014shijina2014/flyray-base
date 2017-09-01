package me.flyray.rbac.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.rbac.entity.OrgUserRegRequst;
import me.flyray.rbac.entity.SysOrgEntity;
import me.flyray.rbac.entity.SysRoleEntity;
import me.flyray.rbac.entity.SysUserEntity;
import me.flyray.rbac.service.SysOrgService;
import me.flyray.rbac.service.SysRoleMenuService;
import me.flyray.rbac.service.SysRoleService;
import me.flyray.rbac.service.SysUserRoleService;
import me.flyray.rbac.service.SysUserService;
import me.flyray.rbac.utils.R;

/** 
* @author: bolei
* @date：Aug 25, 2017 11:38:20 PM 
* @description：类描述
*/

@RestController
@RequestMapping("/api/orgUser/")
public class ApiOrgUserController {

	@Autowired
	private SysOrgService sysOrgService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	
	/**
     * 添加商户用户或部门用户或渠道用户
     * 1、写机构组织表
     * 2、跟进定义好的角色写用户表
     */
    @RequestMapping(value="register",method = RequestMethod.POST)
    public R register(@RequestBody OrgUserRegRequst orgRegRequst){
    	//写机构组织表
    	SysOrgEntity sysOrg = new SysOrgEntity();
    	String orgName = orgRegRequst.getOrgName();
    	sysOrg.setName(orgName);
    	sysOrg.setOrgNo("");
    	sysOrg.setParentId(Long.valueOf(1));
    	sysOrgService.save(sysOrg);
    	Long orgId = sysOrg.getOrgId();
    	//为渠道、商户、或部门添加最大权限角色
    	SysRoleEntity sysRole = new SysRoleEntity();
    	sysRole.setRoleName("机构部门管理员");
    	//查询渠道、商户、或部门添角色对应的最大菜单权限
    	//添加机构部门具有的最大菜单权限
    	List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(Long.valueOf(1));
    	sysRole.setMenuIdList(menuIdList);
    	sysRole.setOrgId(Long.valueOf(orgId));
    	sysRoleService.save(sysRole);
    	Long roleId = sysRole.getRoleId();
    	//写用户表
    	SysUserEntity sysUser = new SysUserEntity();
    	sysUser.setOrgId(Long.valueOf(orgId));
    	sysUser.setOrgName(orgName);
    	sysUser.setPassword(DigestUtils.sha256Hex("123456"));
    	sysUser.setCreateTime(new Date());
    	sysUser.setUsername(orgName);
    	List<Long> roleIdList = new ArrayList<>();
    	roleIdList.add((long)roleId);
    	sysUser.setRoleIdList(roleIdList);
    	sysUserService.save(sysUser);
    	//写用户角色表
    	sysUserRoleService.saveOrUpdate((long)sysUser.getUserId(), roleIdList);
        return R.ok();
    }
    
    
}
