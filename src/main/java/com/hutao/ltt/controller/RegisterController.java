package com.hutao.ltt.controller;

import com.hutao.ltt.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/8 16:17
 */
@Controller
@ResponseBody
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 确认账号是否已经被注册
	 * @param account
	 */
	@GetMapping("/confirmAcc")
	public String ConfirmAccount(String account){
		Integer i = registerService.confirmAcc(account);
		if (i == null){
			return "error";
		}
		return "OK";
	}
	
	
}
