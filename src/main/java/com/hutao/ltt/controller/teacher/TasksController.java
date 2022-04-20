package com.hutao.ltt.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.RealNameBean;
import com.hutao.ltt.pojo.StuTask;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TaskBean;
import com.hutao.ltt.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/18 15:10
 */
@RestController
@RequestMapping("/tasks")
public class TasksController {

	@Autowired
	private TasksService tasksService;
	
	/**
	 * 根据 account 获取 tasks
	 * @param account
	 * @return
	 */
	@GetMapping("/getTasks/{page}")
	public IPage<TaskBean> getTaskByAccount(@PathVariable("page") Integer pageNum, String account){
		IPage<TaskBean> page = tasksService.selectTasksByAccount(pageNum, 5, account);
		return page;
	}
	
	/**
	 * 根据 任务名称 查找任务
	 * @param pageNum
	 * @param taskName
	 * @return
	 */
	@PostMapping("/searchTask/{page}")
	public IPage<TaskBean> searchTask(@PathVariable("page") Integer pageNum, @RequestBody RealNameBean taskName){
		String name = taskName.getRealName();
		String account = taskName.getAccount();
		return tasksService.selectByName(pageNum,5,name,account);
	}
	
	/**
	 * 根据 tid 获取 其学生列表
	 * @param tid
	 * @return
	 */
	@GetMapping("/getStudent")
	public List<StudentInfo> getStudentByTid(Integer tid){
		return tasksService.getStudentByTid(tid);
	}
	
	/**
	 * 给指定学生分配任务
	 * @param stuTask
	 * @return
	 */
	@PostMapping("/addStudent")
	public Map<String, Object> addStudent(@RequestBody StuTask stuTask){
		String taskName = stuTask.getTaskName();
		String realName = stuTask.getRealName();
		Integer i = tasksService.updateByTaskName(taskName, realName);
		Map<String, Object> map = new HashMap<>();
		if (1 == i){
			map.put("code",200);
			map.put("msg","添加成功！");
		} else {
			map.put("msg","error");
		}
		return map;
	}
}
