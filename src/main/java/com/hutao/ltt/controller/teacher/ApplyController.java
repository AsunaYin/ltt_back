package com.hutao.ltt.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.StuTea;
import com.hutao.ltt.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/30 17:20
 */
@RestController
@RequestMapping("/apply")
public class ApplyController {
	
	@Autowired
	private ApplyService applyService;
	
	/**
	 * 获取 申请列表
	 * @param tid
	 * @return
	 */
	@GetMapping("/getApply")
	public List<StuTea> getApply(Integer tid){
		return applyService.getApply(tid);
	}
	
	/**
	 * 同意
	 * @param sid
	 * @return
	 */
	@GetMapping("/agree")
	public String agree(Integer sid){
		Integer i = applyService.agree(sid);
		if (1 == i){
			return "success";
		} else return "error";
	}
	
	/**
	 * 拒绝
	 * @param sid
	 * @return
	 */
	@GetMapping("/refuse")
	public String refuse(Integer sid){
		Integer i = applyService.refuse(sid);
		if (1 == i){
			return "success";
 		} else return "error";
	}
	
}
