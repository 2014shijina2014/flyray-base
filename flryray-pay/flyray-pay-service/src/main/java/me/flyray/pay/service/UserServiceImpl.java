package me.flyray.pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.pay.api.UserService;
import me.flyray.pay.dao.UserDao;
import me.flyray.pay.model.User;

@Service
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
