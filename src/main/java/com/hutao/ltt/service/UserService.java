package com.hutao.ltt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/15 18:51
 */
public interface UserService {
	
	//分页显示学生名单
	IPage<StudentInfo> selectAllStudentsByPage(Integer pageNum,Integer pageSize);
	
	//分页显示老师名单
	IPage<TeacherInfo> selectAllTeachersByPage(Integer pageNum,Integer pageSize);
	
	//根据id获取学生信息
	StudentInfo selectStudentById(Integer id);
	
	//根据id获取老师信息
	TeacherInfo selectTeacherById(Integer id);
	
	//根据 account 获取学生信息
	StudentInfo selectStudentByAccount(String account);
	
	//根据 account 获取老师信息
	TeacherInfo selectTeacherByAccount(String account);
	
	//修改学生信息
	int updateStudentInfo(StudentInfo studentInfo) throws Exception;
	
	//修改老师信息
	int updateTeacherInfo(TeacherInfo teacherInfo) throws Exception;
	
	//根据id删除学生
	int deleteStudentById(Integer id);
	
	//根据id删除老师
	int deleteTeacherById(Integer id);
	
	//在info表删完数据后，在user表里也得删
	int deleteByAccount(String account);
	
	//根据姓名查找学生
	IPage<StudentInfo> selectByStudentName(Integer pageNum,Integer pageSize,String realName);
	
	//根据姓名查找老师
	IPage<TeacherInfo> selectByTeacherName(Integer pageNum,Integer pageSize,String realName);
	
	
}
