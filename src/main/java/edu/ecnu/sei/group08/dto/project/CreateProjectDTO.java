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
public class CreateProjectDTO {
	
	@NotBlank(message = "{project.outerId.not-blank}")
	@Size(max = 15, message = "{project.outerId.size}")
	private String outerId;
	
	@NotBlank(message = "{project.name.not-blank}")
	@Size(max = 50, message = "{project.name.size}")
	private String name;
	
	@NotBlank(message = "{project.startDate.not-blank}")
	@Size(max = 10, message = "{project.startDate.size}")
	private String startDate;
	
	@NotBlank(message = "{project.endDate.not-blank}")
	@Size(max = 10, message = "{project.endDate.size}")
	private String endDate;	
	
	/**
	 * 客户ID
	 */
	@NotBlank(message = "{project.clientOuterId.not-blank}")
	@Size(max = 50, message = "{project.clientOuterId.size}")
	private String clientOuterId;
	
	/**
	 * 客户名称
	 */
	@NotBlank(message = "{project.company.not-blank}")
	@Size(max = 50, message = "{project.company.size}")
	private String company;
	
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
	
	/**
	 * 采用技术名称
	 */
	@NotEmpty(message = "{project.skillNames.not-blank}")
	private List<String> skillNames;
	
	/**
	 * 业务领域名称
	 */
//	@NotBlank(message = "{project.businessAreaName.not-blank}")
	@Size(max = 50, message = "{project.businessAreaName.size}")
	private String businessAreaName;
	
	/**
	 * 项目立项中项目上级的审核结果
	 */
	@NotEmpty(message = "{project.reviewResult.not-empty}")
	private boolean reviewResult;

}
