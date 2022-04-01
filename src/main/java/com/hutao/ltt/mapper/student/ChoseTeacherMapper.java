package com.hutao.ltt.mapper.student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 16:03
 */
@Mapper
public interface ChoseTeacherMapper {
	
	//判断 学生是否已选择老师
	@Select("select tid from stu_tea where sid = #{sid}")
	int selectTidBySid(int sid);
	
}
