package me.flyray.pay.daotest;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import me.flyray.pay.dao.PayChannelConfigDao;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath*:spring-mybatis.xml") 
@Transactional 
public class UserDaoTest {
	
	@Autowired
	private PayChannelConfigDao payChannelConfigDao;
	
/*	@Before
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
	}*/
	
	@Test
	public void testQueryUser() {
		payChannelConfigDao.queryById(Long.valueOf(1));
	}

}
