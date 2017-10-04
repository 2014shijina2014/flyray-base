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

import me.flyray.cms.api.SpecialColumnService;
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
	
	/**
	 * 根据条件查询专栏信息
	 * list
	 */
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody Map<String, String> param) {
		logger.info("根据条件查询专栏信息------start------{}",param);
		Map<String, Object> queryMap = new HashMap<>();
		int resultTotal = columnService.queryTotal(queryMap);
		param.put("totalCount", String.valueOf(resultTotal));
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.putAll(getPagination(param));
		queryMap.put("productCategaryId", param.get("333"));
		List<Map<String, Object>> resultMap = columnService.queryList(queryMap);
		logger.info("根据条件查询专栏信息------end------{}",resultMap);
		//List<?> list, int totalCount, int pageSize, int currPage
		return ResponseHelper.success(resultMap,pageUtil, "00", "请求数据成功");
	}
}
