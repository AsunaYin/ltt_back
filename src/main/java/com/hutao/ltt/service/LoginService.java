package com.hutao.ltt.service;

import com.hutao.ltt.pojo.User;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/2 20:45
 */
public interface LoginService {
	
	Integer getAccountAndPwd(User user);
	
}
