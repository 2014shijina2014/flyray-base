package me.flyray.rbac.controller.erp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.rbac.annotation.SysLog;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;

/** 
* @author: bolei
* @date：2017年9月16日 上午11:23:59
* @description：商品管理
*/

@RestController
@RequestMapping("/erp/product")
public class ProductController extends AbstractController {

private static final Logger logger = LoggerFactory.getLogger(ProductCategaryController.class);
	
	@Autowired
	private ApiProvider apiProvider;
	
	/**
	 * 所有客户会员列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("erp:productCategary:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Parameter parameter = new Parameter("productCategaryService", "queryList");
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
	@RequiresPermissions("erp:productCategary:info")
	public R info(@PathVariable("id") Long id){
		Parameter parameter = new Parameter("productCategaryService", "queryById");
		parameter.setId(id);
		Map<?, ?> map1 = apiProvider.execute(parameter).getMap();
		return R.ok().put("payChannel", map1);
	}
	
	/**
	 * 保存客户会员
	 */
	@SysLog("保存商品分类")
	@RequestMapping("/save")
	@RequiresPermissions("erp:productCategary:save")
	public R save(@RequestBody Map<String, Object> params){
		Parameter parameter = new Parameter("productCategaryService", "save");
		Map<String, Object> map = new HashMap<>();
		map.put("orgId", "1");
		map.put("merchantId", "1");
		map.put("categaryName", params.get("categaryName"));
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
	/**
	 * 修改客户会员
	 */
	@SysLog("修改客户会员")
	@RequestMapping("/update")
	@RequiresPermissions("erp:productCategary:update")
	public R update(@RequestBody Map<String, Object> params){
		Parameter parameter = new Parameter("productCategaryService", "update");
		Map<String, Object> map = new HashMap<>();
		map.put("id", params.get("id"));
		map.put("orgId", params.get("orgId"));
		map.put("merchantNo", params.get("merchantNo"));
		map.put("categaryName", params.get("categaryName"));
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
	/**
	 * 删除客户会员
	 */
	@SysLog("删除客户会员")
	@RequestMapping("/delete")
	@RequiresPermissions("erp:productCategary:delete")
	public R delete(@RequestBody Long[] ids){
		
		Parameter parameter = new Parameter("productCategaryService", "deleteBatch");
		Map<String, Object> map = new HashMap<>();
		map.put("ids", "");
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
}
