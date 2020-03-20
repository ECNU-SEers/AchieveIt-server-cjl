package edu.ecnu.sei.group08.controller.cms;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ecnu.sei.group08.activiti.ProcessManagementService;
import edu.ecnu.sei.group08.common.utils.ResponseUtil;
import edu.ecnu.sei.group08.dto.project.CreateProjectDTO;
import edu.ecnu.sei.group08.service.ProjectService;
import edu.ecnu.sei.group08.vo.UnifyResponseVO;
import io.github.talelin.core.token.DoubleJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author chenjialei
 *
 */
@RestController
@RequestMapping("/cms/project")
@Validated
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private DoubleJWT jwt;
	
//	@Autowired
//	private ProcessManagementService processManagementService;
	
	/**
	 * 项目经理新建项目（010102）
	 */
	@PostMapping("/createProject")
	public UnifyResponseVO<String> createProject(@RequestBody @Validated CreateProjectDTO validator) {
//		1.新建项目
		projectService.createProject(validator);
//		2.启动流程实例
//		processManagementService.startProcessInstance("projectApproval", projectService.getProjectByOuterId(validator.getOuterId()).getId().toString());
		
		return ResponseUtil.generateUnifyResponse(1001);
	}
	
	/**
	 * 利用项目ID和项目名称搜索项目（010101） & 查询项目（010201）
	 */
	
	
	
	/**
	 * 项目上级审核项目
	 */
	

}
