package edu.ecnu.sei.group08.model;

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
@TableName("sys_project_member")
public class MemberDO {

	private Long projectId;
	
	private Long userId;
	
	private String username;
	
	private String projectName;
	
}
