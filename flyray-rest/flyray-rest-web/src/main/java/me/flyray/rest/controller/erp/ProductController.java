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

import me.flyray.crm.enums.BillingType;
import me.flyray.crm.model.CustomerAccount;
import me.flyray.crm.model.CustomerBilling;
import me.flyray.erp.api.ProductCategaryService;
import me.flyray.erp.api.ProductService;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年8月26日 上午10:43:56
* @description：商户处理
*/

@RestController
@RequestMapping("/api/erp/products")
public class ProductController {

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
		List<Map<String, Object>> resultMap = productCategaryService.queryList(queryMap);
		logger.info("查询商品分类信息------end------{}",resultMap);
		return ResponseHelper.success(resultMap, "00", "请求数据成功");
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
		queryMap.put("productCategaryId", "1");
		List<Map<String, Object>> resultMap = productService.queryList(queryMap);
		logger.info("根据条件查询商品------end------{}",resultMap);
		return ResponseHelper.success(resultMap, "00", "请求数据成功");
	}
}
