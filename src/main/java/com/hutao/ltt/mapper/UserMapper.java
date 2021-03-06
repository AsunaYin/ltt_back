package com.hutao.ltt.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/15 17:02
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{
	
	//在info表删完数据后，在user表里也得删
	@Delete("delete from user where account = #{account}")
	int deleteByAccount(String account);
	
}
