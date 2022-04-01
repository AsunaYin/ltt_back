//package com.hutao.ltt.config;
//
//import com.hutao.ltt.interceptor.JWTInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @author HUTAO
// * @Description 拦截器配置
// * @date 2022/3/30 18:07
// */
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new JWTInterceptor())
//				.addPathPatterns("/**")
//				.excludePathPatterns("/login","/register");
//	}
//}
