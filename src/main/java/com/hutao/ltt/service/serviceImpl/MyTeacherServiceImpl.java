package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.student.MyTeacherMapper;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.MyTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/12 14:32
 */
@Service
public class MyTeacherServiceImpl implements MyTeacherService {
	
	@Autowired
	private MyTeacherMapper myTeacherMapper;
	
	@Override
	public TeacherInfo getMyTeacher(Integer tid) {
		return myTeacherMapper.selectById(tid);
	}
}
