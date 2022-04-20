package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/18 17:36
 */
@Data
@TableName("stu_task")
public class StuTask {

	@TableId(type = IdType.AUTO)
	private Integer id;
	
	@TableField("realname")
	private String realName;
	
	@TableField("task_name")
	private String taskName;
	
	@TableField("task_type_id")
	private Integer taskTypeId;
	
	@TableField("task_status_id")
	private Integer taskStatusId;
	
	@TableField("priority_id")
	private Integer priorityId;
	
}
