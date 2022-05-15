package com.hutao.ltt.service.serviceImpl;

import com.hutao.ltt.mapper.StatisticalMapper;
import com.hutao.ltt.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
