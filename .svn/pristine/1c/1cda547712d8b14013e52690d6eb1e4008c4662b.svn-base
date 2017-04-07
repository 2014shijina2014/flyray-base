package me.flyray.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.erp.api.UserService;
import me.flyray.erp.dao.UserDao;
import me.flyray.erp.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> displayAllUser() {
		System.out.println(userDao);
		List<User> users = userDao.queryUser();
		for(User user : users) {
			System.out.println(user.toString());
		}
		
		return users;
	}

}
