package com.hutao.ltt.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author HUTAO
 * @Description	全局异常处理
 * @date 2022/3/30 13:21
 */
//@Slf4j
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(value = RuntimeException.class)
//	public Result handler(RuntimeException e){
//		log.error("Assert异常：-----------" + e.getMessage());
//		return Result.fail(e.getMessage());
//	}
//
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(value = IllegalArgumentException.class)
//	public Result handler(IllegalArgumentException e){
//		log.error("运行时异常：-----------" + e.getMessage());
//		return Result.fail(e.getMessage());
//	}
//
//}
