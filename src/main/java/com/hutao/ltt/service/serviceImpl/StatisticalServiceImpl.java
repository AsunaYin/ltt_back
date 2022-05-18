package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.StatisticalMapper;
import com.hutao.ltt.pojo.Echarts;
import com.hutao.ltt.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/27 18:49
 */
@Service
public class StatisticalServiceImpl implements StatisticalService {
	
	@Autowired
	private StatisticalMapper statisticalMapper;
	
	/**
	 * 获取老师的数量
	 * @return
	 */
	@Override
	public Integer getTeacherTotal() {
		return statisticalMapper.getTeacherTotal();
	}
	
	/**
	 * 获取学生的数量
	 * @return
	 */
	@Override
	public Integer getStudentTotal() {
		return statisticalMapper.getStudentTotal();
	}
	
	/**
	 * 获取学生 男性的数量
	 * @return
	 */
	@Override
	public Integer getManTotal() {
		return statisticalMapper.getManTotal();
	}
	
	/**
	 * 获取学生 女性的数量
	 * @return
	 */
	@Override
	public Integer getWomanTotal() {
		return statisticalMapper.getWomanTotal();
	}
	
	/**
	 * 获取任务类型及数量
	 * @return
	 */
	@Override
	public List<Echarts> getType() {
		return statisticalMapper.getType();
	}
	
	/**
	 * 获取任务优先度分布
	 * @return
	 */
	@Override
	public List<Echarts> getPriority() {
		return statisticalMapper.getPriority();
	}
	
	/**
	 * 获取任务进度分布
	 * @return
	 */
	@Override
	public List<Echarts> getStatus() {
		return statisticalMapper.getStatus();
	}
	
	
}
