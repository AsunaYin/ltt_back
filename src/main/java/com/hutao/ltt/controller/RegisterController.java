package com.hutao.ltt.controller;

import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

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
		//判断是否注册成功
		if (1 == i){
			//注册成功，如果 auth_id = 2，存入老师信息表
			if (2 == user.getAuth_id()){
				user.setRegist_date(LocalDate.now());
				registerService.addTeacherInfo(user);
				return "success";
			} else if (3 == user.getAuth_id()){
				//注册成功，如果 auth_id = 3，存入学生信息表
				user.setRegist_date(LocalDate.now());
				StudentInfo student = new StudentInfo();
				student.setAccount(user.getAccount());
				student.setRegistDate(user.getRegist_date());
				student.setRealName(user.getRealName());
				registerService.addStudentInfo(student);
				//通过user表的 account 查找 student_info表对应 account 的 id
				String account = user.getAccount();
				int id = registerService.selectIdByAccount(account);
				//添加进 stu_tea 表
				registerService.addStuTea(id);
				return "success";
			}
		}
		return "error";
	}
	
}
