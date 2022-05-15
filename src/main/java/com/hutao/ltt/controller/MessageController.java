package com.hutao.ltt.controller;

import com.hutao.ltt.pojo.Notice;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.MessageService;
import com.hutao.ltt.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/25 16:03
 */
@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private TasksService tasksService;
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * 获取 我接收的消息
	 * @param receiveAccount,role
	 * @return
	 */
	@GetMapping("/getReceiveMessage")
	public List<Notice> getReceiveMessage(String receiveAccount, String role){
		return messageService.getReceiveMessage(receiveAccount,role);
	}
	
	/**
	 * 获取 我发送的消息
	 * @param sendAccount,role
	 * @return
	 */
	@GetMapping("/getSendMessage")
	public List<Notice> getSendMessage(String sendAccount, String role){
		List<Notice> sendMessage = messageService.getSendMessage(sendAccount, role);
		System.out.println(sendMessage);
		return sendMessage;
	}
	
	/**
	 * 根据 tid 获取 其学生列表
	 *
	 * @param tid
	 * @return
	 */
	@GetMapping("/getStudent")
	public List<StudentInfo> getStudentByTid(Integer tid) {
		return tasksService.getStudentByTid(tid);
	}
	
	/**
	 * 根据 sid 获取 其老师
	 * @param sid
	 * @return
	 */
	@GetMapping("/getTeacher")
	public List<TeacherInfo> getTeacherBySid(Integer sid) {
		return messageService.getTeacher(sid);
	}
	
	/**
	 * 发送信息
	 * @param notice
	 * @return
	 */
	@PostMapping("/sendMessage")
	public String sendMessage(@RequestBody Notice notice){
		String realName = notice.getReceiver();
		String account = null;
		if (Objects.equals(notice.getRole(), "2")){
			account = messageService.getStudentAccount(realName);
		} else if (Objects.equals(notice.getRole(), "3")){
			account = messageService.getTeacherAccount(realName);
		}
		notice.setReceiveAccount(account);
		notice.setSendTime(LocalDateTime.now());
		String send = notice.getSend();
		String receive = notice.getReceiveAccount();
		String content = notice.getInformation();
		LocalDateTime sendTime = notice.getSendTime();
		Integer i = messageService.insertNotice(send, receive, content, sendTime);
		if (1 == i){
			return "success";
		} else return "error";
	}
	
}
