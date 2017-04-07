package me.flyray.pay.dao;

import java.util.List;

import me.flyray.pay.model.User;

public interface UserDao {
	
	public List<User> queryUser();
}
