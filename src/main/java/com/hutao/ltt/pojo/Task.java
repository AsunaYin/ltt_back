package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/14 16:24
 */
@Data
@TableName("task")
public class Task {
	
	@TableId(type = IdType.AUTO)
	private Integer id;
	
	@TableField("task_name")
	private String taskName;
	
	@TableField("task_des")
	private String taskDes;
	
	@TableField("task_type_id")
	private Integer taskTypeId;
	
	@TableField("task_status_id")
	private Integer taskStatusId;
	
	@TableField("priority_id")
	private Integer priorityId;
	
	@TableField("start_time")
	private LocalDate startTime;
	
	private LocalDate deadline;
	
	@TableField("t_account")
	private String account;
	
	private String type_name;
	private String status;
	private String priority;
	private String realName;
	
}
