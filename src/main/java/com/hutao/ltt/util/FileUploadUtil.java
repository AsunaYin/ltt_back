package com.hutao.ltt.util;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author HUTAO
 * @Description 文件上传工具类
 * @date 2022/4/8 20:32
 */
public class FileUploadUtil {
	
	public static String uploadImage(MultipartFile file, String dirPath){
		File folder = new File(dirPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String oldName = file.getOriginalFilename();
		String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
		try {
			file.transferTo(new File(folder, newName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newName;
	}
	
	public static void deleteFiles(File file){
		if(file.exists())
			file.delete();
	}
	
}
