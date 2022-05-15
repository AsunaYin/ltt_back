package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hutao.ltt.mapper.teacher.TasksMapper;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.Task;
import com.hutao.ltt.pojo.TaskBean;
import com.hutao.ltt.service.TasksService;
import com.hutao.ltt.util.PageListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/18 15:13
 */
@Service
public class TasksServiceImpl implements TasksService {
	
	@Autowired
	private TasksMapper tasksMapper;
	
	/**
	 * 根据 account 查找 tasks
	 * @return
	 */
	@Override
	public IPage<TaskBean> selectTasksByAccount(Integer pageNum, Integer pageSize, String account) {
		List<TaskBean> tasks = tasksMapper.selectAll(account);
		Page page = PageListUtil.getPages(pageNum, pageSize, tasks);
		return page;
	}
	
	/**
	 * 根据 任务名称 查找任务
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @param account
	 * @return
	 */
	@Override
	public IPage<TaskBean> selectByName(Integer pageNum, Integer pageSize, String name, String account) {
		name = "%" + name + "%";
		List<TaskBean> tasks = tasksMapper.selectByTaskName(name,account);
		Page page = PageListUtil.getPages(pageNum, pageSize, tasks);
		return page;
	}
	
	/**
	 * 根据 tid 获取 学生
	 * @param tid
	 * @return
	 */
	@Override
	public List<StudentInfo> getStudentByTid(Integer tid) {
		return tasksMapper.selectStudentByTid(tid);
	}
	
	/**
	 * 分配给学生后，修改表内容
	 * @param taskName
	 * @param realName
	 * @return
	 */
	@Override
	public Integer updateByTaskName(String taskName, String realName) {
		return tasksMapper.updateByTaskName(taskName, realName);
	}
	
	/**
	 * 验收通过
	 * @param taskName
	 * @param statusId
	 * @return
	 */
	@Override
	public Integer updateStatus(String taskName, Integer statusId) {
		return tasksMapper.updateStatus(taskName, statusId);
	}
	
	@Override
	public Integer updateStuTaskStatus(String taskName, Integer statusId) {
		return tasksMapper.updateStuTaskStatus(taskName, statusId);
	}
	
	/**
	 * 验收不通过
	 * @param taskName
	 * @param statusId
	 * @return
	 */
	@Override
	public Integer updateFailStatus(String taskName, Integer statusId) {
		return tasksMapper.updateFailStatus(taskName,statusId);
	}
	
	@Override
	public Integer updateFailStuTaskStatus(String taskName, Integer statusId) {
		return tasksMapper.updateFailStuTaskStatus(taskName,statusId);
	}
	
	@Override
	public Integer editTask(Task task) {
		QueryWrapper<Task> wrapper = new QueryWrapper<>();
		wrapper.eq("task_name",task.getTaskName());
		return tasksMapper.update(task,wrapper);
	}
}
