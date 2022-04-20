package com.hutao.ltt.controller;

import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.ChoseTeacherService;
import com.hutao.ltt.service.LoginService;
import com.hutao.ltt.service.UserService;
import com.hutao.ltt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChoseTeacherService choseTeacherService;
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User user){
		Map<String, Object> map = new HashMap<>();
		Integer i = loginService.getAccountAndPwd(user);
		if(i != null){
			//获取 token
			Map<String, String> payload = new HashMap<>();
			payload.put("account",user.getAccount());
			String token = JwtUtil.getToken(payload);
			if (i == 1){
				map.put("state",true);
				map.put("msg","认证成功");
				map.put("role",1);
				map.put("token",token);
				return map;
			} else if (i == 2){
				Integer tid = userService.selectTeacherByAccount(user.getAccount()).getId();
				map.put("state",true);
				map.put("msg","认证成功");
				map.put("role",2);
				map.put("tid",tid);
				map.put("token",token);
				return map;
			} else if (i == 3){
				Integer sid = userService.selectStudentByAccount(user.getAccount()).getId();
				Integer tid = choseTeacherService.selectTidBySid(sid);
				map.put("state",true);
				map.put("msg","认证成功");
				map.put("role",3);
				map.put("sid",sid);
				map.put("tid",tid);
				map.put("token",token);
				return map;
			}
		}
		map.put("msg","认证失败");
		return map;
	}
	
}
