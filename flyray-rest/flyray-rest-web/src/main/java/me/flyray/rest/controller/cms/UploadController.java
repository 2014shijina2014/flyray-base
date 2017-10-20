package me.flyray.rest.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)  
    public String doUploadFile(@RequestParam("file") MultipartFile file){  
        System.out.println(file);
        return "";
    }
}
