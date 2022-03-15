package com.hutao.ltt.mapper;

import com.hutao.ltt.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/8 16:11
 */
@Mapper
public interface RegisterMapper {
	
	//确认账号是否已经被注册
	@Select("select id from user where account = #{account}")
	String confirmAcc(String acconut);
	
	//注册
	@Insert("insert into user(account, password, auth_id) VALUES(#{account},#{password},#{auth_id})")
	int register(User user);
	
	//注册后添加信息到对应的info表
	//存入学生信息
	@Insert("insert into student_info(account,phone,regist_date) values(#{account},null,#{regist_date})")
	int addStudentInfo(User user);
	
	//存入老师信息
	@Insert("insert into teacher_info(account,phone,regist_date) values(#{account},null,#{regist_date})")
	int addTeacherInfo(User user);
	
}
