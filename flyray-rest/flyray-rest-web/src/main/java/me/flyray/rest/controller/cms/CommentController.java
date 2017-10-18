package me.flyray.rest.controller.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.cms.api.CommentService;
import me.flyray.cms.model.Comment;
import me.flyray.common.utils.BeanUtils;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.model.CustomerBase;
import me.flyray.rest.controller.AbstractController;
import me.flyray.rest.util.PageUtils;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年10月11日 下午4:47:53
* @description：cms模块的所有评论出来 
*/

@RestController
@RequestMapping("/api/cms/comments")
public class CommentController extends AbstractController{

	@Autowired
	private CommentService commentService;
	@Autowired
	private CustomerBaseService customerBaseService;
	
	/**
	 * 查询观点评论 
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> queryComment(@RequestBody Map<String, String> param) {
		logger.info("查询观点评论 ---start---{}",param);
		String currentPage = param.get("currentPage");//当前页
		String pageSize = param.get("pageSize");//条数
		String commentTargetId = param.get("commentTargetId");//观点编号
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("commentModuleNo", 1);
		queryMap.put("commentTargetId", commentTargetId);
		Integer total = commentService.queryTotal(queryMap);
		logger.info("查询观点评论 ---total---{}",total);
		param.put("totalCount", String.valueOf(total));
		int pageSizeInt = Integer.valueOf(pageSize);
		PageUtils pageUtil = new PageUtils(total, pageSizeInt, Integer.valueOf(currentPage));
		logger.info("查询观点评论 ---pageUtil---{}",pageUtil.toString());
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.putAll(getPagination(param));
		
		List<Comment> commentList = commentService.query(queryMap);
		return ResponseHelper.success(commentList,pageUtil, "00", "查询成功");
	}
	
	/**
	 * 查询观点评论 
	 * 查询多级评论
	 */
	@ResponseBody
	@RequestMapping(value="/queryMany", method = RequestMethod.POST)
	public Map<String, Object> queryTwo(@RequestBody Map<String, String> param) {
		logger.info("查询观点评论 ---start---{}",param);
		String commentTargetId = param.get("commentTargetId");//观点编号
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("commentModuleNo", 1);
		queryMap.put("commentTargetId", commentTargetId);
		List<Comment> commentList = commentService.query(queryMap);
		List<Map<String, Object>> resultMaps = new ArrayList<>();
		Map<String, Object> resultMap;
		for (Comment comment : commentList) {
			try {
				resultMap = new HashMap<>();
				resultMap.putAll(BeanUtils.objectToMap(comment));
				Map<String, Object> subQueryMap = new HashMap<>();
				subQueryMap.put("commentModuleNo", 1);
				subQueryMap.put("commentTargetId", commentTargetId);
				subQueryMap.put("commentType", 2);//查询类型为回复的
				subQueryMap.put("parentId", comment.getId());//查询类型为回复的
				List<Map<String, Object>> subCommentList = commentService.queryList(subQueryMap);
				resultMap.put("subComents", subCommentList);
				resultMaps.add(resultMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ResponseHelper.success(resultMaps,null, "00", "查询成功");
	}
	
	/**
	 * 观点回复添加
	 */
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Map<String, Object> addPointComment(@RequestBody Map<String, Object> param) {
		logger.info("观点回复添加 ---start---{}",param);
		String commentType = (String) param.get("commentType");//1评论2回复
		String commentBy = (String) param.get("commentBy");
		CustomerBase custome = customerBaseService.queryByCustomerId(Long.valueOf(commentBy));
		param.put("commentByName", custome.getNickname());
		if ("1".equals(commentType)) {
			//1、评论
			
		} else if("2".equals(commentType)) {
			//2、回复
			Integer commentTargetUserId = (Integer) param.get("commentTargetUserId");
			CustomerBase targetCustome = customerBaseService.queryByCustomerId(Long.valueOf(commentBy));
			param.put("commentTargetUserName", targetCustome.getNickname());
			param.put("commentTargetUserId", commentTargetUserId);
		}
		try {
			logger.info("观点回复添加 ---查询完用户名后---{}",param);
			Comment comment = commentService.savePointComment(param);
			logger.info("观点回复添加 ---comment---{}",comment.toString());
			return ResponseHelper.success(comment,null, "00", "评论成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseHelper.success(null,null, "01", "评论异常");
	}
}
