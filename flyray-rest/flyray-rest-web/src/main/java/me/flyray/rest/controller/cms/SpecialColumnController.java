package me.flyray.rest.controller.cms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.cms.api.CustomerSpecialColumnService;
import me.flyray.cms.api.SpecialColumnContentService;
import me.flyray.cms.api.SpecialColumnService;
import me.flyray.cms.model.SpecialColumn;
import me.flyray.cms.model.SpecialColumnContent;
import me.flyray.common.exception.BusinessException;
import me.flyray.rest.controller.AbstractController;
import me.flyray.rest.util.PageUtils;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年10月4日 上午11:05:24
* @description：专栏相关请求
*/

@RestController
@RequestMapping("/api/cms/specialColumns")
public class SpecialColumnController extends AbstractController{

	@Autowired
	private SpecialColumnService columnService;
	@Autowired
	private CustomerSpecialColumnService customerSpecialColumnService;
	@Autowired
	private SpecialColumnContentService specialColumnContentService;
	
	/**
	 * 根据条件查询专栏信息
	 * list
	 */
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody Map<String, String> param) {
		logger.info("根据条件查询专栏信息------start------{}",param);
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.putAll(param);
		int resultTotal = columnService.queryTotal(queryMap);
		param.put("totalCount", String.valueOf(resultTotal));
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.putAll(getPagination(param));
		List<Map<String, Object>> resultMap = columnService.queryList(queryMap);
		logger.info("根据条件查询专栏信息------end------{}",resultMap);
		//List<?> list, int totalCount, int pageSize, int currPage
		return ResponseHelper.success(resultMap,pageUtil, "00", "请求数据成功");
	}
	
	/**
	 * 查询会员的订阅
	 * list
	 */
	@ResponseBody
	@RequestMapping(value="/customer", method = RequestMethod.POST)
	public Map<String, Object> customer(@RequestBody Map<String, String> param) {
		logger.info("根据会员customerId查询专栏信息------start------{}",param);
		Map<String, Object> queryMap = new HashMap<>();
		if (null == param.get("customerId")) {
			throw new BusinessException("CMS.22","customerId不能为空");
		}
		queryMap.putAll(param);
		//查询出我的订阅专栏的总数
		int resultTotal = customerSpecialColumnService.queryTotal(queryMap);
		param.put("totalCount", String.valueOf(resultTotal));
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.putAll(getPagination(param));
		//根据会员与专栏的关系表查出该会员下的专栏信息
		List<SpecialColumn> resultMap = columnService.queryCustomerColumnsList(queryMap);
		logger.info("根据会员customerId查询专栏信息------end------{}",resultMap);
		//List<?> list, int totalCount, int pageSize, int currPage
		return ResponseHelper.success(resultMap,pageUtil, "00", "请求数据成功");
	}
	
	/**
	 * 根据专栏Id查询专栏内容
	 * contents
	 */
	@ResponseBody
	@RequestMapping(value="/contents", method = RequestMethod.POST)
	public Map<String, Object> contents(@RequestBody Map<String, String> param) {
		logger.info("根据specialColumnId查询专栏内容------start------{}",param);
		Map<String, Object> queryMap = new HashMap<>();
		if (null == param.get("specialColumnId")) {
			throw new BusinessException("CMS.23","specialColumnId不能为空");
		}
		queryMap.putAll(param);
		//查询出专栏Id下的内容总数
		int resultTotal = specialColumnContentService.queryTotal(queryMap);
		param.put("totalCount", String.valueOf(resultTotal));
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.putAll(getPagination(param));
		//查询出专栏Id下的内容
		List<Map<String, Object>> columnContentMap = specialColumnContentService.queryList(queryMap);
		//根据会员与专栏id查询用户是否订阅该专栏
		int subscribeCount = customerSpecialColumnService.queryTotal(queryMap);
		String isSubscribe = "1";
		if (subscribeCount > 0) {
			isSubscribe = "0";
		}
		//查询出专栏信息
		Map<String, Object> specialColumn = columnService.queryById(Long.valueOf(param.get("specialColumnId")));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("columnContents", columnContentMap);
		resultMap.put("isSubscribe", isSubscribe);
		resultMap.put("specialColumn", specialColumn);
		logger.info("根据specialColumnId查询专栏内容------end------{}",resultMap);
		//List<?> list, int totalCount, int pageSize, int currPage
		return ResponseHelper.success(resultMap,pageUtil, "00", "请求数据成功");
	}
	
	/**
	 * 订阅一个专栏
	 */
	@ResponseBody
	@RequestMapping(value="/subscribe", method = RequestMethod.POST)
	public Map<String, Object> subscribe(@RequestBody Map<String, Object> param) {
		logger.info("订阅一个专栏------start------{}",param);
		if (null == param.get("specialColumnId")) {
			throw new BusinessException("CMS.24","specialColumnId不能为空");
		}
		customerSpecialColumnService.save(param);
		logger.info("订阅一个专栏------end------{}",param);
		return ResponseHelper.success(null,null, "00", "请求数据成功");
	}
	
	/**
	 * 取消订阅一个专栏
	 */
	@ResponseBody
	@RequestMapping(value="/unsubscribe", method = RequestMethod.POST)
	public Map<String, Object> unsubscribe(@RequestBody Map<String, String> param) {
		logger.info("取消订阅一个专栏------start------{}",param);
		if (null == param.get("specialColumnId")) {
			throw new BusinessException("CMS.24","specialColumnId不能为空");
		}
		customerSpecialColumnService.unsubscribe(param);
		logger.info("取消订阅一个专栏------end------{}",param);
		return ResponseHelper.success(null,null, "00", "请求数据成功");
	}
	
	
	/**
	 * 根据专栏内容Id查询具体内容
	 */
	@ResponseBody
	@RequestMapping(value="/contentDetail", method = RequestMethod.POST)
	public Map<String, Object> contentDetail(@RequestBody Map<String, String> param) {
		logger.info("根据specialColumnContentId查询专栏内容------start------{}",param);
		if (null == param.get("specialColumnContentId")) {
			throw new BusinessException("CMS.23","specialColumnId不能为空");
		}
		SpecialColumnContent sc = new SpecialColumnContent();
		sc.setId(Long.valueOf(param.get("specialColumnContentId")));
		SpecialColumnContent resultMap = specialColumnContentService.queryEntity(sc);
		logger.info("根据specialColumnContentId查询专栏内容------end------{}",resultMap);
		return ResponseHelper.success(resultMap,null, "00", "请求数据成功");
	}
	
}
