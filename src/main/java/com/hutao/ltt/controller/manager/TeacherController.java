package com.hutao.ltt.controller.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.RealNameBean;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/16 12:50
 */
@RestController
@RequestMapping("/user/teacher")
public class TeacherController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取全部老师
	 *
	 * @return 老师列表
	 */
	@GetMapping("/getAllTeachers/{page}")
	public IPage<TeacherInfo> selectAllTeacher(@PathVariable("page") Integer pageNum) {
		return userService.selectAllTeachersByPage(pageNum, 7);
	}
	
	/**
	 * 根据id查找老师
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/getTeacherById")
	public TeacherInfo selectTeacherById(Integer id) {
		return userService.selectTeacherById(id);
	}
	
	/**
	 * 根据 account 查找老师
	 * @param account
	 * @return
	 */
	@GetMapping("/getTeacherByAccount")
	public TeacherInfo selectTeacherByAccount(String account){
		return userService.selectTeacherByAccount(account);
	}
	
	/**
	 * 根据老师姓名查找老师
	 *
	 * @return
	 */
	@PostMapping("/searchTeacher/{page}")
	public IPage<TeacherInfo> selectTeacherByRealName(@PathVariable("page") Integer pageNum,@RequestBody RealNameBean realName) {
		String name = realName.getRealName();
		return userService.selectByTeacherName(pageNum, 7, name);
	}
	
	/**
	 * 修改老师信息
	 *
	 * @param teacherInfo
	 * @return
	 */
	@PostMapping("/updateTeacherInfo")
	public String updateTeacherInfo(@RequestBody TeacherInfo teacherInfo) {
		int i = 0;
		try {
			i = userService.updateTeacherInfo(teacherInfo);
		} catch (Exception e) {
			return "phone_duplicate";
		}
		if (i == 1){
			return "success";
		} else {
			return "error";
		}
	}
	
	/**
	 * 根据 id 删除老师
	 * @param teacherInfo
	 * @return
	 */
	@PostMapping("/deleteTeacherById")
	public String deleteTeacherById(@RequestBody TeacherInfo teacherInfo){
		Integer id = teacherInfo.getId();
		String account = teacherInfo.getAccount();
		int i = userService.deleteTeacherById(id);
		int j = userService.deleteByAccount(account);
		if (i == 1 && j == 1){
			return "success";
		}else {
			return "error";
		}
	}
}
