package me.flyray.rest.controller.cms;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.cms.api.CommentService;
import me.flyray.cms.api.TopicService;
import me.flyray.cms.model.Comment;
import me.flyray.cms.model.Topic;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.model.CustomerBase;
import me.flyray.rest.controller.AbstractController;
import me.flyray.rest.util.PageUtils;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年3月7日 下午8:13:48 
* @description：话题
*/

@RestController
@RequestMapping("/api/cms/topics")
public class TopicController extends AbstractController{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TopicService topicService;
	@Autowired
	private CustomerBaseService customerBaseService;
	@Autowired
	private CommentService commentService;
	/**
	  * 查询话题
	  * query
	  */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> create(@RequestBody Map<String, String> param) {
		logger.info("请求查询话题---start---{}",param);
		String currentPage = param.get("currentPage");//当前页
		String pageSize = param.get("pageSize");//条数
		String createBy = param.get("createBy");//用户编号
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<>();
		Integer total = topicService.queryTotal(queryMap);
		param.put("totalCount", String.valueOf(total));
		int pageSizeInt = Integer.valueOf(pageSize);
		PageUtils pageUtil = new PageUtils(total, pageSizeInt, Integer.valueOf(currentPage));
		logger.info("请求观点---pageUtil---{}",pageUtil.toString());
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.putAll(getPagination(param));
		List list =  topicService.queryList(queryMap);
		
		return ResponseHelper.success(list,pageUtil, "00", "查询成功");
	}
	/**
	 * 查询话题详情
	 */
	@ResponseBody
	@RequestMapping(value="/info", method = RequestMethod.POST)
	public Map<String, Object> info(@RequestBody Map<String, Object> param) {
		logger.info("查询话题详情开始{}",param);
		Topic topic = topicService.queryTopicInfo(param);
		if(topic != null){
			return ResponseHelper.success(topic,null, "00", "查询详情正常");
		}else{
			return ResponseHelper.success(null,null, "01", "查询详情异常");
		}
		
	}
	/**
	 * 查询评论
	 */
	@ResponseBody
	@RequestMapping(value="/queryCommit", method = RequestMethod.POST)
	public Map<String, Object> queryCommit(@RequestBody Map<String, String> param) {
		logger.info("请求查询话题---start---{}",param);
		String currentPage = param.get("currentPage");//当前页
		String pageSize = param.get("pageSize");//条数
		String createBy = param.get("createBy");//用户编号
		String id = param.get("id");//话题编号
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<>();
		Integer total = commentService.queryTotal(queryMap);
		int pageSizeInt = Integer.valueOf(pageSize);
		PageUtils pageUtil = new PageUtils(total, pageSizeInt, Integer.valueOf(currentPage));
		param.put("totalCount", total.toString());
		logger.info("请求查询话题--pageUtil---{}",pageUtil.toString());
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.put("commentType", "1");
		queryMap.put("commentTargetId", id);
		queryMap.put("commentModuleNo", "2");
		List<Comment> list = commentService.query(queryMap);
		logger.info("请求查询话题--list---{}",list.toString());
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);  
		for (Object object : list) {
			Comment comment = (Comment) object;
			Long uid = comment.getCommentBy();
			CustomerBase customer = customerBaseService.queryByCustomerId(uid);
			comment.setCommentImg(customer.getAvatar());
			String time = sdf.format(comment.getCommentTime());
			comment.setCommentTimes(time);
		}
		
		return ResponseHelper.success(list,pageUtil, "00", "查询成功");
	}
	/**
	 * 添加评论
	 */
	@ResponseBody
	@RequestMapping(value="/addComment", method = RequestMethod.POST)
	public Map<String, Object> addComment(@RequestBody Map<String, Object> param) {
		String commentBy = (String) param.get("commentBy");
		//根据commentBy查询用户名
		CustomerBase custome = customerBaseService.queryByCustomerId(Long.valueOf(commentBy));
		param.put("commentByName", custome.getNickname());
		commentService.saveAll(param);
		return ResponseHelper.success(null,null, "01", "评论异常");
	}
}
