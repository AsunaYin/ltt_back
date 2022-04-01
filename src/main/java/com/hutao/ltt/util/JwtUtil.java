package com.hutao.ltt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/30 17:26
 */
public class JwtUtil {
	
	private static final String SIGN = "!@#$%^&*()";
	
	/**
	 * 生成 token
	 * @param map
	 * @return
	 */
	public static String getToken(Map<String, String> map){
		Calendar instance = Calendar.getInstance();
		//默认7天过期
		instance.add(Calendar.DATE, 7);
		
		//创建 jwt builder
		JWTCreator.Builder builder = JWT.create();
		
		//payload
		map.forEach((k,v)->{
			builder.withClaim(k,v);
		});
		
		//令牌
		String token = builder.withExpiresAt(instance.getTime())
				.sign(Algorithm.HMAC256(SIGN));
		
		return token;
	}
	
	/**
	 * 验证 token 合法性
	 * @param token
	 */
	public static void verify(String token){
		JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
	}
	
	/**
	 * 获取 token 信息
	 * @param token
	 * @return
	 */
	public static DecodedJWT getTokenInfo(String token){
		DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
		return verify;
	}
	
}
