package com.hutao.ltt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/9 17:47
 */
@Configuration
public class ResourceConfigAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		//获取文件的真实路径
		String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\";
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			registry.addResourceHandler("/**").
					addResourceLocations("file:"+path);
		}else{
			registry.addResourceHandler("/**").
					addResourceLocations("file:"+path);
		}
		super.addResourceHandlers(registry);
	}
}
