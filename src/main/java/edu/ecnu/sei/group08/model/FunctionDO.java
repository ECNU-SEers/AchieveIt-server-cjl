package edu.ecnu.sei.group08.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author chenjialei
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("sys_project_function")
public class FunctionDO implements Serializable {

private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	private Long projectId;
	
	private String name;
	
	private Long parentId;
}
