package com.hutao.ltt.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/20 11:34
 */
@Data
public class StuTaskBean {
	
	private String realName;
	private String taskName;
	private String taskDes;
	private String status;
	private String typename;
	private String priority;
	private LocalDate startTime;
	private LocalDate deadline;
	
}
