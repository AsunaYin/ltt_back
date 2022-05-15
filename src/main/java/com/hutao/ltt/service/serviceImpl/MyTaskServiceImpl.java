package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hutao.ltt.mapper.student.MyTaskMapper;
import com.hutao.ltt.pojo.StuTask;
import com.hutao.ltt.pojo.StuTaskBean;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.Task;
import com.hutao.ltt.service.MyTaskService;
import com.hutao.ltt.util.PageListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/19 17:49
 */
@Service
public class MyTaskServiceImpl implements MyTaskService {
	
	@Autowired
	private MyTaskMapper myTaskMapper;
	
	/**
	 * 根据 sid 首先获取 realName ,再通过 name 获取其 task
	 * @param pageNum
	 * @param pageSize
	 * @param realName
	 * @return
	 */
	@Override
	public IPage<StuTaskBean> getMyTask(Integer pageNum, Integer pageSize, String realName) {
		List<StuTaskBean> list = myTaskMapper.getMyTask(realName);
		Page page = PageListUtil.getPages(pageNum, pageSize, list);
		return page;
		
	}
	
	/**
	 * 根据 sid 获取 realName
	 * @param sid
	 * @return
	 */
	@Override
	public String getNameBySid(Integer sid) {
		return myTaskMapper.getNameBySid(sid);
	}
	
	/**
	 * 根据任务名 模糊查询
	 * @param pageNum
	 * @param pageSize
	 * @param taskName
	 * @return
	 */
	@Override
	public IPage<StuTaskBean> selectByName(Integer pageNum, Integer pageSize, String taskName, String realName) {
		taskName = "%" + taskName + "%";
		List<StuTaskBean> list = myTaskMapper.selectByName(taskName,realName);
		return PageListUtil.getPages(pageNum, pageSize, list);
	}
	
	/**
	 * 根据 任务名 获取老师
	 * @param taskName
	 * @return
	 */
	@Override
	public String getTeacher(String taskName) {
		return myTaskMapper.getTeacher(taskName);
	}
	
	/**
	 * 更新 task 表的 statusId
	 * @param taskName
	 * @param statusId
	 * @return
	 */
	@Override
	public Integer updateStatus(String taskName, Integer statusId) {
		return myTaskMapper.updateStatus(taskName, statusId);
	}
	
	/**
	 * 更新 stuTask 表的 statusId
	 * @param taskName
	 * @param statusId
	 * @return
	 */
	@Override
	public Integer updateStuTaskStatus(String taskName, Integer statusId) {
		return myTaskMapper.updateStuTaskStatus(taskName, statusId);
	}
}
