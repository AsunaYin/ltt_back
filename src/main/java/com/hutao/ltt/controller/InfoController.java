package com.hutao.ltt.controller;

import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.pojo.User;
import com.hutao.ltt.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/8 14:32
 */
@RestController
@RequestMapping("/myInfo")
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	
	/**
	 * 修改学生信息
	 *
	 * @param student
	 * @return
	 */
	@PostMapping("/student")
	public String updateStudentInfo(@RequestBody StudentInfo student) {
		
		int i = 0;
		try {
			i = infoService.updateStudentInfo(student);
		} catch (Exception e) {
			return "phone_duplicate";
		}
		if (1 == i) {
			return "success";
		} else return "error";
	}
	
	
	/**
	 * 修改老师信息
	 *
	 * @param teacher
	 * @return
	 */
	@PostMapping("/teacher")
	public String updateTeacherInfo(@RequestBody TeacherInfo teacher) {
		
		
		int i = 0;
		try {
			i = infoService.updateTeacherInfo(teacher);
		} catch (Exception e) {
			return "phone_duplicate";
		}
		if (1 == i) {
			return "success";
		} else return "error";
	}
	
	/**
	 * 修改密码
	 *
	 * @param user
	 * @return
	 */
	@PostMapping("/pwd")
	public String updatePwd(@RequestBody User user) {
		int i = infoService.updatePwd(user);
		if (1 == i) {
			return "success";
		} else return "error";
	}
	
	/**
	 * 上传头像
	 *
	 * @param uploadFile
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/uploadAvatar")
	public Map<String, Object> uploadAvatarHandler(@RequestParam("avatar") MultipartFile uploadFile) throws IOException {
		Map<String, Object> map = new HashMap<>();
		//获得项目的类路径
		String path = System.getProperty("user.dir");
		System.out.println(path);
		File uploadDir = new File(path + "/src/main/resources/static");
		
		if (!uploadDir.exists()) {
			System.out.println("上传头像路径不存在，正在创建...");
			uploadDir.mkdir();
		}
		if (uploadFile != null) {
			UUID uuid = UUID.randomUUID();
			//获得上传文件的文件名
			String oldName = uuid + uploadFile.getOriginalFilename();
			System.out.println("[上传的文件名]：" + oldName);
			
			File avatar = new File(path + "/src/main/resources/static/", oldName);
			try {
				//保存图片
				uploadFile.transferTo(avatar);
				//图片路径
				//String avatarUrl = path + "/src/main/resources/static/" + oldName;
				String avatarUrl = "http://localhost:8081/" + oldName;
				System.out.println(avatarUrl);
				map.put("msg", "success");
				map.put("avatarUrl", avatarUrl);
				return map;
			} catch (IOException e) {
				e.printStackTrace();
				map.put("msg", "error");
				return map;
			}
		} else {
			System.out.println("上传的文件为空");
			map.put("msg", "上传文件为空");
			return map;
		}
		
	}
	
}
