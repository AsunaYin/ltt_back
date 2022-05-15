package com.hutao.ltt.service;

import com.hutao.ltt.pojo.TeacherInfo;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/12 14:31
 */
public interface MyTeacherService {
	
	//根据 tid 获取老师信息
	TeacherInfo getMyTeacher(Integer tid);
	
	Integer getTid(String account);
}
