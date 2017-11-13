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
@RequestMapping("/cms/groupcategory")
public class GroupCategoryController extends AbstractController {
	@Autowired
	private ApiProvider apiProvider;
	/**
	 * 团队类别列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cms:groupcategory:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		logger.info("查询团队类别列表请求参数:{}",params);
		Parameter parameter = new Parameter("interestGroupCategoryService", "queryList");
		//parameter.setMap(getCommonQueryParam());
		parameter.setMap(params);
		List<?> list = apiProvider.execute(parameter).getList();
		int total = list.size();
		logger.info("团队类别列表查询结果size:{}",total);
		PageUtils pageUtil = new PageUtils(list, total, 10, 1);
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/info/{id}")
	@RequiresPermissions("cms:groupcategory:info")
	public R info(@PathVariable("id") Long id){
		Parameter parameter = new Parameter("interestGroupCategoryService", "queryById");
		parameter.setId(id);
		Map<?,?> map=apiProvider.execute(parameter).getMap();
		return R.ok().put("groupcategory",map);
	}
	/**
	 * 添加团队类别
	 */
	@SysLog("保存团队类别")
	@RequestMapping("/save")
	@RequiresPermissions("cms:groupcategory:save")
	public R save(@RequestParam Map<String, Object> params){
		logger.info("添加团队类别---请求参数：{}",params);
		Parameter parameter=new Parameter("customerRoleService","save");
		parameter.setMap(params);
		apiProvider.execute(parameter);
		return R.ok();
		
	}
	/**
	 * 修改团队类别
	 */
	@SysLog("修改团队类别")
	@RequestMapping("/update")
	@RequiresPermissions("cms:groupcategory:update")
	public R update(@RequestBody Map<String, Object> params){
		logger.info("修改团队类别---请求参数{}",params);
		Parameter parameter=new Parameter("customerRoleService","save");
		parameter.setMap(params);
		apiProvider.execute(parameter);
		return R.ok();
	}
	
	/**
	 * 删除团队类别
	 */
	@SysLog("删除团队类别")
	@RequestMapping("/delete")
	@RequiresPermissions("cms:groupcategory:delete")
	public R delete(@RequestBody Long[] ids){
		Parameter parameter=new Parameter("customerRoleService","deleteBatch");
		List<Long> list= Arrays.asList(ids);
		parameter.setList(list);
		apiProvider.execute(parameter);
		return R.ok();
	}
}
