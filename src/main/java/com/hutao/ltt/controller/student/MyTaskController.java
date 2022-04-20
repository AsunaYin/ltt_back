package com.hutao.ltt.controller.student;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.*;
import com.hutao.ltt.service.MyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/19 17:47
 */
@RestController
@RequestMapping("/myTask")
public class MyTaskController {
	
	@Autowired
	private MyTaskService myTaskService;
	
	/**
	 * 根据 sid 首先获取 realName ,再通过 name 获取其 task
	 * @param pageNum
	 * @param sid
	 * @return
	 */
	@GetMapping("/getMyTask/{page}")
	public IPage<StuTaskBean> getMyTask(@PathVariable("page")Integer pageNum, Integer sid){
		String name = myTaskService.getNameBySid(sid);
		return myTaskService.getMyTask(pageNum,5,name);
	}
	
	/**
	 * 根据 sid 获取 realName
	 * @param sid
	 * @return
	 */
	@GetMapping("/getNameBySid")
	public String getNameBySid(Integer sid){
		return myTaskService.getNameBySid(sid);
	}
	
	/**
	 * 根据任务名 模糊查询
	 * @param pageNum
	 * @param name
	 * @return
	 */
	@PostMapping("/searchMyTask/{page}")
	public IPage<StuTaskBean> searchMyTask(@PathVariable("page")Integer pageNum, @RequestBody RealNameBean name){
		String taskName = name.getRealName();
		Integer sid = name.getSid();
		String realName = myTaskService.getNameBySid(sid);
		return myTaskService.selectByName(pageNum,5,taskName,realName);
	}
	
	/**
	 * 根据 任务名 获取老师
	 * @param taskName
	 * @return
	 */
	@GetMapping("/getTeacher")
	public String getTeacher(String taskName){
		return myTaskService.getTeacher(taskName);
	}
	
	/**
	 * 更新 task 表的 statusId
	 * @param task
	 * @return
	 */
	@PostMapping("/changeStatus")
	public String changeStatus(@RequestBody Task task){
		String taskName = task.getTaskName();
		Integer statusId = task.getTaskStatusId();
		Integer i = myTaskService.updateStatus(taskName, statusId);
		if (1 == i){
			return "success";
		} else return "error";
	}
}
