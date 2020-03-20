package edu.ecnu.sei.group08.model;

import java.io.Serializable;
import java.util.Date;

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
@TableName("sys_project")
public class ProjectDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	private String outerId;
	
	private String name;
	
	private String startDate;
	
	private String endDate;
	
	private String state;
	
	private Long clientId;
	
	private Long supervisorId;
	
	private String supervisorName;
	
	private Long managerId;
	
	private String managerName;
	
	private int qaAssigned;
	
	private int epgAssigned;
	
	private String remark;
	
}
