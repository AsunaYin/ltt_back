package com.hutao.ltt.mapper;

import com.hutao.ltt.pojo.StuTea;
import com.hutao.ltt.pojo.StudentInfo;
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
	String confirmAcc(String account);
	
	//注册
	@Insert("insert into user(account, password, auth_id) VALUES(#{account},#{password},#{auth_id})")
	int register(User user);
	
	//注册后添加信息到对应的info表
	//存入学生信息
	@Insert("insert into student_info(account,phone,regist_date,realname) values(#{account},null,#{regist_date},#{realName})")
	int addStudentInfo(StudentInfo studentInfo);
	
	//存入老师信息
	@Insert("insert into teacher_info(account,phone,regist_date,realname) values(#{account},null,#{regist_date},#{realName})")
	int addTeacherInfo(User user);
	
	//根据 account 查找 id
	@Select("select id from student_info where account = #{account}")
	int selectIdByAccount(String account);
	
	//在注册时，往 学生-老师 表中存入信息
	@Insert("insert into stu_tea(sid, tid) values(#{sid},null)")
	int addStuTea(int id);
	
}
