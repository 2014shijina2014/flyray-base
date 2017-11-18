package me.flyray.rbac.controller.cms;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me.flyray.cms.api.TopicService;
import me.flyray.cms.model.Topic;
import me.flyray.common.utils.ImageBase64;
import me.flyray.common.utils.SnowFlake;
import me.flyray.rbac.annotation.SysLog;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.entity.SysUserEntity;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.BaseModel;
import me.flyray.rest.model.Parameter;

@RestController
@RequestMapping("/cms/topic")
public class TopicController extends AbstractController {
	@Autowired
	private ApiProvider apiProvider;
	@Value("${rest_home_imgPath}")
	private String imgPath;
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
		parameter.setMap(params);
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
	public R save(@RequestParam Map<String, Object> params){
		
		logger.info("flyray-merchant保存专栏信息---请求参数：{}",params);
		Map<String, Object> map = new HashMap<String, Object>();
	    String content = (String)params.get("content");
	    String discription = (String)params.get("discription");
	    String title = (String)params.get("title");
		String imgFile64 = (String)params.get("imgFile");
		String id = (String)params.get("id");
		
		map.put("content", content);
		map.put("discription", discription);
		map.put("title", title);
		map.put("createBy", getUserId());
		map.put("createTime", new Timestamp(new Date().getTime()));
		if (!"".equals(imgFile64)  && null != imgFile64) {
			String img64[] = imgFile64.split(",");
			String imgFileName = (String)params.get("imgFileName");
			String suffix = imgFileName.substring(imgFileName.lastIndexOf(".") + 1);  
			Long time = new Date().getTime();
			String newName = time + "." + suffix;
			String url = imgPath + File.separator + id + File.separator + newName;
			Boolean flag = ImageBase64.generateImage(img64[1], url);
			map.put("img", newName);
		}
		if(id==null ||"".equals(id)) {
			 id = SnowFlake.getId()+"";
			 map.put("id", id);
				Parameter parameter = new Parameter("topicService", "save");
				parameter.setMap(map);
				apiProvider.execute(parameter);
		}else {
			map.put("id", id);
			Parameter parameter = new Parameter("topicService", "update");
			parameter.setMap(map);
			apiProvider.execute(parameter);
		}
		

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
	/**
	 * 获取单个话题详情
	 */
	@RequestMapping("/info/{topicId}")
	@RequiresPermissions("cms:topic:info")
	public R info(@PathVariable("topicId") Long topicId){
		Parameter parameter = new Parameter("topicService", "queryById");
		parameter.setId(topicId);
		Map<?, ?> map1 = apiProvider.execute(parameter).getMap();
		
		return R.ok().put("topic", map1);
	}
}
