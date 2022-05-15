package com.hutao.ltt.mapper.teacher;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.StuTea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/30 17:25
 */
@Mapper
public interface ApplyMapper extends BaseMapper<StuTea> {
	
	@Select("select si.realname,si.sex,si.phone,st.apply_time,st.sid,st.tid from stu_tea st,student_info si where st.sid = si.id AND st.tid = #{tid} AND st.result = 0")
	List<StuTea> getApply(Integer tid);
	
	@Update("update stu_tea set result = 1 where sid = #{sid}")
	Integer agree(Integer sid);
	
	@Update("update stu_tea set result = 2,tid = null,apply_time = null where sid = #{sid}")
	Integer refuse(Integer sid);
}
