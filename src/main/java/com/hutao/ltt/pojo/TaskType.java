package com.hutao.ltt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author HUTAO
 * @Description
 * @date 2022/4/13 15:06
 */
@Data
@TableName("task_type")
public class TaskType {
	
	@TableId(type = IdType.AUTO)
	private Integer id;
	@TableField("typename")
	private String typeName;

}
