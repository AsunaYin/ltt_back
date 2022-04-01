//package com.hutao.ltt.controller;
//
//import cn.hutool.core.lang.UUID;
//import cn.hutool.core.map.MapUtil;
//import com.google.code.kaptcha.Producer;
//import com.hutao.ltt.common.Const;
//import com.hutao.ltt.common.Result;
//import com.hutao.ltt.util.RedisUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sun.misc.BASE64Encoder;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//
///**
// * @author HUTAO
// * @Description 生成验证码
// * @date 2022/3/30 14:54
// */
////@RestController
////public class AuthController {
////
////	@Autowired
////	HttpServletRequest request;
////
////	@Autowired
////	Producer producer;
////
////	@Autowired
////	RedisUtil redisUtil;
////
////	@GetMapping("/captcha")
////	public Result captcha() throws IOException {
////		String key = UUID.randomUUID().toString();
////
////		//生成5位数验证码
////		String code = producer.createText();
////		BufferedImage image = producer.createImage(code);
////
////		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////		ImageIO.write(image, "jpg",outputStream);
////
////		BASE64Encoder encoder = new BASE64Encoder();
////		String str = "data:image/jpge;base64,";
////
////		String base64Img = str + encoder.encode(outputStream.toByteArray());
////
////		redisUtil.hset(Const.CAPTCHA_KEY, key, code, 120);
////
////		return Result.success(
////				MapUtil.builder().put("token",key)
////						.put("captchaImg",base64Img)
////						.build()
////		);
////
////	}
////
////}
