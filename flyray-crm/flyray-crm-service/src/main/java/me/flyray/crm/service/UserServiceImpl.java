package me.flyray.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.crm.api.UserService;
import me.flyray.crm.dao.UserDao;
import me.flyray.crm.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> displayAllUser() {
		System.out.println(userDao);
		for (int i = 0; i < 20; i++) {
			System.out.println(i);
		}
		List<User> users = userDao.queryUser();
		for(User user : users) {
			System.out.println(user.toString());
		}
		
		return users;
	}

}
