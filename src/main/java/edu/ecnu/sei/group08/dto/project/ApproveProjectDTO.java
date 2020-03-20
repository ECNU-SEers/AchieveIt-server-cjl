package edu.ecnu.sei.group08.dto.project;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import edu.ecnu.sei.group08.model.ClientDO;
import edu.ecnu.sei.group08.model.FunctionDO;
import edu.ecnu.sei.group08.model.MilestoneDO;
import edu.ecnu.sei.group08.model.ProjectBusinessAreaDO;
import edu.ecnu.sei.group08.model.ProjectDO;
import edu.ecnu.sei.group08.model.ProjectSkillDO;
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
public class ApproveProjectDTO {

	/**
	 * 项目基本信息
	 */
	private RetrieveProjectDTO projectInfo;
	
	/**
	 * 项目立项中项目上级的审核结果
	 */
	@NotEmpty(message = "{project.reviewResult.not-empty}")
	private boolean reviewResult;
}
