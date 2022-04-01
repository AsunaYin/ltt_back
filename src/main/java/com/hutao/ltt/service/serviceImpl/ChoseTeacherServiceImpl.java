package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.student.ChoseTeacherMapper;
import com.hutao.ltt.service.ChoseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 16:07
 */
@Service
public class ChoseTeacherServiceImpl implements ChoseTeacherService {
	
	@Autowired
	private ChoseTeacherMapper choseTeacherMapper;
	
	/**
	 * 判断 学生是否已选择老师
	 * @param sid
	 * @return
	 */
	@Override
	public int selectTidBySid(int sid) {
		return choseTeacherMapper.selectTidBySid(sid);
	}
}
