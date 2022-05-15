package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hutao.ltt.mapper.MessageMapper;
import com.hutao.ltt.pojo.Notice;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/25 16:12
 */
@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageMapper messageMapper;
	
	/**
	 * 根据 sid 获取 其老师
	 * @param sid
	 * @return
	 */
	@Override
	public List<TeacherInfo> getTeacher(Integer sid) {
		return messageMapper.getTeacher(sid);
	}
	
	@Override
	public String getStudentAccount(String realName) {
		return messageMapper.selectStudentAccount(realName);
	}
	
	@Override
	public String getTeacherAccount(String realName) {
		return messageMapper.selectTeacherAccount(realName);
	}
	
	/**
	 * 发送信息
	 * @param send, receive, content
	 * @param sendTime
	 * @return
	 */
	@Override
	public Integer insertNotice(String send, String receive, String content, LocalDateTime sendTime) {
		return messageMapper.insertNotice(send, receive, content, sendTime);
	}
	
	/**
	 * 获取 我发送的消息
	 * @param sendAccount,role
	 * @return
	 */
	@Override
	public List<Notice> getSendMessage(String sendAccount, String role) {
		if ("2".equals(role)){
			return messageMapper.getTeacherSendMessage(sendAccount);
		} else if ("3".equals(role)){
			return messageMapper.getStudentSendMessage(sendAccount);
		} else return null;
	}
	
	/**
	 * 获取 我接收的消息
	 * @param receiveAccount,role
	 * @return
	 */
	@Override
	public List<Notice> getReceiveMessage(String receiveAccount, String role) {
		if ("2".equals(role)){
			return messageMapper.getTeacherReceiveMessage(receiveAccount);
		} else if ("3".equals(role)){
			return messageMapper.getStudentReceiveMessage(receiveAccount);
		} else return null;
	}
}
