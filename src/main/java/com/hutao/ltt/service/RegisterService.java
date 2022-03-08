package com.hutao.ltt.service;

import com.hutao.ltt.pojo.User;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/8 16:21
 */
public interface RegisterService {
	
	//确认账号是否已经被注册
	String confirmAcc(String account);
	
	//注册
	int register(User user);
	
}
