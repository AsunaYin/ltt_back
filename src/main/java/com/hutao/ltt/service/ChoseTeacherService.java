package com.hutao.ltt.service;

import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 16:06
 */
public interface ChoseTeacherService {
	
	//判断 学生是否已选择老师
	int selectTidBySid(int sid);
	
}
