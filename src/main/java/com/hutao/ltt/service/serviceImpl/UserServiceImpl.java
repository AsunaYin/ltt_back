package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.UserMapper;
import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/2 20:46
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public Integer selectByAccountAndPassword(User user) {
		Integer i = userMapper.selectByAccountAndPassword(user);
		return i;
	}
}
