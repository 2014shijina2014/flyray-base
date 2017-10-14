package me.flyray.rbac.controller.cms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.cms.api.TopicService;
import me.flyray.rbac.annotation.SysLog;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;

@RestController
@RequestMapping("/cms/topic")
public class TopicController extends AbstractController {
	@Autowired
	private TopicService topicService;
	@Autowired
	private ApiProvider apiProvider;
	/**
	 * 话题列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cms:topic:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		logger.info("flyray-operation话题列表---请求参数:{}",params);
		Parameter parameter = new Parameter("topicService", "queryList");
		parameter.setMap(getCommonQueryParam());
		Map<String, Object> map = new HashMap<>();
		parameter.setMap(map);
		List<?> list = apiProvider.execute(parameter).getList();
		int total = list.size();
		logger.info("flyray-operation话题列表---查询结果size:{}",total);
		PageUtils pageUtil = new PageUtils(list, total, 10, 1);
		return R.ok().put("page", pageUtil);
	}
	/**
	 * 添加话题
	 */
	@SysLog("保存话题")
	@RequestMapping("/save")
	@RequiresPermissions("cms:topic:save")
	public R save(@RequestBody Map<String, Object> params){
		
		logger.info("flyray-merchant保存专栏信息---请求参数：{}",params);
		
		return R.ok();
		
	}
	/**
	 * 修改话题
	 */
	@SysLog("修改话题")
	@RequestMapping("/update")
	@RequiresPermissions("cms:topic:update")
	public R update(@RequestBody Map<String, Object> params){
		
		logger.info("flyray-merchant修改专栏信息---请求参数{}",params);
		
		return R.ok();
	}
}
