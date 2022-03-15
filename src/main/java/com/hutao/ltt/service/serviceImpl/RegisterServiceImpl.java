package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.RegisterMapper;
import com.hutao.ltt.pojo.User;
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
	public String confirmAcc(String account) {
		return registerMapper.confirmAcc(account);
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@Override
	public int register(User user) {
		return registerMapper.register(user);
	}
	
	/**
	 * 注册成功后，插入学生基本信息
	 * @param user
	 * @return
	 */
	@Override
	public int addStudentInfo(User user) {
		return registerMapper.addStudentInfo(user);
	}
	
	/**
	 * 注册成功后，插入老师基本信息
	 * @param user
	 * @return
	 */
	@Override
	public int addTeacherInfo(User user) {
		return registerMapper.addTeacherInfo(user);
	}
}
