package com.hutao.ltt.controller.teacher;

import com.hutao.ltt.pojo.*;
import com.hutao.ltt.service.AddTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author HUTAO
 * @Description
 * @date 2022/4/14 16:23
 */
@RestController
@RequestMapping("/addTask")
public class AddTaskController {

	@Autowired
	private AddTaskService addTaskService;
	
	/**
	 * 添加任务
	 * @param task
	 * @return
	 */
	@PostMapping("/submit")
	public Map<String,Object> addTask(@RequestBody Task task){
		System.out.println(task.toString());
		Map<String, Object> map = new HashMap<>();
		
		StuTask stuTask = new StuTask();
		
		stuTask.setTaskName(task.getTaskName());
		stuTask.setTaskTypeId(task.getTaskTypeId());
		stuTask.setTaskStatusId(task.getTaskStatusId());
		stuTask.setPriorityId(task.getPriorityId());
		
		Integer i = addTaskService.addTask(task);
		Integer j = addTaskService.insertStuTask(stuTask);
		if (1 == i && 1 == j){
			map.put("code",200);
			map.put("msg","success");
		} else {
			map.put("msg","error");
		}
		return map;
	}
	
	/**
	 * 检测任务名是否重复
	 * @return
	 */
	@GetMapping("/confirm")
	public String confirmName(String taskName){
		Integer i = addTaskService.confirmName(taskName);
		if (i == null){
			return "success";
		}
		return "error";
	}
	
	/**
	 * 获取任务类别
	 * @return
	 */
	@GetMapping("/getType")
	public List<TaskType> getType(){
		return addTaskService.getType();
	}
	
	/**
	 * 获取任务状态
	 * @return
	 */
	@GetMapping("/getStatus")
	public List<TaskStatus> getStatus(){
		return addTaskService.getStatus();
	}
	
	/**
	 * 获取任务优先级
	 * @return
	 */
	@GetMapping("/getPriority")
	public List<TaskPriority> getPriority(){
		return addTaskService.getPriority();
	}
	
}
