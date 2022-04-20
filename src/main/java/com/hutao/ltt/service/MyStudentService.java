package com.hutao.ltt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.StudentInfo;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/12 15:50
 */
public interface MyStudentService {
	
	List<Integer> selectSidByTid(Integer tid);
	
	IPage<StudentInfo> selectBySid(Integer pageNum,Integer pageSize,List<Integer> sid);
	
	IPage<StudentInfo> selectByName(Integer pageNum, Integer pageSize, Integer tid, String name);
	
}
