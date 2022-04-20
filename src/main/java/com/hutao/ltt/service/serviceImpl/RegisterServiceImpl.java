package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.RegisterMapper;
import com.hutao.ltt.pojo.StuTea;
import com.hutao.ltt.pojo.StudentInfo;
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
	 * @param studentInfo
	 * @return
	 */
	@Override
	public int addStudentInfo(StudentInfo studentInfo) {
		return registerMapper.addStudentInfo(studentInfo);
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
	
	/**
	 * 根据 account 查找 id
	 * @param account
	 * @return
	 */
	@Override
	public int selectIdByAccount(String account) {
		return registerMapper.selectIdByAccount(account);
	}
	
	/**
	 * 在注册时，往 学生-老师 表中存入信息
	 * @param id
	 * @return
	 */
	@Override
	public int addStuTea(int id) {
		return registerMapper.addStuTea(id);
	}
}
