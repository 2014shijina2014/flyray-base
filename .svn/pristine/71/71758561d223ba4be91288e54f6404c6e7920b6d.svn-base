package me.flyray.pay.daotest;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import me.flyray.pay.dao.UserDao;
import me.flyray.pay.model.User;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath*:spring-mybatis.xml") 
@Transactional 
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
/*	@Before
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
	}*/
	
	@Test
	public void testQueryUser() {
		List<User> users = userDao.queryUser();
		assertNotNull(users);
	}

}
