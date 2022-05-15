package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/25 16:13
 */
@Data
@TableName("notice")
public class Notice {

	@TableId(type = IdType.AUTO)
	private Integer id;
	@TableField("send_account")
	private String send;
	@TableField("receive_account")
	private String receiveAccount;
	@TableField("information")
	private String information;
	@TableField("send_time")
	private LocalDateTime sendTime;
	
	@TableField(exist = false)
	private String receiver;
	@TableField(exist = false)
	private String role;
	@TableField(exist = false)
	private String realName;
	
}
