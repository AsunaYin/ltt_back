package com.hutao.ltt.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HUTAO
 * @Description 封装结果集
 * @date 2022/3/30 12:18
 */
@Data
public class Result implements Serializable {
	private int code;
	private String msg;
	private Object data;
	
	public static Result success(Object data){
		return success(200, "操作成功", data);
	}
	
	public static Result success(int code, String msg, Object data){
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	
	public static Result fail(String msg){
		return fail(400, msg, null);
	}
	
	public static Result fail(int code, String msg, Object data){
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

}
