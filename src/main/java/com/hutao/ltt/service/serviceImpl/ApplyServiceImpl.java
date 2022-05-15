package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.mapper.teacher.ApplyMapper;
import com.hutao.ltt.pojo.StuTea;
import com.hutao.ltt.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/30 17:24
 */
@Service
public class ApplyServiceImpl implements ApplyService {
	
	@Autowired
	private ApplyMapper applyMapper;
	
	/**
	 * 获取申请列表
	 * @param tid
	 * @return
	 */
	@Override
	public List<StuTea> getApply(Integer tid) {
		return applyMapper.getApply(tid);
	}
	
	/**
	 * 同意
	 * @param sid
	 * @return
	 */
	@Override
	public Integer agree(Integer sid) {
		return applyMapper.agree(sid);
	}
	
	/**
	 * 拒绝
	 * @param sid
	 * @return
	 */
	@Override
	public Integer refuse(Integer sid) {
		return applyMapper.refuse(sid);
	}
}
