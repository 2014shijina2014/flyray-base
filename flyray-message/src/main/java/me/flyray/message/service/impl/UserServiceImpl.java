package me.flyray.message.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import me.flyray.message.mapper.UserMapper;
import me.flyray.message.model.User;
import me.flyray.message.service.IUserService;

/** 
* @author: bolei
* @date：Jul 14, 2017 5:26:05 PM 
* @description：类描述
*/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
