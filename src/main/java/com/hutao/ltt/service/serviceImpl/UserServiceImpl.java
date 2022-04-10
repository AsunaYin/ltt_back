package com.hutao.ltt.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hutao.ltt.mapper.UserMapper;
import com.hutao.ltt.mapper.manager.StudentMapper;
import com.hutao.ltt.mapper.manager.TeacherMapper;
import com.hutao.ltt.pojo.StudentInfo;
import com.hutao.ltt.pojo.TeacherInfo;
import com.hutao.ltt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/15 18:52
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	/**
	 * 查询所有学生信息
	 * @return
	 */
//	@Override
//	public List<StudentInfo> selectAllStudent() {
//		return userMapper.selectAllStudent();
//	}
	
	/**
	 * 查询所有老师信息
	 * @return
	 */
//	@Override
//	public List<TeacherInfo> selectAllTeacher() {
//		return userMapper.selectAllTeacher();
//	}
	
	/**
	 * 分页显示学生
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public IPage<StudentInfo> selectAllStudentsByPage(Integer pageNum,Integer pageSize){
		Page<StudentInfo> page = new Page<>(pageNum,pageSize);
		return studentMapper.selectPage(page,null);
	}
	
	/**
	 * 分页显示老师
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public IPage<TeacherInfo> selectAllTeachersByPage(Integer pageNum,Integer pageSize){
		Page<TeacherInfo> page = new Page<>(pageNum,pageSize);
		return teacherMapper.selectPage(page,null);
	}
	
	/**
	 * 根据id查找学生信息
	 * @param id
	 * @return
	 */
	@Override
	public StudentInfo selectStudentById(Integer id) {
		return studentMapper.selectById(id);
	}
	
	/**
	 * 根据id查找老师信息
	 * @param id
	 * @return
	 */
	@Override
	public TeacherInfo selectTeacherById(Integer id) {
		return teacherMapper.selectById(id);
	}
	
	/**
	 * 根据 account 获取学生信息
	 * @param account
	 * @return
	 */
	@Override
	public StudentInfo selectStudentByAccount(String account) {
		QueryWrapper<StudentInfo> wrapper = new QueryWrapper<>();
		wrapper.eq("account",account);
		return studentMapper.selectOne(wrapper);
	}
	
	/**
	 * 根据 account 获取老师信息
	 * @param account
	 * @return
	 */
	@Override
	public TeacherInfo selectTeacherByAccount(String account) {
		QueryWrapper<TeacherInfo> wrapper = new QueryWrapper<>();
		wrapper.eq("account",account);
		return teacherMapper.selectOne(wrapper);
	}
	
	/**
	 * 修改学生信息
	 * @param studentInfo
	 * @return 影响的行数
	 */
	@Override
	public int updateStudentInfo(StudentInfo studentInfo) throws Exception {
		return studentMapper.updateById(studentInfo);
	}
	
	/**
	 * 修改老师信息
	 * @param teacherInfo
	 * @return
	 */
	@Override
	public int updateTeacherInfo(TeacherInfo teacherInfo) throws Exception {
		int i = teacherMapper.updateById(teacherInfo);
		return i;
	}
	
	/**
	 * 根据id删除学生
	 * @param id
	 * @return
	 */
	@Override
	public int deleteStudentById(Integer id) {
		return studentMapper.deleteById(id);
	}
	
	/**
	 * 根据id删除老师
	 * @param id
	 * @return
	 */
	@Override
	public int deleteTeacherById(Integer id) {
		return teacherMapper.deleteById(id);
	}
	
	/**
	 * 在info表删完数据后，在user表里也得删
	 * @param account
	 * @return
	 */
	@Override
	public int deleteByAccount(String account) {
		return userMapper.deleteByAccount(account);
	}
	
	/**
	 * 根据姓名查找学生
	 * @param realName
	 * @return
	 */
	@Override
	public IPage<StudentInfo> selectByStudentName(Integer pageNum,Integer pageSize,String realName){
		QueryWrapper<StudentInfo> wrapper = new QueryWrapper<>();
		wrapper.like("realname",realName);
		Page<StudentInfo> page = new Page<>(pageNum,pageSize);
		return studentMapper.selectPage(page,wrapper);
	}
	
	
	/**
	 * 根据姓名查找老师
	 * @param realName
	 * @return
	 */
	@Override
	public IPage<TeacherInfo> selectByTeacherName(Integer pageNum,Integer pageSize,String realName){
		QueryWrapper<TeacherInfo> wrapper = new QueryWrapper<>();
		wrapper.like("realname",realName);
		Page<TeacherInfo> page = new Page<>(pageNum,pageSize);
		return teacherMapper.selectPage(page,wrapper);
	}
	
	
	
	
}
