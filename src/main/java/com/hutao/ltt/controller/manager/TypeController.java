package com.hutao.ltt.controller.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.TaskType;
import com.hutao.ltt.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/13 15:06
 */
@RestController
@RequestMapping("/type")
public class TypeController {
	
	@Autowired
	private TaskTypeService taskTypeService;
	
	/**
	 * 获取全部类别
	 * @param pageNum
	 * @return
	 */
	@GetMapping("/getAllTypes/{page}")
	public IPage<TaskType> getAllTypes(@PathVariable("page") Integer pageNum){
		return taskTypeService.getAllTypes(pageNum, 5);
	}
	
	/**
	 * 检查 任务名 是否重复
	 * @param typeName
	 * @return
	 */
	@GetMapping("/confirmName")
	public String confirmName(String typeName){
		Integer i = taskTypeService.confirmName(typeName);
		if (0 == i){
			return "success";
		} else return "error";
	}
	
	/**
	 * 添加类别
	 * @param taskType
	 * @return
	 */
	@PostMapping("/addType")
	public String addType(@RequestBody TaskType taskType){
		Integer i = taskTypeService.addType(taskType);
		if (1 == i){
			return "success";
		} else return "error";
	}
	
}
