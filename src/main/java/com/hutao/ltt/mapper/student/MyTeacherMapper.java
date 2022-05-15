package com.hutao.ltt.mapper.student;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/12 14:33
 */
@Mapper
public interface MyTeacherMapper extends BaseMapper<TeacherInfo> {
	
	@Select("select st.tid from stu_tea st,student_info si where st.sid = si.id AND si.account = #{account}")
	Integer getTid(String account);
}
