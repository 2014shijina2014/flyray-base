package me.flyray.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.flyray.rest.util.PageUtils;

/**
 * Controller公共组件
* @author: bolei
* @date：2017年10月01日 下午12:46:23
* @description：类说明 
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected Map<String, Object> getPagination(Map<String, String> param) {
		
		String currentPage = (String) param.get("currentPage");//当前页
		String pageSize = (String) param.get("pageSize");//条数
		
		if(currentPage == null || currentPage == ""){
			currentPage = "0";
		}
		Integer currPage = Integer.valueOf(currentPage);
		if(pageSize == null || pageSize == ""){
			pageSize = "10";
		}
		Map<String, Object> result = new HashMap<String, Object>();
		int totalCountInt = Integer.valueOf(param.get("totalCount"));
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(totalCountInt, pageSizeInt, currPage);
		if(currPage == pageUtil.getTotalPage()-1){
			result.put("limit", (totalCountInt%pageSizeInt));
		}else {
			result.put("limit", Integer.valueOf(param.get("pageSize")));
		}
		result.put("offset", currPage*pageSizeInt);
		
		return result;
	}
	
	protected boolean isLastPage(Map<String, String> param) {
		
		String currentPage = (String) param.get("currentPage");//当前页
		PageUtils pageUtil = new PageUtils(Integer.valueOf(param.get("totalCount")), 10, Integer.valueOf(param.get("currentPage")));
		Integer nextPage = Integer.valueOf(currentPage) + 1;
		boolean flag =  false;
		if(nextPage > pageUtil.getTotalPage()){
			//下一页超出总页数
			flag =  true;
		}
		return flag;
	}
}
