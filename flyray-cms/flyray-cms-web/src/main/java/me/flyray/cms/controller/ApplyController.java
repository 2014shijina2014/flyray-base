package me.flyray.cms.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.flyray.cms.dao.CustomerBaseDao;
import me.flyray.cms.dao.CustomerProficientDao;
import me.flyray.cms.model.CustomerBase;
import me.flyray.cms.model.CustomerProficient;
import me.flyray.cms.service.QiniuCloudServiceImpl;
import me.flyray.cms.util.Base64Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class ApplyController {

	@Autowired
	private QiniuCloudServiceImpl qiniuCloudService;
	@Autowired
	private CustomerBaseDao customerBaseDao;
	@Autowired
	private CustomerProficientDao customerProficientDao;
	
	@RequestMapping(value="/apply", method = RequestMethod.GET)
	public String index(){ 
		return "apply";
	}
	
	@RequestMapping("/applyForProficient"  )  
	public Map<String,Object> applyForProficient(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		
		String customerNo = request.getParameter("customerNo");  
        String custName = request.getParameter("custName");
        String phone = request.getParameter("phone");
        //
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("customerNo", customerNo);
        List<CustomerBase> list = customerBaseDao.query(map);
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
        //保存专家信息
        CustomerProficient customerProficient = new CustomerProficient();
        customerProficient.setCertPhotoFileNo(id);
        customerProficient.setCustomerNo(customerNo);
        customerProficient.setLeval("00");//默认等级是普通等级
        customerProficientDao.save(customerProficient);
        
        //更新用户信息
        CustomerBase customerBase =list.get(0);
        customerBase.setCustomerNo(customerNo);
        customerBase.setCustName(custName);
        customerBase.setPhone(phone);
        customerBaseDao.update(customerBase);
		return null;
	}
	
}
