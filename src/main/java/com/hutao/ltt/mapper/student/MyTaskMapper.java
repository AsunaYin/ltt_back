package com.hutao.ltt.mapper.student;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.StuTask;
import com.hutao.ltt.pojo.StuTaskBean;
import com.hutao.ltt.pojo.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/19 17:49
 */
@Mapper
public interface MyTaskMapper extends BaseMapper<StuTask> {
	
	@Select("select realname from student_info where id = #{sid}")
	String getNameBySid(Integer sid);
	
	@Select("SELECT st.realname,st.task_name,t.task_des,tt.typename,ts.`status`,tp.priority,t.start_time,t.deadline FROM stu_task st,task t,task_type tt,task_status ts,task_priority tp WHERE t.task_type_id = tt.id AND t.task_status_id = ts.id AND t.priority_id = tp.id AND t.task_name = st.task_name AND st.realname = #{realName};")
	List<StuTaskBean> getMyTask(String realName);
	
	@Select("SELECT st.realname,st.task_name,t.task_des,tt.typename,ts.`status`,tp.priority,t.start_time,t.deadline FROM stu_task st,task t,task_type tt,task_status ts,task_priority tp WHERE t.task_type_id = tt.id AND t.task_status_id = ts.id AND t.priority_id = tp.id AND t.task_name = st.task_name AND st.task_name LIKE #{taskName} AND st.realname = #{realName};")
	List<StuTaskBean> selectByName(String taskName, String realName);
	
	@Select("SELECT realname from teacher_info WHERE account = (SELECT t_account FROM task WHERE task_name = #{taskName})")
	String getTeacher(String taskName);
	
	@Update("update task set task_status_id = #{statusId} where task_name = #{taskName}")
	Integer updateStatus(String taskName, Integer statusId);
	
	@Update("update stu_task set task_status_id = #{statusId} where task_name = #{taskName}")
	Integer updateStuTaskStatus(String taskName, Integer statusId);
}
