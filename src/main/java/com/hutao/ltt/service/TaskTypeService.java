package com.hutao.ltt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.TaskType;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/13 15:10
 */
public interface TaskTypeService {
	
	IPage<TaskType> getAllTypes(Integer pageNum, Integer pageSize);
	
	Integer addType(TaskType taskType);
	
	Integer confirmName(String typeName);
	
}
