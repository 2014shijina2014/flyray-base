package me.flyray.rest.controller.cms;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.flyray.cms.dto.ResponseHelper;

@Controller
public class ProficientRecommendController {

	
	@RequestMapping(value="/proficientRecommendIndex", method = RequestMethod.GET)
	public String index(){ 
		return "proficientRecommendIndex";
	}
	
	@RequestMapping(value="/proficientRecommend")
	public Map<String,Object> proficientRecommend(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
        
		return ResponseHelper.success(null, "00", "请求数据成功");
	}
	
	@RequestMapping(value="/viewRecommend")
	public Map<String,Object> viewRecommend(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		
		return ResponseHelper.success(null, "00", "请求数据成功");
	}
	
}
