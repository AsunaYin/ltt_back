package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author HUTAO
 * @Description
 * @date 2022/3/29 15:39
 */
@Data
@TableName("stu_tea")
public class StuTea {
	private Integer sid;
	private Integer tid;
}
