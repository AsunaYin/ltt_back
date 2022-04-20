package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hutao.ltt.mapper.student.MyTeacherMapper;
import com.hutao.ltt.mapper.teacher.MyStudentMapper;
import com.hutao.ltt.pojo.StuTea;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.MyStudentService;
import com.hutao.ltt.service.MyTeacherService;
import com.hutao.ltt.util.PageListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/12 15:51
 */
@Service
public class MyStudentServiceImpl implements MyStudentService {
	
	@Autowired
	private MyStudentMapper myStudentMapper;
	
	/**
	 * 根据 tid 查找 sid
	 * @param tid
	 * @return
	 */
	@Override
	public List<Integer> selectSidByTid(Integer tid) {
		return myStudentMapper.selectSidByTid(tid);
	}
	
	/**
	 * 根据得到的 sid 获取学生信息并分页
	 * @param pageNum
	 * @param pageSize
	 * @param sid
	 * @return
	 */
	@Override
	public IPage<StudentInfo> selectBySid(Integer pageNum,Integer pageSize,List<Integer> sid) {
		List<StudentInfo> students = myStudentMapper.selectBatchIds(sid);
		Page page = PageListUtil.getPages(pageNum, pageSize, students);
		return page;
		//return myStudentMapper.selectPage(page,null);
	}
	
	/**
	 * 根据姓名模糊查询 并分页
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@Override
	public IPage<StudentInfo> selectByName(Integer pageNum, Integer pageSize, Integer tid, String name) {
		name = "%" + name + "%";
		List<StudentInfo> students = myStudentMapper.selectByName(tid, name);
		Page page = PageListUtil.getPages(pageNum, pageSize, students);
		return page;
	}
}
