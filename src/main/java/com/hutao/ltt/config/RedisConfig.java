//package com.hutao.ltt.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author HUTAO
// * @Description
// * @date 2022/3/30 15:19
// */
////@Configuration
////public class RedisConfig {
////
////	@Bean
////	RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
////
////		RedisTemplate redisTemplate = new RedisTemplate();
////		redisTemplate.setConnectionFactory(redisConnectionFactory);
////
////		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
////		jackson2JsonRedisSerializer.setObjectMapper(new ObjectMapper());
////
////		redisTemplate.setKeySerializer(new StringRedisSerializer());
////		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
////
////		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
////		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
////
////		return redisTemplate;
////
////	}
////
////}