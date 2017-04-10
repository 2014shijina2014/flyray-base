package me.flyray.rbac.controller.pay;

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
* @date：2017年4月9日 下午2:47:03 
* @description：支付通道处理
*/

@RestController
@RequestMapping("/pay/payChannel")
public class PayChannelController extends AbstractController {

	@Autowired
	private ApiProvider apiProvider;
	
	/**
	 * 所有配置列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pay:payChannel:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Parameter parameter = new Parameter("payChannelService", "queryList");
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
	@RequiresPermissions("pay:payChannel:info")
	public R info(@PathVariable("id") Long id){
		
		Parameter parameter = new Parameter("payChannelService", "queryObject");
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
	@RequiresPermissions("pay:payChannel:save")
	public R save(@RequestParam Map<String, Object> params){

		Parameter parameter = new Parameter("payChannelService", "save");
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
	@RequiresPermissions("pay:payChannel:update")
	public R update(@RequestBody SysConfigEntity config){
		
		Parameter parameter = new Parameter("payChannelService", "update");
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
	@RequiresPermissions("pay:payChannel:delete")
	public R delete(@RequestBody Long[] ids){
		
		Parameter parameter = new Parameter("payChannelService", "deleteBatch");
		Map<String, Object> map = new HashMap<>();
		map.put("ids", "");
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
}
