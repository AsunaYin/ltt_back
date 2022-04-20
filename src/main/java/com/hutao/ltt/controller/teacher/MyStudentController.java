package com.hutao.ltt.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hutao.ltt.pojo.RealNameBean;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.service.MyStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/12 15:53
 */
@RestController
@RequestMapping("/teacher")
public class MyStudentController {
	
	@Autowired
	private MyStudentService myStudentService;
	
	/**
	 * 分页获取 我的学生
	 * @param pageNum
	 * @param tid
	 * @return
	 */
	@GetMapping("/getStudent/{page}")
	public IPage<StudentInfo> getMyStudent(@PathVariable("page") Integer pageNum, Integer tid){
		List<Integer> sid = myStudentService.selectSidByTid(tid);
		return myStudentService.selectBySid(pageNum,5,sid);
	}
	
	/**
	 * 根据学生姓名查找我的学生
	 * @param pageNum
	 * @param realName
	 * @return
	 */
	@PostMapping("/searchMyStudent/{page}")
	public IPage<StudentInfo> searchMyStudent(@PathVariable("page") Integer pageNum, @RequestBody RealNameBean realName){
		String name = realName.getRealName();
		Integer tid = realName.getTid();
		return myStudentService.selectByName(pageNum, 5, tid, name);
	}
	
}
