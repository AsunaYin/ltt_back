package com.hutao.ltt.controller;

import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/2 20:46
 */
@Controller
@ResponseBody
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public String login(@RequestBody User user){
		Integer i = loginService.getAccountAndPwd(user);
		if(i != null){
			if (i == 1){
				return "manager";
			} else if (i == 2){
				return "teacher";
			} else if (i == 3){
				return "student";
			}
		}
		return "error";
	}
	
}
