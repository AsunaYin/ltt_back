package com.hutao.ltt.service;

import com.hutao.ltt.pojo.*;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/14 16:28
 */
public interface AddTaskService {

	List<TaskType> getType();
	
	List<TaskStatus> getStatus();
	
	List<TaskPriority> getPriority();
	
	Integer addTask(Task task);
	
	Integer insertStuTask(StuTask stuTask);
	
	Integer confirmName(String taskName);

}
