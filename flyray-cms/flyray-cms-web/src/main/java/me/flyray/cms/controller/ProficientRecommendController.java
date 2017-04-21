package me.flyray.cms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.qiniu.util.StringUtils;

import me.flyray.cms.dao.ProficientRecommendDao;
import me.flyray.cms.dto.ResponseHelper;
import me.flyray.cms.model.ProficientRecommend;
import me.flyray.cms.service.QiniuCloudServiceImpl;
import me.flyray.cms.util.Base64Util;
import me.flyray.cms.util.DateUtils;

@Controller
public class ProficientRecommendController {

	@Autowired
	private QiniuCloudServiceImpl qiniuCloudService;
	
	@Autowired
	private ProficientRecommendDao proficientRecommendDao;
	
	@RequestMapping(value="/proficientRecommendIndex", method = RequestMethod.GET)
	public String index(){ 
		return "proficientRecommendIndex";
	}
	
	@RequestMapping(value="/proficientRecommend")
	public Map<String,Object> proficientRecommend(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		String customerNo = request.getParameter("customerNo");  
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("customerNo", customerNo);
		List<Map<String, Object>> list = null;
		if(list.size() > 1){
			throw new RuntimeException("会员信息不唯一");
		}
		if(list.size() < 1){
			throw new RuntimeException("会员信息不存在");
		}
		
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        String id = null;
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){
                	//获取文件的byte 数组
                	byte[] data = Base64Util.toBase64(file.getInputStream());
                	id = qiniuCloudService.upload(data);
                }  
            }  
        }
		
        String recommendDate = DateUtils.format(new Date(), "yyyy-MM-dd");
        ProficientRecommend proficientRecommend = new ProficientRecommend();
        proficientRecommend.setCustomerNo(customerNo);
        proficientRecommend.setRecommendTime(new Date());
        proficientRecommend.setRecommendDate(recommendDate);
        proficientRecommend.setRecommendPhotoFile(id);
        proficientRecommendDao.save(proficientRecommend);
        
		return ResponseHelper.success(null, "00", "请求数据成功");
	}
	
	
	
	
	@RequestMapping(value="/viewRecommend")
	public Map<String,Object> viewRecommend(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		String customerNo = request.getParameter("customerNo");
		String recommendDate = request.getParameter("recommendDate");
		if(StringUtils.isNullOrEmpty(customerNo)){
			throw new RuntimeException("客户号不能为空");
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("customerNo", customerNo);
		List<Map<String, Object>> list = null;
		if(list.size() > 1){
			throw new RuntimeException("会员信息不唯一");
		}
		if(list.size() < 1){
			throw new RuntimeException("会员信息不存在");
		}
		map.put("recommendDate", recommendDate);
		List<ProficientRecommend> listRecommend = proficientRecommendDao.queryList(map);
		return ResponseHelper.success(listRecommend, "00", "请求数据成功");
	}
	
}
