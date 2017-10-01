package me.flyray.rest.controller.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import me.flyray.cms.api.CmsViewFavortService;
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
	@Autowired
	private CmsViewFavortService cmsViewFavortService;
	/**
	 * 添加观点
	 */
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Map<String, Object> add(@RequestBody Map<String, Object> param) {
		CmsViewPoint cmsViewPoint = new CmsViewPoint();
		String pointText = (String)param.get("pointText");
		cmsViewPoint.setPointText(pointText);
		cmsViewPoint.setCustomerId((long) 1);
		cmsViewPointService.save(cmsViewPoint);
		return ResponseHelper.success(param,null, "00", "添加成功");
	}
	/**
	 * 分页查询
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> query(@RequestBody Map<String, Object> param) {
		String currentPage = (String) param.get("currentPage");//当前页
		String pageSize = (String) param.get("pageSize");//条数
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer total = cmsViewPointService.queryTotal();
		if(currentPage == null || currentPage == ""){
			currentPage = "0";
		}
		Integer nextPage = Integer.valueOf(currentPage) + 1;
		if(pageSize == null || pageSize == ""){
			pageSize = "10";
		}
		Pager Page = new Pager(nextPage, Integer.valueOf(pageSize), total);
		if(nextPage > Page.getTotal_page()){
			//下一页超出总页数
			result.put("currentPage", Page.getTotal_page()+"");
			return ResponseHelper.success(result,null, "01", "已经到最后一条了~");
		}
		//int current_page, int page_size, int total_count
		map.put("offset", Page.getStart_size());//开始行索引
		map.put("limit", Page.getPage_size());//每页条数
		List<CmsViewPoint> videoPointList = cmsViewPointService.queryList(map);
		List<ViewPointItem> itemList = new ArrayList<ViewPointItem>();
		for (CmsViewPoint cmsViewPoint : videoPointList) {
			ViewPointItem item = new ViewPointItem();
			
			Date time = cmsViewPoint.getPointTime();
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//
			String fromDate = simpleFormat.format(time);
			String toDate = simpleFormat.format(new Date());

			try {
				long from = simpleFormat.parse(fromDate).getTime();
				long to = simpleFormat.parse(toDate).getTime();
				int minutes = (int) ((to - from)/(1000 * 60));
				if(minutes <= 60){
					//如果小于60分钟就显示分钟
					cmsViewPoint.setDiffTime(String.valueOf(minutes)+"分钟");
				}else if(minutes > 60 && minutes <= 60*24){
					//如果大于60分钟小于24小时显示小时
					int hours = (int) ((to - from)/(1000 * 60 * 60));
					cmsViewPoint.setDiffTime(String.valueOf(hours)+"小时");
				}else{
					//大于24小时显示天
					int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
					cmsViewPoint.setDiffTime(String.valueOf(days)+"天");
				}
				item.setCmsViewPoint(cmsViewPoint);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(cmsViewPoint.getCustomerId() != null){
				CustomerBase customer = customerBaseService.queryByCustomerId(cmsViewPoint.getCustomerId());
				item.setCustomer(customer);
			}
			itemList.add(item);
		}
		result.put("itemList", itemList);
		result.put("currentPage", nextPage.toString());
		return ResponseHelper.success(result,null, "00", "查询成功");
	}
	/**
	 * 点赞或者是取消赞
	 */
	@ResponseBody
	@RequestMapping(value="/doFavort", method = RequestMethod.POST)
	public Map<String, Object> doFavort(@RequestBody Map<String, Object> param) {
		//假设从后台取
		Long customerId = (long) 1;
		param.put("customerId", customerId);
		Map<String, Object> map = cmsViewFavortService.doFavort(param);
		String code = (String) map.get("code");
		if("00".equals(code)){
			//成功
			return ResponseHelper.success(map,null, "00", "操作成功");
		}else{
			//失败
			return ResponseHelper.success(map,null, "01", "操作异常");
		}
		
	}
}
