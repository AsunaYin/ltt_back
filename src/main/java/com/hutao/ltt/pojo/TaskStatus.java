package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/14 16:33
 */
@Data
@TableName("task_status")
public class TaskStatus {
	
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String status;
	
}
