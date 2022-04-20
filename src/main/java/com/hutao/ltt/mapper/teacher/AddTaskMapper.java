package com.hutao.ltt.mapper.teacher;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/14 16:27
 */
@Mapper
public interface AddTaskMapper extends BaseMapper<Task> {
	
	/**
	 * 获取任务类别
	 * @return
	 */
	@Select("select * from task_type")
	List<TaskType> getType();
	
	/**
	 * 获取任务状态
	 * @return
	 */
	@Select("select * from task_status")
	List<TaskStatus> getStatus();
	
	/**
	 * 获取任务优先级
	 * @return
	 */
	@Select("select * from task_priority")
	List<TaskPriority> getPriority();
	
	/**
	 * 添加任务时，一并添加至 StuTask表
	 * @param taskName
	 * @param taskTypeId
	 * @param taskStatusId
	 * @param priorityId
	 * @return
	 */
	@Insert("insert into stu_task(realname,task_name,task_type_id,task_status_id,priority_id) values (#{realName},#{taskName},#{taskTypeId},#{taskStatusId},#{priorityId});")
	Integer insertStuTask(String realName, String taskName,Integer taskTypeId,Integer taskStatusId, Integer priorityId);

	@Select("select id from task where task_name = #{taskName}")
	Integer confirmName(String taskName);

}
