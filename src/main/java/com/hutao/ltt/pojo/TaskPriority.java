package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/14 16:34
 */
@Data
@TableName("task_priority")
public class TaskPriority {
	
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String priority;
	
}
