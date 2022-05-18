package com.hutao.ltt.controller;

import com.hutao.ltt.pojo.Echarts;
import com.hutao.ltt.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/27 18:43
 */
@RestController
@RequestMapping("/statistical")
public class StatisticalController {
	
	@Autowired
	private StatisticalService statisticalService;
	
	/**
	 * 获取 学生、老师的数量
	 * @return
	 */
	@GetMapping("/getUser")
	public Map<String,Object> getUser(){
		Map<String, Object> map = new HashMap<>();
		Integer teacherTotal = statisticalService.getTeacherTotal();
		Integer studentTotal = statisticalService.getStudentTotal();
		map.put("teacher",teacherTotal);
		map.put("student",studentTotal);
		return map;
	}
	
	/**
	 * 获取 学生男女数量
	 * @return
	 */
	@GetMapping("/getSex")
	public Map<String,Object> getSex(){
		Map<String, Object> map = new HashMap<>();
		Integer man = statisticalService.getManTotal();
		Integer woman = statisticalService.getWomanTotal();
		map.put("man",man);
		map.put("woman",woman);
		return map;
	}
	
	/**
	 * 获取任务类型数量
	 * @return
	 */
	@GetMapping("/getType")
	public List<Echarts> getNotice(){
		List<Echarts> type = statisticalService.getType();
		return type;
	}
	
	/**
	 * 获取任务优先度分布
	 * @return
	 */
	@GetMapping("/getPriority")
	public List<Echarts> getPriority(){
		List<Echarts> priority = statisticalService.getPriority();
		return priority;
	}
	
	/**
	 * 获取任务进度分布
	 * @return
	 */
	@GetMapping("/getStatus")
	public List<Echarts> getStatus(){
		List<Echarts> status = statisticalService.getStatus();
		return status;
	}
	
}
