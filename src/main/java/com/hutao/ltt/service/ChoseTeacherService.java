package com.hutao.ltt.service;

import com.hutao.ltt.pojo.TeacherInfo;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 16:06
 */
public interface ChoseTeacherService {
	
	//判断 学生是否已选择老师
	int selectTidBySid(int sid);
	
	//确认选择老师
	int addTeacherToStudent(Integer sid, Integer tid,Integer result, LocalDateTime applyTime);
	
	Integer selectTidBySid(Integer sid);
	
}
