package com.hutao.ltt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/27 18:45
 */
@Mapper
public interface StatisticalMapper {

	@Select("select count(*) from user where auth_id = 2")
	Integer getTeacherTotal();

	@Select("select count(*) from user where auth_id = 3")
	Integer getStudentTotal();
	
	@Select("select count(*) from student_info where sex = '男'")
	Integer getManTotal();
	
	@Select("select count(*) from student_info where sex = '女'")
	Integer getWomanTotal();
}
