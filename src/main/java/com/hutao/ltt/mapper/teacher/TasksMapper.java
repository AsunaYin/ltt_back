package com.hutao.ltt.mapper.teacher;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.Task;
import com.hutao.ltt.pojo.TaskBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/18 15:11
 */
@Mapper
public interface TasksMapper extends BaseMapper<Task> {
	@Select("SELECT t.*,st.realName,tt.typename,ts.status,tp.priority \n" +
			"FROM task t,task_type tt, task_status ts,task_priority tp,stu_task st \n" +
			"WHERE t.task_status_id = ts.id \n" +
			"\tAND t.task_type_id = tt.id \n" +
			"\tAND t.priority_id = tp.id \n" +
			"\tAND st.task_name = t.task_name \n" +
			"\tAND t.t_account = #{account};")
	List<TaskBean> selectAll(String account);
	
	@Select("SELECT t.*,st.realName,tt.typename,ts.status,tp.priority \n" +
			"FROM task t,task_type tt, task_status ts,task_priority tp,stu_task st \n" +
			"WHERE t.task_type_id = tt.id " +
			"AND t.task_status_id = ts.id " +
			"AND t.priority_id = tp.id " +
			"AND st.task_name = t.task_name " +
			"AND t.task_name LIKE #{name} " +
			"AND t.t_account = #{account};")
	List<TaskBean> selectByTaskName(String name, String account);
	
	@Select("select si.id,si.realname from student_info si,stu_tea st where si.id = st.sid AND st.tid = #{tid}")
	List<StudentInfo> selectStudentByTid(Integer tid);
	
	@Update("update stu_task set realname = #{realName} where task_name = #{taskName}")
	Integer updateByTaskName(String taskName,String realName);
	
	@Update("update task set task_status_id = #{statusId} where task_name = #{taskName}")
	Integer updateStatus(String taskName, Integer statusId);
	
	@Update("update stu_task set task_status_id = #{statusId} where task_name = #{taskName}")
	Integer updateStuTaskStatus(String taskName, Integer statusId);
	
	@Update("update task set task_status_id = #{statusId} where task_name = #{taskName}")
	Integer updateFailStatus(String taskName, Integer statusId);
	
	@Update("update stu_task set task_status_id = #{statusId} where task_name = #{taskName}")
	Integer updateFailStuTaskStatus(String taskName, Integer statusId);
}
