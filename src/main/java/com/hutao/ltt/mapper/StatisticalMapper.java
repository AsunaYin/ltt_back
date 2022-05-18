package com.hutao.ltt.mapper;

import com.hutao.ltt.pojo.Echarts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/27 18:45
 */
@Mapper
public interface StatisticalMapper {

	@Select("select count(*) from user where auth_id = 2")
	Integer getTeacherTotal();

	@Select("select count(*) from user where auth_id = 3")
	Integer getStudentTotal();
	
	@Select("select count(*) from student_info where sex = '男'")
	Integer getManTotal();
	
	@Select("select count(*) from student_info where sex = '女'")
	Integer getWomanTotal();
	
	@Select("SELECT tt.typename,COUNT(*) as count FROM task t,task_type tt WHERE t.task_type_id = tt.id GROUP BY tt.typename")
	List<Echarts> getType();
	
	@Select("select tp.priority,count(*) as count from task t,task_priority tp where t.priority_id = tp.id group by tp.priority")
	List<Echarts> getPriority();
	
	@Select("select ts.status,count(*) as count from task t,task_status ts where t.task_status_id = ts.id group by ts.status")
	List<Echarts> getStatus();
}
