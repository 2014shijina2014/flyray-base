package me.flyray.rest.controller.erp;

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

import me.flyray.common.exception.BusinessException;
import me.flyray.erp.api.ProductCategaryService;
import me.flyray.erp.api.ProductService;
import me.flyray.rest.controller.AbstractController;
import me.flyray.rest.util.PageUtils;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年8月26日 上午10:43:56
* @description：商户处理
*/

@RestController
@RequestMapping("/api/erp/products")
public class ProductController extends AbstractController{

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCategaryService productCategaryService;
	
	/**
	 * 商品分类
	 * 渠道号（即机构号必填）
	 * upToDate
	 */
	@ResponseBody
	@RequestMapping(value="/categary", method = RequestMethod.POST)
	public Map<String, Object> categary(@RequestBody Map<String, String> param) {
		logger.info("查询商品分类信息------start------{}",param);
		Map<String, Object> queryMap = new HashMap<>();
		if (null == param.get("id")) {
			throw new BusinessException("ERP.22","你全家都是中性！");
		}
		List<Map<String, Object>> resultMap = productCategaryService.queryList(queryMap);
		logger.info("查询商品分类信息------end------{}",resultMap);
		return ResponseHelper.success(resultMap,null, "00", "请求数据成功");
	}
	
	/**
	 * 根据条件查询商品
	 * list
	 */
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody Map<String, String> param) {
		logger.info("根据条件查询商品------start------{}",param);
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.putAll(param);
		int resultTotal = productService.queryTotal(queryMap);
		param.put("totalCount", String.valueOf(resultTotal));
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.putAll(getPagination(param));
		queryMap.put("productCategaryId", param.get("333"));
		List<Map<String, Object>> resultMap = productService.queryList(queryMap);
		logger.info("根据条件查询商品------end------{}",resultMap);
		//List<?> list, int totalCount, int pageSize, int currPage
		return ResponseHelper.success(resultMap,pageUtil, "00", "请求数据成功");
	}
}
