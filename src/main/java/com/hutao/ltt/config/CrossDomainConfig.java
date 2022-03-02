package com.hutao.ltt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author HUTAO
 * @Description 解决跨域问题
 * @date 2022/2/16 16:56
 */
@Configuration
public class CrossDomainConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				//是否发送Cookie
				.allowCredentials(true)
				//放行哪些原始域
				.allowedOrigins("*")
				.allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
				.allowedHeaders("*");
	}
}
