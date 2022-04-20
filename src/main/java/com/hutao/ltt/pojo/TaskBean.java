package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/18 16:42
 */
@Data
public class TaskBean {
	
	private String taskName;
	private String taskDes;
	private LocalDate startTime;
	private LocalDate deadline;
	private String typename;
	private String status;
	private String priority;
	private String realName;
	
}
