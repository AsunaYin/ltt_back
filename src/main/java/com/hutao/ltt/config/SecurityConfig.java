//package com.hutao.ltt.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
///**
// * @author HUTAO
// * @Description
// * @date 2022/3/30 15:46
// */
////@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
////public class SecurityConfig extends WebSecurityConfigurerAdapter {
////
////	private static final String[] URL_WHITELIST = {
////			"/login",
////			"/logout",
////			"/captcha",
////			"/favicon.ico"
////	};
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.cors().and().csrf().disable()
////
////				//登陆配置
////				.formLogin().and()
////
////				//禁用session
////				.sessionManagement()
////				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////
////				//配置拦截规则
////				.authorizeRequests()
////				.antMatchers(URL_WHITELIST).permitAll()
////				.anyRequest().authenticated().and()
////
////				//异常处理器
////
////				//配置自定义过滤器
////		;
////	}
////}
