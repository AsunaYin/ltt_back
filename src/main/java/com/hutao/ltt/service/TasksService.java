package com.hutao.ltt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.Task;
import com.hutao.ltt.pojo.TaskBean;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/18 15:12
 */
public interface TasksService {
	
	IPage<TaskBean> selectTasksByAccount(Integer pageNum, Integer pageSize, String account);
	
	IPage<TaskBean> selectByName(Integer pageNum, Integer pageSize, String name, String account);
	
	List<StudentInfo> getStudentByTid(Integer tid);
	
	Integer updateByTaskName(String taskName, String realName);
}
