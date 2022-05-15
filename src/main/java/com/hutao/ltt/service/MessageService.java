package com.hutao.ltt.service;

import com.hutao.ltt.pojo.Notice;
import com.hutao.ltt.pojo.TeacherInfo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/25 16:12
 */
public interface MessageService {
	List<TeacherInfo> getTeacher(Integer sid);
	
	String getStudentAccount(String realName);
	
	String getTeacherAccount(String realName);
	
	Integer insertNotice(String send, String receive, String content, LocalDateTime sendTime);
	
	List<Notice> getSendMessage(String sendAccount, String role);
	
	List<Notice> getReceiveMessage(String receiveAccount,String role);
}
