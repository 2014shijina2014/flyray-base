package me.flyray.rbac.controller.cms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import me.flyray.rbac.annotation.SysLog;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;

@RestController
@RequestMapping("/cms/group")
public class GroupController extends AbstractController {
	@Autowired
	private ApiProvider apiProvider;
	/**
	 * 团队类别列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cms:group:list")
	public R list(@RequestParam Map<String, Object> params){
		// 查询列表数据
		logger.info("查询团队类别列表请求参数:{}",params);
		Parameter parameter = new Parameter("interestGroupService", "queryList");
		//parameter.setMap(getCommonQueryParam());
		parameter.setMap(params);
		List<?> list = apiProvider.execute(parameter).getList();
		int total = list.size();
		logger.info("团队类别列表查询结果size:{}",total);
		PageUtils pageUtil = new PageUtils(list, total, 10, 1);
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/info/{id}")
	@RequiresPermissions("cms:group:info")
	public R info(@PathVariable("id") Long id){
		Parameter parameter = new Parameter("interestGroupService", "queryById");
		parameter.setId(id);
		Map<?,?> map=apiProvider.execute(parameter).getMap();
		return R.ok().put("group",map);
	}
	/**
	 * 添加团队类别
	 */
	@SysLog("保存团队类别")
	@RequestMapping("/save")
	@RequiresPermissions("cms:group:save")
	public R save(@RequestParam Map<String, Object> params){
		logger.info("添加团队类别---请求参数：{}",params);
		Parameter parameter=new Parameter("interestGroupService","save");
		parameter.setMap(params);
		apiProvider.execute(parameter);
		return R.ok();
	}
	/**
	 * 修改团队类别
	 */
	@SysLog("修改团队类别")
	@RequestMapping("/update")
	@RequiresPermissions("cms:group:update")
	public R update(@RequestBody Map<String, Object> params){
		logger.info("修改团队类别---请求参数{}",params);
		Parameter parameter=new Parameter("interestGroupService","update");
		parameter.setMap(params);
		apiProvider.execute(parameter);
		return R.ok();
	}
	
	/**
	 * 删除团队类别
	 */
	@SysLog("删除团队类别")
	@RequestMapping("/delete")
	@RequiresPermissions("cms:group:delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("删除团队类别---请求参数{}",ids);
		Parameter parameter=new Parameter("interestGroupService","deleteBatch");
		List<Long> list= Arrays.asList(ids);
		parameter.setList(list);
		apiProvider.execute(parameter);
		return R.ok();
	}
}
