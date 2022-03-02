package com.hutao.ltt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/2 20:44
 */
@Mapper
public interface UserMapper{
	
	@Select("select id from user where account = #{account} and password = #{password}")
	Integer selectByAccountAndPassword(User user);
	
}
