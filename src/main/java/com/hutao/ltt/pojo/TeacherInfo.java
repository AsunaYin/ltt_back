package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/15 17:09
 */
@Data
@TableName("teacher_info")
public class TeacherInfo {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String account;
	@TableField("realname")
	private String realName;
	private String sex;
	private String phone;
	private Date birthDate;
	private Date registDate;
	
}
