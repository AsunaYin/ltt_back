package com.hutao.ltt.controller.student;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.StuTea;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.ChoseTeacherService;
import com.hutao.ltt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 16:08
 */
@RestController
@RequestMapping("/student/ct")
public class ChoseTeacherController {
	
	@Autowired
	private ChoseTeacherService choseTeacherService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 判断 当前学生是否已经选择老师
	 * @param sid
	 * @return
	 */
	@GetMapping("/hasTeacher")
	public String ifHasTeacher(int sid){
		choseTeacherService.selectTidBySid(sid);
		return null;
	}
	
	/**
	 * 获取老师列表
	 * @param pageNum
	 * @return
	 */
	@GetMapping("/getTeachers/{page}")
	public IPage<TeacherInfo> getAllTeachers(@PathVariable("page") Integer pageNum){
		return userService.selectAllTeachersByPage(pageNum, 5);
	}
	
	/**
	 * 选择老师
	 * @return
	 */
	@PostMapping("/confirm")
	public String confirmTeacher(@RequestBody StuTea stuTea){
		int i = choseTeacherService.addTeacherToStudent(stuTea.getSid(), stuTea.getTid());
		if (1 == i){
			return "success";
		} else return "error";
	}
	
}
