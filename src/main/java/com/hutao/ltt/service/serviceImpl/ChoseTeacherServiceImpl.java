package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hutao.ltt.mapper.student.ChoseTeacherMapper;
import com.hutao.ltt.pojo.StuTea;
import com.hutao.ltt.pojo.TeacherInfo;
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
	
	/**
	 * 确认选择老师
	 * @param sid,tid
	 * @return
	 */
	@Override
	public int addTeacherToStudent(Integer sid,Integer tid) {
		return choseTeacherMapper.addTeacherToStudent(sid,tid);
	}
	
	@Override
	public Integer selectTidBySid(Integer sid) {
		QueryWrapper<StuTea> wrapper = new QueryWrapper<>();
		wrapper.eq("sid",sid);
		StuTea stuTea = choseTeacherMapper.selectOne(wrapper);
		Integer tid = stuTea.getTid();
		return tid;
	}
}
