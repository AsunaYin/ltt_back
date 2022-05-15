package com.hutao.ltt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.StuTea;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/30 17:24
 */
public interface ApplyService {
	
	List<StuTea> getApply(Integer tid);
	
	Integer agree(Integer sid);
	
	Integer refuse(Integer sid);
}
