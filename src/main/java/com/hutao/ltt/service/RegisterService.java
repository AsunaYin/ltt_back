package com.hutao.ltt.service;

import com.hutao.ltt.pojo.User;
import org.apache.ibatis.annotations.Insert;

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
	
	//注册成功后，插入基本信息
	//存入学生信息
	int addStudentInfo(User user);
	
	//存入老师信息
	int addTeacherInfo(User user);
	
}
