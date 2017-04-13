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
* @date：2017年4月13日 下午9:03:20 
* @description：类说明 
*/

@RestController
@RequestMapping("/crm/merchant")
public class MerchantController extends AbstractController {

	@Autowired
	private ApiProvider apiProvider;
	
	/**
	 * 所有配置列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("crm:merchant:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Parameter parameter = new Parameter("merchantBaseService", "queryList");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", "");
		parameter.setMap(map);
		List<?> list = apiProvider.execute(parameter).getList();
		int total = list.size();
		PageUtils pageUtil = new PageUtils(list, total, 10, 1);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 配置信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("crm:merchant:info")
	public R info(@PathVariable("id") Long id){
		
		Parameter parameter = new Parameter("merchantBaseService", "queryObject");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", "");
		parameter.setMap(map);
		Map<?, ?> map1 = apiProvider.execute(parameter).getMap();
		return R.ok().put("payChannel", map1);
	}
	
	/**
	 * 保存配置
	 */
	@SysLog("保存配置")
	@RequestMapping("/save")
	@RequiresPermissions("crm:merchant:save")
	public R save(@RequestParam Map<String, Object> params){

		Parameter parameter = new Parameter("merchantBaseService", "save");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", "");
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
	/**
	 * 修改配置
	 */
	@SysLog("修改配置")
	@RequestMapping("/update")
	@RequiresPermissions("crm:merchant:update")
	public R update(@RequestBody SysConfigEntity config){
		
		Parameter parameter = new Parameter("merchantBaseService", "update");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", "");
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
	/**
	 * 删除配置
	 */
	@SysLog("删除配置")
	@RequestMapping("/delete")
	@RequiresPermissions("crm:merchant:delete")
	public R delete(@RequestBody Long[] ids){
		
		Parameter parameter = new Parameter("merchantBaseService", "deleteBatch");
		Map<String, Object> map = new HashMap<>();
		map.put("ids", "");
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
}
