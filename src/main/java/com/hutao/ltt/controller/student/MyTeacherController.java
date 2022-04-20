package com.hutao.ltt.controller.student;

import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.MyTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/12 14:30
 */
@RestController
@RequestMapping("/student")
public class MyTeacherController {
	
	@Autowired
	private MyTeacherService myTeacherService;
	
	/**
	 * 获取我的老师信息
	 * @param tid
	 * @return
	 */
	@GetMapping("/myTeacher")
	public TeacherInfo getMyTeacher(Integer tid){
		return myTeacherService.getMyTeacher(tid);
	}
	
}
