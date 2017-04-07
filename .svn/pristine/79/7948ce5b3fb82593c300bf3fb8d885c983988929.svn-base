package me.flyray.rbac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;
import me.flyray.rest.model.TestUser;

@Service("testService")
public class TestServiceImpl{

	@Autowired
	private ApiProvider apiProvider;
	
	public void displayAllUser() {
		
		TestUser testUser = new TestUser();
		testUser.setChinesename("22");
		apiProvider.execute(testUser);
		
		//userService.displayAllUser();
		
		Parameter parameter = new Parameter("customerBaseService", "queryObject");
		parameter.setId((long) 323);
		List<?> list = apiProvider.execute(parameter).getList();
	}

}
