package com.hutao.ltt.service;

import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.pojo.User;

/**
 * @author HUTAO
 * @Description 个人中心
 * @date 2022/4/8 14:12
 */
public interface InfoService {
	
	//修改学生信息
	int updateStudentInfo(StudentInfo student) throws Exception;
	
	//修改老师信息
	int updateTeacherInfo(TeacherInfo teacher) throws Exception;
	
	//修改密码
	int updatePwd(User user);
	
}
