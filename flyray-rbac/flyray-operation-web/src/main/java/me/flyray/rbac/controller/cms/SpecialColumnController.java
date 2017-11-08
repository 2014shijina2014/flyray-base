package me.flyray.rbac.controller.cms;

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
* @date：2017年10月9日 下午6:35:05
* @description：专栏后台管理
*/

@RestController
@RequestMapping("/cms/specialColumn")
public class SpecialColumnController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(SpecialColumnController.class);
	
	@Autowired
	private ApiProvider apiProvider;
	
	/**
	 * 专栏列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cms:specialColumn:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		logger.info("flyray-merchant请求查询专栏列表---请求参数:{}",params);
		Parameter parameter = new Parameter("specialColumnService", "queryList");
		parameter.setMap(getCommonQueryParam());
		Map<String, Object> map = new HashMap<>();
		parameter.setMap(map);
		List<?> list = apiProvider.execute(parameter).getList();
		int total = list.size();
		logger.info("flyray-merchant请求查询专栏列表---查询结果size:{}",total);
		PageUtils pageUtil = new PageUtils(list, total, 10, 1);
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 专栏信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("cms:specialColumn:info")
	public R info(@PathVariable("id") Long id){
		logger.info("flyray-merchant请求查询专栏信息---请求参数:{}",id);
		Parameter parameter = new Parameter("specialColumnService", "queryById");
		parameter.setId(id);
		Map<?, ?> map = apiProvider.execute(parameter).getMap();
		logger.info("flyray-merchant请求查询专栏信息---返回参数:{}",map);
		return R.ok().put("specialColumn", map);
	}
	
	/**
	 * 添加专栏
	 */
	@SysLog("保存配置")
	@RequestMapping("/save")
	@RequiresPermissions("cms:specialColumn:save")
	public R save(@RequestBody Map<String, Object> params){
		
		logger.info("flyray-merchant保存专栏信息---请求参数：{}",params);
		Parameter parameter = new Parameter("specialColumnService", "save");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", params.get("payChannelNo"));
		map.put("payCompanyNo", params.get("payCompanyNo"));
		map.put("feeRatio", params.get("feeRatio"));
		map.putAll(getCommonSaveParam());
		parameter.setMap(map);
		apiProvider.execute(parameter);
		return R.ok();
		
	}
	
	/**
	 * 修改专栏
	 */
	@SysLog("修改配置")
	@RequestMapping("/update")
	@RequiresPermissions("cms:specialColumn:update")
	public R update(@RequestBody Map<String, Object> params){
		
		logger.info("flyray-merchant修改专栏信息---请求参数{}",params);
		Parameter parameter = new Parameter("specialColumnService", "update");
		Map<String, Object> map = new HashMap<>();
		map.put("payChannelNo", params.get("payChannelNo"));
		map.put("payCompanyNo", params.get("payCompanyNo"));
		map.put("feeRatio", params.get("feeRatio"));
		map.put("id", params.get("id"));
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
	/**
	 * 删除专栏
	 */
	@SysLog("删除配置")
	@RequestMapping("/delete")
	@RequiresPermissions("cms:specialColumn:delete")
	public R delete(@RequestBody Long[] ids){
		
		Parameter parameter = new Parameter("specialColumnService", "deleteBatch");
		Map<String, Object> map = new HashMap<>();
		map.put("ids", ids);
		parameter.setMap(map);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
}
