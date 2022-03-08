package com.hutao.ltt.mapper;

import com.hutao.ltt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/7 21:14
 */
@Mapper
public interface LoginMapper {
	
	//登录
	@Select("select auth_id from user where account = #{account} and password = #{password}")
	Integer getAccountAndPwd(User user);
	
}
