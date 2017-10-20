package me.flyray.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
* @author: bolei
* @date：2017年10月20日 下午1:25:00
* @description：类说明 
*/

@Controller
public class IndexController {

	@RequestMapping(value = "/434", method= RequestMethod.GET)
    public String home() {
        return "index33";
    }
}