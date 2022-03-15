package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.NestingKind;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author HUTAO
 * @Description 用户
 * @date 2022/3/2 20:42
 */
@Data
@TableName("users")
public class User {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String account;
	private String password;
	private Integer auth_id;
	private LocalDate regist_date;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
	}
	
	public User(Integer id, String account, String password) {
		this.id = id;
		this.account = account;
		this.password = password;
	}
}
