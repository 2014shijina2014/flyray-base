package me.flyray.rest.dao;

import java.util.List;

import me.flyray.rest.model.User;


public interface UserDao {
	
	public List<User> queryUser();
}
