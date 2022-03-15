package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("studnet_info")
public class StudentInfo {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String account;
	private String realName;
	private String sex;
	private String phone;
	private Date birthDate;
	private Date registDate;
}
