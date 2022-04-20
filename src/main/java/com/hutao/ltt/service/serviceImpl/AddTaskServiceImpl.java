package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.teacher.AddTaskMapper;
import com.hutao.ltt.pojo.*;
import com.hutao.ltt.service.AddTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/14 16:28
 */
@Service
public class AddTaskServiceImpl implements AddTaskService {
	
	@Autowired
	private AddTaskMapper addTaskMapper;
	
	/**
	 * 获取任务类别
	 * @return
	 */
	@Override
	public List<TaskType> getType() {
		return addTaskMapper.getType();
	}
	
	/**
	 * 获取任务状态
	 * @return
	 */
	@Override
	public List<TaskStatus> getStatus() {
		return addTaskMapper.getStatus();
	}
	
	/**
	 * 获取任务优先级
	 * @return
	 */
	@Override
	public List<TaskPriority> getPriority() {
		return addTaskMapper.getPriority();
	}
	
	/**
	 * 添加任务
	 * @param task
	 * @return
	 */
	@Override
	public Integer addTask(Task task) {
		return addTaskMapper.insert(task);
	}
	
	/**
	 * 添加任务时，一并添加至 StuTask表
	 * @param stuTask
	 * @return
	 */
	@Override
	public Integer insertStuTask(StuTask stuTask) {
		String realName = stuTask.getRealName();
		String taskName = stuTask.getTaskName();
		Integer taskTypeId = stuTask.getTaskTypeId();
		Integer taskStatusId = stuTask.getTaskStatusId();
		Integer priorityId = stuTask.getPriorityId();
		return addTaskMapper.insertStuTask(realName, taskName, taskTypeId, taskStatusId, priorityId);
	}
	
	/**
	 * 判断任务名是否重复
	 * @param taskName
	 * @return
	 */
	@Override
	public Integer confirmName(String taskName) {
		return addTaskMapper.confirmName(taskName);
	}
}
