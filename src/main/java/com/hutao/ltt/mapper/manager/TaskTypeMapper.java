package com.hutao.ltt.mapper.manager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.TaskType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/13 15:10
 */
@Mapper
public interface TaskTypeMapper extends BaseMapper<TaskType> {
	
	@Select("SELECT COUNT(*) FROM task t,task_type tp WHERE t.task_type_id = tp.id AND typename = #{typeName}")
	Integer selectTypeCount(String typeName);
}
