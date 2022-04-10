package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hutao.ltt.mapper.UserMapper;
import com.hutao.ltt.mapper.manager.StudentMapper;
import com.hutao.ltt.mapper.manager.TeacherMapper;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.InfoService;
import com.hutao.ltt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/8 14:12
 */
@Service
public class InfoServiceImpl implements InfoService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 */
	@Override
	public int updateStudentInfo(StudentInfo student) throws Exception{
		return studentMapper.updateById(student);
	}
	
	/**
	 * 修改老师信息
	 * @param teacher
	 * @return
	 */
	@Override
	public int updateTeacherInfo(TeacherInfo teacher) throws Exception{
		return teacherMapper.updateById(teacher);
	}
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	@Override
	public int updatePwd(User user) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("account",user.getAccount());
		return userMapper.update(user,wrapper);
	}
}
