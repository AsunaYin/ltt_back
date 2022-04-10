package com.hutao.ltt.controller.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hutao.ltt.pojo.RealNameBean;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/16 12:50
 */
@RestController
@RequestMapping("/user/student")
public class StudentController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取全部学生
	 *
	 * @return 学生列表
	 */
	@GetMapping("/getAllStudents/{page}")
	public IPage<StudentInfo> selectAllStudent(@PathVariable("page") Integer pageNum) {
		return userService.selectAllStudentsByPage(pageNum, 5);
	}
	
	/**
	 * 根据id查找学生
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/getStudentById")
	public StudentInfo selectStudentById(Integer id) {
		return userService.selectStudentById(id);
	}
	
	/**
	 * 根据 account 查找学生
	 * @param account
	 * @return
	 */
	@GetMapping("/getStudentByAccount")
	public StudentInfo selectStudentByAccount(String account){
		return userService.selectStudentByAccount(account);
	}
	
	/**
	 * 根据学生姓名查找学生
	 *
	 * @return
	 */
	@PostMapping("/searchStudent/{page}")
	public IPage<StudentInfo> selectStudentByRealName(@PathVariable("page") Integer pageNum,@RequestBody RealNameBean realName) {
		String name = realName.getRealName();
		return userService.selectByStudentName(pageNum, 5, name);
	}
	
	/**
	 * 修改学生信息
	 *
	 * @param studentInfo
	 * @return
	 */
	@PostMapping("/updateStudentInfo")
	public String updateStudentInfo(@RequestBody StudentInfo studentInfo) {
		int i = 0;
		try {
			i = userService.updateStudentInfo(studentInfo);
		} catch (Exception e) {
			return "phone_duplicate";
		}
		if (i == 1) {
			return "success";
		} else {
			return "error";
		}
	}
	
	/**
	 * 根据 id 删除学生
	 *
	 * @param studentInfo
	 * @return
	 */
	@PostMapping("/deleteStudentById")
	public String deleteStudentById(@RequestBody StudentInfo studentInfo) {
		Integer id = studentInfo.getId();
		String account = studentInfo.getAccount();
		int i = userService.deleteStudentById(id);
		int j = userService.deleteByAccount(account);
		if (i == 1 && j == 1) {
			return "success";
		} else {
			return "error";
		}
	}
	
	
}
