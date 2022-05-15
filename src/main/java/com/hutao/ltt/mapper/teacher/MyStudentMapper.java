package com.hutao.ltt.mapper.teacher;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/12 15:39
 */
@Mapper
public interface MyStudentMapper extends BaseMapper<StudentInfo> {
	
	/**
	 * 根据 tid 查找出 sid
	 * @param tid
	 * @return
	 */
	@Select("select sid from stu_tea where tid = #{tid} AND result = 1")
	List<Integer> selectSidByTid(Integer tid);
	
	
	@Select("select * from student_info WHERE realname LIKE #{name} AND id IN (SELECT sid FROM stu_tea WHERE tid = #{tid} AND result = 1);")
	List<StudentInfo> selectByName(Integer tid,String name);
	
}
