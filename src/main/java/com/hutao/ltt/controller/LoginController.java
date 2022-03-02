package com.hutao.ltt.controller;

import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.UserService;
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
	private UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestBody User user){
		Integer i = userService.selectByAccountAndPassword(user);
		if(i == null){
			return "error";
		}
		return "OK";
	}
	
}
