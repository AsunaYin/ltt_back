package com.hutao.ltt.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/15 17:02
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{
	
	//查询所有学生信息
//	@Select("select * from student_info")
//	List<StudentInfo> selectAllStudent();
	
	//查询所有老师信息
//	@Select("select * from teacher_info")
//	List<TeacherInfo> selectAllTeacher();
	
	//根据姓名查询学生信息
	@Select("select * from student_info where realname like #{realName}")
	List<StudentInfo> selectByStudentName(String realName);
	
	//根据姓名查询老师信息
	@Select("select * from teacher_info where realname like #{realName}")
	List<TeacherInfo> selectByTeacherName(String realName);
	
	//在info表删完数据后，在user表里也得删
	@Delete("delete from user where account = #{account}")
	int deleteByAccount(String account);
	
}
