package me.flyray.rest.controller.cms;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.cms.api.CommentService;
import me.flyray.cms.api.ViewFavortService;
import me.flyray.cms.api.ViewpointService;
import me.flyray.cms.model.Comment;
import me.flyray.cms.model.Viewpoint;
import me.flyray.common.utils.ImageBase64;
import me.flyray.common.utils.SnowFlake;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.model.CustomerBase;
import me.flyray.rest.controller.AbstractController;
import me.flyray.rest.model.ViewPointItem;
import me.flyray.rest.util.PageUtils;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年8月19日 下午2:00:46
* @description：首页圈子
*/

@Controller
@RequestMapping("/api/cms/viewpoints")
public class ViewpointController extends AbstractController{
	@Autowired
	private ViewpointService viewPointService;
	@Autowired
	private CustomerBaseService customerBaseService;
	@Autowired
	private ViewFavortService viewFavortService;
	@Autowired
	private CommentService commentService;
	@Value("${rest_home_imgPath}")
	private String imgPath;
	@Value("${rest_home_imgHttpPath}")
	private String imgHttpPath;
	
	/**
	 * 添加观点
	 */
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Map<String, Object> add(@RequestBody Map<String, Object> param, HttpSession session) {
		Long id = SnowFlake.getId();
		String pointText = (String)param.get("pointText");
		String createBy = (String)param.get("createBy");
		String imgFile64 = (String)param.get("imgFile");
		
		Map<String, Object> map = new HashMap<String, Object>();
		if ("" != imgFile64 && null != imgFile64) {
			String img64[] = imgFile64.split(",");
			String imgFileName = (String)param.get("imgFileName");
			String suffix = imgFileName.substring(imgFileName.lastIndexOf(".") + 1);  
			Long time = new Date().getTime();
			String newName = time + "." + suffix;
			String url = imgPath + File.separator + id + File.separator + newName;
			Boolean flag = ImageBase64.generateImage(img64[1], url);
			map.put("pointImg", newName);
		}
		map.put("pointText", pointText);
		map.put("createBy", Long.valueOf(createBy));
		map.put("favortCount", 0);
		map.put("commentCount", 0);
		map.put("id", id);
		map.put("pointTime", new Date());
		try {
			viewPointService.save(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseHelper.success(param,null, "00", "添加成功");
	}
	/**
	 * 观点添加图片
	 */
	@ResponseBody
	@RequestMapping(value="/addImg", method = RequestMethod.POST)
	public Map<String, Object> addImg(@RequestBody Map<String, Object> param) {
		System.out.println(param);
		return null;
	}
	/**
	 * 分页查询
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> query(@RequestBody Map<String, String> param) {
		logger.info("请求观点---start---{}",param);
		String currentPage = param.get("currentPage");//当前页
		String pageSize = param.get("pageSize");//条数
		String createBy = param.get("createBy");//用户编号
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<>();
		Integer total = viewPointService.queryTotal(queryMap);
		logger.info("请求观点---total---{}",total);
		param.put("totalCount", String.valueOf(total));
		int pageSizeInt = Integer.valueOf(pageSize);
		PageUtils pageUtil = new PageUtils(total, pageSizeInt, Integer.valueOf(currentPage));
		logger.info("请求观点---pageUtil---{}",pageUtil.toString());
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		queryMap.putAll(getPagination(param));
		List<Viewpoint> videoPointList = viewPointService.query(queryMap);
		List<ViewPointItem> itemList = new ArrayList<ViewPointItem>();
		for (Viewpoint cmsViewPoint : videoPointList) {
			//当前登录者有没有对条记录点赞
			Map<String, Object> favortMap = new HashMap<>();
			favortMap.put("createBy", createBy);
			favortMap.put("pointId", cmsViewPoint.getId());
			favortMap.put("favortStatus", 1);
			List favortList = viewFavortService.queryList(favortMap);
			if(favortList.size() > 0){
				cmsViewPoint.setIfFavort(1);
			}else{
				cmsViewPoint.setIfFavort(2);
			}
			if(cmsViewPoint.getPointImg() != null){
				String url = imgHttpPath + File.separator + cmsViewPoint.getId() + File.separator + cmsViewPoint.getPointImg();
				cmsViewPoint.setPointImg(url);
			}
			
			ViewPointItem item = new ViewPointItem();
			Date time = cmsViewPoint.getPointTime();
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//
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
			
			if(cmsViewPoint.getCreateBy() != null){
				CustomerBase customer = customerBaseService.queryByCustomerId(cmsViewPoint.getCreateBy());
				item.setCustomer(customer);
			}
			itemList.add(item);
		}
		logger.info("请求观点---itemList---{}",itemList.toString());
		return ResponseHelper.success(itemList,pageUtil, "00", "查询成功");
	}
	/**
	 * 点赞或者是取消赞
	 */
	@ResponseBody
	@RequestMapping(value="/doFavort", method = RequestMethod.POST)
	public Map<String, Object> doFavort(@RequestBody Map<String, Object> param) {
		logger.info("请求观点---start---{}",param);
		//假设从后台取
		Long customerId = (long) 1;
		param.put("customerId", customerId);
		Map<String, Object> map = viewFavortService.doFavort(param);
		logger.info("请求观点---map---{}",map);
		String code = (String) map.get("code");
		logger.info("请求观点---code---{}",code);
		if("00".equals(code)){
			//成功
			return ResponseHelper.success(map,null, "00", "操作成功");
		}else{
			//失败
			return ResponseHelper.success(map,null, "01", "操作异常");
		}
		
	}
	/**
	 * 请求单个观点详情
	 */
	@ResponseBody
	@RequestMapping(value="/info", method = RequestMethod.POST)
	public Map<String, Object> info(@RequestBody Map<String, Object> param) {
		logger.info("请求单个观点详情---start---{}",param);
		Map<String, Object> result = viewPointService.selectPointById(param);
		String code = (String) result.get("code");
		String createBy = (String) result.get("createBy");
		if("00".equals(code)){
			Viewpoint cmsViewPoint = (Viewpoint) result.get("point");
			//当前登录者有没有对条记录点赞
			Map<String, Object> favortMap = new HashMap<>();
			favortMap.put("createBy", createBy);
			favortMap.put("pointId", cmsViewPoint.getId());
			favortMap.put("favortStatus", 1);
			List favortList = viewFavortService.queryList(favortMap);
			if(favortList.size() > 0){
				cmsViewPoint.setIfFavort(1);
			}else{
				cmsViewPoint.setIfFavort(2);
			}
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
			
			if(cmsViewPoint.getCreateBy() != null){
				CustomerBase customer = customerBaseService.queryByCustomerId(cmsViewPoint.getCreateBy());
				item.setCustomer(customer);
			}
			if(cmsViewPoint.getPointImg() != null){
				String url = imgHttpPath + File.separator + cmsViewPoint.getId() + File.separator + cmsViewPoint.getPointImg();
				cmsViewPoint.setPointImg(url);
			}
			result.put("item", item);
			return ResponseHelper.success(result,null, "00", "查询成功");
		}else{
			return ResponseHelper.success(result,null, "01", "查询异常");
		}
	}
	
}
