package com.hutao.ltt.controller.student;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.StuTea;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.ChoseTeacherService;
import com.hutao.ltt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
	public Map<String,Object> confirmTeacher(@RequestBody StuTea stuTea){
		Map<String, Object> map = new HashMap<>();
		//result: 0 待审核    1 通过   2 未选择
		stuTea.setResult(0);
		stuTea.setApplyTime(LocalDateTime.now());
		int i = choseTeacherService.addTeacherToStudent(stuTea.getSid(), stuTea.getTid(),stuTea.getResult(),stuTea.getApplyTime());
		if (1 == i){
			map.put("type","success");
			map.put("result",0);
			map.put("msg","选择成功！等待老师审核！");
		} else {
			map.put("type","error");
		}
		return map;
		
	}
	
}
