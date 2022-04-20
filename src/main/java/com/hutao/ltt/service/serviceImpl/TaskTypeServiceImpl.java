package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hutao.ltt.mapper.manager.TaskTypeMapper;
import com.hutao.ltt.pojo.TaskType;
import com.hutao.ltt.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/13 15:11
 */
@Service
public class TaskTypeServiceImpl implements TaskTypeService {
	
	@Autowired
	private TaskTypeMapper taskTypeMapper;
	
	/**
	 * 获取全部类别
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public IPage<TaskType> getAllTypes(Integer pageNum, Integer pageSize) {
		Page<TaskType> page = new Page<>(pageNum,pageSize);
		return taskTypeMapper.selectPage(page,null);
	}
	
	/**
	 * 添加类别
	 * @param taskType
	 * @return
	 */
	@Override
	public Integer addType(TaskType taskType) {
		return taskTypeMapper.insert(taskType);
	}
	
	/**
	 * 检查 任务名 是否重复
	 * @param typeName
	 * @return
	 */
	@Override
	public Integer confirmName(String typeName) {
		QueryWrapper<TaskType> wrapper = new QueryWrapper<>();
		wrapper.eq("typename",typeName);
		return taskTypeMapper.selectCount(wrapper);
	}
}
