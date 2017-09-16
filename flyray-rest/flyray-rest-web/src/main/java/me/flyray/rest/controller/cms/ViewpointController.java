package me.flyray.rest.controller.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.cms.api.ActivityService;
import me.flyray.cms.api.CmsViewPointService;
import me.flyray.cms.model.CmsViewPoint;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.model.CustomerBase;
import me.flyray.rest.model.ViewPointItem;
import me.flyray.rest.util.Pager;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年8月19日 下午2:00:46
* @description：首页圈子
*/

@Controller
@RequestMapping("/api/cms/viewpoints")
public class ViewpointController {
	@Autowired
	private CmsViewPointService cmsViewPointService;
	@Autowired
	private CustomerBaseService customerBaseService;
	/**
	 * 添加观点
	 */
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Map<String, Object> add(@RequestBody Map<String, Object> param) {
		CmsViewPoint cmsViewPoint = new CmsViewPoint();
		String pointText = (String)param.get("pointText");
		cmsViewPoint.setPointText(pointText);
		cmsViewPointService.save(cmsViewPoint);
		return ResponseHelper.success(param, "00", "添加成功");
	}
	/**
	 * 分页查询
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> query(@RequestBody Map<String, Object> param) {
		String currentPage = (String) param.get("currentPage");//当前页
		String pageSize = (String) param.get("pageSize");//条数
		Map<String, Object> map = new HashMap<String, Object>();
		Integer total = cmsViewPointService.queryTotal();
		if(currentPage == null || currentPage == ""){
			currentPage = "1";
		}
		if(pageSize == null || pageSize == ""){
			pageSize = "10";
		}
		Pager Page = new Pager(Integer.valueOf(currentPage), Integer.valueOf(pageSize), total);
		//int current_page, int page_size, int total_count
		map.put("offset", Page.getStart_size());//开始行索引
		map.put("limit", Page.getPage_size());//每页条数
		List<CmsViewPoint> videoPointList = cmsViewPointService.queryList(map);
		List<ViewPointItem> itemList = new ArrayList<ViewPointItem>();
		for (CmsViewPoint cmsViewPoint : videoPointList) {
			ViewPointItem item = new ViewPointItem();
			item.setCmsViewPoint(cmsViewPoint);
			if(cmsViewPoint.getCustomerId() != null){
				CustomerBase customer = customerBaseService.queryByCustomerId(cmsViewPoint.getCustomerId());
				item.setCustomer(customer);
			}
			itemList.add(item);
		}
		return ResponseHelper.success(itemList, "00", "查询成功1");
	}
	
}
