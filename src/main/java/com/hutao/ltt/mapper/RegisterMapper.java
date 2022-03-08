package com.hutao.ltt.mapper;

import com.hutao.ltt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/8 16:11
 */
@Mapper
public interface RegisterMapper {
	
	//确认账号是否已经被注册
	@Select("select id from user where account = #{account}")
	Integer confirmAcc(String acconut);
	
	//注册
	int register(User user);
	
}
