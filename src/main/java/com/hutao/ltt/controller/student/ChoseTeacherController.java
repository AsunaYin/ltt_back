package com.hutao.ltt.controller.student;

import com.hutao.ltt.service.ChoseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 16:08
 */
@RestController
@RequestMapping("/student")
public class ChoseTeacherController {
	
	@Autowired
	private ChoseTeacherService choseTeacherService;
	
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
	
}
