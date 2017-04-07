package me.flyray.erp.servicetest;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.flyray.erp.api.UserService;


public class UserServiceTest {
	
	private  UserService userService;
	
	@Before
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring.xml");
		userService = context.getBean(UserService.class);
	}
	
	@Test
	public void testUserService() throws IOException {
		System.out.println("userService:"+userService);
		System.out.println(userService.displayAllUser());	
		
	}
	
	

}
