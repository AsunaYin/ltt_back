package com.hutao.ltt.mapper.student;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.StuTea;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 16:03
 */
@Mapper
public interface ChoseTeacherMapper extends BaseMapper<StuTea> {
	
	//判断 学生是否已选择老师
	@Select("select tid from stu_tea where sid = #{sid} AND result = 1")
	int selectTidBySid(int sid);
	
	//确认选择老师
	@Update("update stu_tea set tid = #{tid},result = #{result},apply_time = #{applyTime} where sid = #{sid}")
	int addTeacherToStudent(Integer sid, Integer tid, Integer result, LocalDateTime applyTime);
	
}
