package com.hutao.ltt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.StuTask;
import com.hutao.ltt.pojo.StuTaskBean;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.Task;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/19 17:48
 */
public interface MyTaskService {
	
	IPage<StuTaskBean> getMyTask(Integer pageNum, Integer pageSize, String realName);
	
	String getNameBySid(Integer sid);
	
	IPage<StuTaskBean> selectByName(Integer pageNum, Integer pageSize, String taskName, String realName);
	
	String getTeacher(String taskName);
	
	Integer updateStatus(String taskName, Integer statusId);
	
	Integer updateStuTaskStatus(String taskName, Integer statusId);
}
