package me.flyray.rest.controller.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import me.flyray.crm.api.CustomerBaseService;

@Controller
public class CustTestController {

	@Autowired
	private CustomerBaseService customerBaseService;
}
