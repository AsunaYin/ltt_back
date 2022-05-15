package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 15:39
 */
@Data
@TableName("stu_tea")
public class StuTea {
	private Integer sid;
	private Integer tid;
	private Integer result;
	@TableField("apply_time")
	private LocalDateTime applyTime;
	
	@TableField(exist = false)
	private String realName;
	@TableField(exist = false)
	private String sex;
	@TableField(exist = false)
	private String phone;
}
