package me.flyray.rest.controller.cms;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/** 
* @author: bolei
* @date：2017年4月2日 上午9:45:04 
* @description：图片上传
*/

@Controller
public class UploadController {
	
	
	@RequestMapping(value="/upload", method = RequestMethod.GET)
	public String index(){ 
		return "upload";
	}
	
	@RequestMapping("/uploadToCloud")  
    public ModelAndView uploadToCloud(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
        
        return new ModelAndView("redirect:/view.do?id="+"");
//        return "view" + "?id=";  
    }
}
