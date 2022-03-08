package com.hutao.ltt.service;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/8 16:21
 */
public interface RegisterService {
	
	//确认账号是否已经被注册
	Integer confirmAcc(String account);
	
}
