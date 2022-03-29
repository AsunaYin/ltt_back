package com.hutao.ltt.mapper.manager;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hutao.ltt.pojo.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/27 20:44
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentInfo> {
}
