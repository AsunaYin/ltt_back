package com.hutao.ltt.service;

import com.hutao.ltt.pojo.Echarts;

import java.util.List;
import java.util.Map;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/27 18:48
 */
public interface StatisticalService {
	
	Integer getTeacherTotal();
	
	Integer getStudentTotal();
	
	Integer getManTotal();
	
	Integer getWomanTotal();
	
	List<Echarts> getType();
	
	List<Echarts> getPriority();
	
	List<Echarts> getStatus();
}
