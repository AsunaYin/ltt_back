package com.hutao.ltt.controller;

import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
		String i = registerService.confirmAcc(account);
		if (i == null){
			return "success";
		}
		return "error";
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@PostMapping("/submit")
	public String register(@RequestBody User user){
		int i = registerService.register(user);
		if (i == 1){
			return "success";
		}
		return "error";
	}
	
}
