package com.hutao.ltt.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HUTAO
 * @Description
 * @date 2022/2/16 16:16
 */
@MapperScan("com.hutao.ltt.mapper")		//设置mapper包扫描器
@Configuration
public class MybatisConfig {
	
	//mbp分页插件
	@Bean
	public PaginationInterceptor paginationInterceptor(){
		return new PaginationInterceptor();
	}
	
}
