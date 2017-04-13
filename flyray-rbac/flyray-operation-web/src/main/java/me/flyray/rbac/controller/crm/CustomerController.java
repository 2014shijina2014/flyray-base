package me.flyray.rbac.controller.crm;

import java.util.HashMap;
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
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.entity.SysConfigEntity;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;

/** 
* @author: bolei
* @date：2017年4月13日 下午9:01:08 
* @description：客户会员信息
*/

@RestController
@RequestMapping("/crm/customer")
public class CustomerController extends AbstractController {

	@Autowired
	private ApiProvider apiProvider;
	
	/**
	 * 所有客户会员列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("crm:customer:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Parameter parameter = new Parameter("customerBaseService", "queryList");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", "");
		parameter.setMap(map);
		List<?> list = apiProvider.execute(parameter).getList();
		int total = list.size();
		PageUtils pageUtil = new PageUtils(list, total, 10, 1);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 客户会员信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("crm:customer:info")
	public R info(@PathVariable("id") Long id){
		
		Parameter parameter = new Parameter("customerBaseService", "queryObject");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", "");
		parameter.setMap(map);
		Map<?, ?> map1 = apiProvider.execute(parameter).getMap();
		return R.ok().put("payChannel", map1);
	}
	
	/**
	 * 保存客户会员
	 */
	@SysLog("保存客户会员")
	@RequestMapping("/save")
	@RequiresPermissions("crm:customer:save")
	public R save(@RequestParam Map<String, Object> params){

		Parameter parameter = new Parameter("customerBaseService", "save");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", "");
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
	/**
	 * 修改客户会员
	 */
	@SysLog("修改客户会员")
	@RequestMapping("/update")
	@RequiresPermissions("crm:customer:update")
	public R update(@RequestBody SysConfigEntity config){
		
		Parameter parameter = new Parameter("customerBaseService", "update");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", "");
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
	/**
	 * 删除客户会员
	 */
	@SysLog("删除客户会员")
	@RequestMapping("/delete")
	@RequiresPermissions("crm:customer:delete")
	public R delete(@RequestBody Long[] ids){
		
		Parameter parameter = new Parameter("customerBaseService", "deleteBatch");
		Map<String, Object> map = new HashMap<>();
		map.put("ids", "");
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
}
