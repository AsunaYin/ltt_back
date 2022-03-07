package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.LoginMapper;
import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/2 20:46
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public Integer getAccountAndPwd(User user) {
		Integer i = loginMapper.getAccountAndPwd(user);
		return i;
	}
}
