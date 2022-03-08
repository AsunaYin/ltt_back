package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.RegisterMapper;
import com.hutao.ltt.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/8 16:22
 */
@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterMapper registerMapper;
	
	/**
	 * 确认账号是否已经被注册
	 * @param account
	 * @return
	 */
	@Override
	public Integer confirmAcc(String account) {
		return registerMapper.confirmAcc(account);
	}
}
