package com.hutao.ltt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.Notice;
import com.hutao.ltt.pojo.TeacherInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/25 16:12
 */
@Mapper
public interface MessageMapper extends BaseMapper<Notice> {
	
	@Select("select ti.id,ti.realname from teacher_info ti,stu_tea st where st.tid = ti.id AND st.sid = #{sid}")
	List<TeacherInfo> getTeacher(Integer sid);
	
	@Select("select account from student_info where realname = #{realName}")
	String selectStudentAccount(String realName);
	
	@Select("select account from teacher_info where realname = #{realName}")
	String selectTeacherAccount(String realName);
	
	@Insert("insert into notice(send_account, receive_account, information, send_time) VALUES (#{send},#{receive},#{content},#{sendTime})")
	Integer insertNotice(String send, String receive, String content, LocalDateTime sendTime);
	
	
	
	@Select("select st.realname,n.information,n.send_time from notice n, student_info st where n.send_account = st.account AND n.receive_account = #{receiveAccount} order by n.send_time desc")
	List<Notice> getTeacherReceiveMessage(String receiveAccount);
	
	@Select("select ti.realname,n.information,n.send_time from notice n, teacher_info ti where n.send_account = ti.account AND n.receive_account = #{receiveAccount} order by n.send_time desc")
	List<Notice> getStudentReceiveMessage(String receiveAccount);
	
	@Select("select si.realname,n.information,n.send_time from notice n,student_info si where n.receive_account = si.account AND n.send_account = #{sendAccount} order by n.send_time desc")
	List<Notice> getTeacherSendMessage(String sendAccount);
	
	@Select("select ti.realname,n.information,n.send_time from notice n,teacher_info ti where n.receive_account = ti.account AND n.send_account = #{sendAccount} order by n.send_time desc")
	List<Notice> getStudentSendMessage(String sendAccount);
}
