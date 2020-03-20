package edu.ecnu.sei.group08.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("sys_project_skill")
public class ProjectSkillDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long projectId;
	
	private Long skillId;
	
	private String skillName;
}
