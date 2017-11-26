package me.flyray.rbac.controller.cms;

import me.flyray.common.utils.SnowFlake;
import me.flyray.rbac.annotation.SysLog;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public R info(@PathVariable("id") String id){
		logger.info("flyray-merchant请求查询专栏信息---请求参数:{}",id);
		Parameter parameter = new Parameter("specialColumnService", "queryById");
		parameter.setId(Long.valueOf(id));
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
		String columnName= (String) params.get("columnName");
		String columnStatus = (String) params.get("columnStatus");
		String columnLogo = (String) params.get("columnLogo");
		String columnDesc = (String) params.get("columnDesc");
		Long createBy=this.getUserId();

		if (columnName==null || columnName.isEmpty()) {
			return R.error("专栏名称不能为空。");
		}
		if (columnStatus==null || (!columnStatus.equals("0") && !columnStatus.equals("1"))) {
			columnStatus = "0";
		}

		Map<String, Object> map = new HashMap<>();
		map.put("columnName", columnName);
		map.put("columnStatus", columnStatus);
		map.put("columnLogo", columnLogo);
		map.put("columnDesc", columnDesc);
		map.put("createBy", createBy);
		map.put("id", SnowFlake.getId());

		// 获得merchantId、orgId
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

		String columnName= (String) params.get("columnName");
		String columnStatus = (String) params.get("columnStatus");
		String columnLogo = (String) params.get("columnLogo");
		String columnDesc = (String) params.get("columnDesc");
		Long id = Long.valueOf(params.get("id").toString());


		if (columnName==null || columnName.isEmpty()) {
			return R.error("专栏名称不能为空。");
		}
		if (columnStatus==null || (!columnStatus.equals("0") && !columnStatus.equals("1"))) {
			columnStatus = "0";
		}

		Map<String, Object> map = new HashMap<>();
		map.put("columnName", columnName);
		map.put("columnStatus", columnStatus);
		map.put("columnLogo", columnLogo);
		map.put("columnDesc", columnDesc);
		map.put("id", id);
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
		List<Long> list= Arrays.asList(ids);
		parameter.setList(list);
		apiProvider.execute(parameter);
		
		return R.ok();
	}
	
}
