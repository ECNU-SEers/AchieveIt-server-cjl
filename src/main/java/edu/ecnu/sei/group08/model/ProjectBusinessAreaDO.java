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
@TableName("sys_project_business_area")
public class ProjectBusinessAreaDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long projectId;
	
	private Long businessAreaId;
	
	private String businessAreaName;
}
