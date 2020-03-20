package edu.ecnu.sei.group08.dto.project;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author chenjialei
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class ShowProjectListDTO {
//	@NotEmpty(message = "{project.id.not-empty}")
//	private int id;
	
	@NotBlank(message = "{project.outerId.not-blank}")
	@Size(max = 50, message = "{project.outerId.size}")
	private String outerId;
	
	@NotBlank(message = "{project.name.not-blank}")
	@Size(max = 50, message = "{project.name.size}")
	private String name;
	
	/**
	 * 客户名称
	 */
	@NotBlank(message = "{project.company.not-blank}")
	@Size(max = 50, message = "{project.company.size}")
	private String company;
	
	@NotEmpty(message = "{project.startDate.not-empty}")
	private String startDate;
	
	@NotEmpty(message = "{project.endDate.not-empty}")
	private String endDate;
	
//	@NotBlank(message = "{project.state.not-blank}")
//	@Size(max = 50, message = "{project.state.size}")
//	private String state;
	
	@NotEmpty(message = "{project.supervisorId.not-empty}")
	private int supervisorId;

	@NotBlank(message = "{project.supervisorName.not-blank}")
	@Size(max = 50, message = "{project.supervisorName.size}")
	private String supervisorName;
	
	@NotEmpty(message = "{project.managerId.not-empty}")
	private int managerId;
	
	@NotBlank(message = "{project.managerName.not-blank}")
	@Size(max = 50, message = "{project.managerName.size}")
	private String managerName;
	
	@NotEmpty(message = "project.participantCounter.not-empty")
	private int participantCounter;
	
	@NotBlank(message = "{project.qaAssigned.not-blank}")
	@Size(max = 50, message = "{project.qaAssigned.size}")
	private String qaAssigned;
	
	@NotBlank(message = "{project.epgAssigned.not-blank}")
	@Size(max = 50, message = "{project.epgAssigned.size}")
	private String epgAssigned;
	
	/**
	 * 项目立项中项目上级的审核结果
	 */
	@NotEmpty(message = "{project.reviewResult.not-empty}")
	private boolean reviewResult;
}
