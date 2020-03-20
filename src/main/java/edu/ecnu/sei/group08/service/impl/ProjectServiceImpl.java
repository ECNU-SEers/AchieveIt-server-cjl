package edu.ecnu.sei.group08.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import edu.ecnu.sei.group08.common.LocalUser;
import edu.ecnu.sei.group08.dto.project.ApproveProjectDTO;
import edu.ecnu.sei.group08.dto.project.CreateProjectDTO;
import edu.ecnu.sei.group08.dto.project.RetrieveProjectDTO;
import edu.ecnu.sei.group08.dto.project.ShowProjectListDTO;
import edu.ecnu.sei.group08.dto.project.UpdateProjectDTO;
import edu.ecnu.sei.group08.mapper.ClientMapper;
import edu.ecnu.sei.group08.mapper.MemberMapper;
import edu.ecnu.sei.group08.mapper.MilestoneMapper;
import edu.ecnu.sei.group08.mapper.ProjectBusinessAreaMapper;
import edu.ecnu.sei.group08.mapper.ProjectMapper;
import edu.ecnu.sei.group08.mapper.ProjectSkillMapper;
import edu.ecnu.sei.group08.mapper.UserRoleMapper;
import edu.ecnu.sei.group08.model.ClientDO;
import edu.ecnu.sei.group08.model.FunctionDO;
import edu.ecnu.sei.group08.model.MemberDO;
import edu.ecnu.sei.group08.model.MilestoneDO;
import edu.ecnu.sei.group08.model.ProjectBusinessAreaDO;
import edu.ecnu.sei.group08.model.ProjectDO;
import edu.ecnu.sei.group08.model.ProjectSkillDO;
import edu.ecnu.sei.group08.model.UserRoleDO;
import edu.ecnu.sei.group08.service.BusinessAreaService;
import edu.ecnu.sei.group08.service.ClientService;
import edu.ecnu.sei.group08.service.FunctionService;
import edu.ecnu.sei.group08.service.MemberService;
import edu.ecnu.sei.group08.service.MilestoneService;
import edu.ecnu.sei.group08.service.ProjectBusinessAreaService;
import edu.ecnu.sei.group08.service.ProjectService;
import edu.ecnu.sei.group08.service.ProjectSkillService;
import edu.ecnu.sei.group08.service.SkillService;
import edu.ecnu.sei.group08.service.UserRoleService;
import edu.ecnu.sei.group08.service.UserService;
import io.github.talelin.autoconfigure.exception.ForbiddenException;

/**
 * 
 * @author chenjialei
 *
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectDO> implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private ProjectSkillMapper projectSkillMapper;
	
	@Autowired
	private BusinessAreaService businessAreaService;
	
	@Autowired
	private ProjectBusinessAreaMapper projectBusinessAreaMapper;
	
	@Autowired
	private ProjectSkillService projectSkillService;
	
	@Autowired
	private ProjectBusinessAreaService projectBusinessAreaService;
	
	@Autowired
	private MilestoneService milestoneService;
	
	@Autowired
	private FunctionService functionService;
	
	@Autowired
	private MilestoneMapper milestoneMapper;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private UserRoleService userRoleService;

	@Transactional
	@Override
	public ProjectDO createProject(CreateProjectDTO validator) {
//		1.验证该项目是否存在
		boolean projectIsExist = this.checkProjectExistByOuterId(validator.getOuterId());
		if (projectIsExist) {
			throw new ForbiddenException("project already exist, please choose a new one", 20001);
		}

//		2.设置项目状态和客户表ID后创建项目
		ProjectDO project = new ProjectDO();
		BeanUtil.copyProperties(validator, project);
		project.setState("申请立项");
//		通过客户名称和客户ID得到客户表ID
		project.setClientId(clientService.getIdByOuterIdAndCompany(validator.getClientOuterId(), validator.getCompany()));
		projectMapper.insert(project);
		
		Long projectId = project.getId();
//		3.添加项目采用技术
		List<String> skillNames = validator.getSkillNames();
		ProjectSkillDO projectSkill = new ProjectSkillDO();
		projectSkill.setProjectId(projectId);
		for (String skillName: skillNames) {
			projectSkill.setSkillId(skillService.getSkillIdBySkillName(skillName));
			projectSkill.setSkillName(skillName);
			projectSkillMapper.insert(projectSkill);
		}
		
//		4.添加项目业务领域
//		业务领域不为空时
		if (validator.getBusinessAreaName() != null && !validator.getBusinessAreaName().equals("")) {
			ProjectBusinessAreaDO projectBusinessArea = new ProjectBusinessAreaDO();
			projectBusinessArea.setProjectId(projectId);
			projectBusinessArea.setBusinessAreaId(businessAreaService.getBusinessAreaIdByBusinessAreaName(validator.getBusinessAreaName()));
			projectBusinessArea.setBusinessAreaName(validator.getBusinessAreaName());
			projectBusinessAreaMapper.insert(projectBusinessArea);
		}
		
		return project;
	}

	@Override
	public RetrieveProjectDTO retrieveProject(String outerId) {
//		1.利用outerId得到project表中的所有信息
		ProjectDO project = this.getProjectByOuterId(outerId);
//		2.利用project表中的client_id得到client表中的信息
		ClientDO client = clientService.getClientById(project.getClientId());
//		3.利用project表中的id得到project_skill表中的信息
		List<ProjectSkillDO> projectSkills = projectSkillService.getProjectSkillByProjectId(project.getId());
//		4.利用project表中的id得到project_business_area表中的信息
		ProjectBusinessAreaDO projectBusinessArea = projectBusinessAreaService.getProjectBusinessAreaByProjectId(project.getId());
//		5.利用project表中的id得到milestone表中的信息
		List<MilestoneDO> milestones = milestoneService.getProjectMilestoneByProjectId(project.getId());
//		6.利用project表中的id得到project_function表中的信息
		List<FunctionDO> functions = functionService.getProjectFunctionByProjectId(project.getId());
//		7.查询项目对象
		RetrieveProjectDTO retrieveProject = new RetrieveProjectDTO();
		retrieveProject.setProject(project);
		retrieveProject.setProjectClient(client);
		retrieveProject.setProjectSkills(projectSkills);
		retrieveProject.setProjectBusinessArea(projectBusinessArea);
		retrieveProject.setProjectMilestones(milestones);
		retrieveProject.setProjectFunctions(functions);
		
		return retrieveProject;
	}
	
	@Override
	public List<RetrieveProjectDTO> retrieveProjectWithNameIncludingKeyword(String keyword) {
//		1.利用keyword找到所有项目名称中包含该keyword的所有项目
		List<ProjectDO> projects = this.selectProjectByNameWithKeyword(keyword);
//		2.得到所有项目的详细信息
		List<RetrieveProjectDTO> projectsDetails = new ArrayList<RetrieveProjectDTO>();
		for (ProjectDO project: projects) {
			projectsDetails.add(this.retrieveProject(project.getOuterId()));
		}
		return projectsDetails;
	}
	
	@Override
	public ShowProjectListDTO showProjectList(String outerId) {
//		1.利用outerId得到project表中的所有信息
		ProjectDO project = this.getProjectByOuterId(outerId);
//		2.利用project表中的client_id得到client表中的company
		String company = clientService.getCompanyById(project.getClientId());
		ShowProjectListDTO projectList = new ShowProjectListDTO();
		BeanUtil.copyProperties(project, projectList);
		projectList.setCompany(company);
		projectList.setParticipantCounter(memberService.selectCountByProjectId(project.getId()));
		if (project.getQaAssigned() == 1) {
			projectList.setQaAssigned("已分配");
		} else {
			projectList.setQaAssigned("未分配");
		}
		if (project.getEpgAssigned() == 1) {
			projectList.setEpgAssigned("已分配");
		} else {
			projectList.setEpgAssigned("未分配");
		}
		return projectList;
	}
	
	@Transactional
	@Override
	public ProjectDO updateProjectInfo(UpdateProjectDTO validator) {
//		1.利用projectId找到待修改的project，判断项目是否“结束”或“已归档”
		ProjectDO primaryProject = this.getProjectByOuterId(validator.getOuterId());
		if (primaryProject.getState().equals("结束") || primaryProject.getState().equals("已归档")) {
			throw new ForbiddenException("project already expire, cannot be updated, please choose a new one", 20002);
		}
//		2.更新project表
		ProjectDO project = new ProjectDO();
		BeanUtil.copyProperties(validator, project);
		Long projectId = primaryProject.getId();
		project.setId(projectId);
		project.setState(primaryProject.getState());
		project.setClientId(clientService.getIdByOuterIdAndCompany(validator.getClientOuterId(), validator.getCompany()));
		project.setManagerId(primaryProject.getManagerId());
		project.setManagerName(primaryProject.getManagerName());
		projectMapper.updateById(project);
		
//		3.更新project_skill表：删掉旧的，添加新的
		projectSkillService.deleteProjectSkillByProjectId(projectId);
		
		List<String> skillNames = validator.getSkillNames();
		ProjectSkillDO projectSkill = new ProjectSkillDO();
		projectSkill.setProjectId(projectId);
		for (String skillName: skillNames) {
			projectSkill.setSkillId(skillService.getSkillIdBySkillName(skillName));
			projectSkill.setSkillName(skillName);
			projectSkillMapper.insert(projectSkill);
		}
		
//		4.更新project_business_area表：删掉旧的，添加新的
		projectBusinessAreaService.deleteProjectBusinessAreaByProjectId(projectId);
		
		if (validator.getBusinessAreaName() != null && !validator.getBusinessAreaName().equals("")) {
			ProjectBusinessAreaDO projectBusinessArea = new ProjectBusinessAreaDO();
			projectBusinessArea.setProjectId(projectId);
			projectBusinessArea.setBusinessAreaId(businessAreaService.getBusinessAreaIdByBusinessAreaName(validator.getBusinessAreaName()));
			projectBusinessArea.setBusinessAreaName(validator.getBusinessAreaName());
			projectBusinessAreaMapper.insert(projectBusinessArea);
		}
		
		
//		5.更新milestone表：insert一条新纪录
		MilestoneDO milestone = new MilestoneDO();
		milestone.setProjectId(projectId);
		milestone.setProgress(validator.getMilestone());
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		milestone.setRecordDate(formatter.format(date));
		milestone.setRecorderId(LocalUser.getLocalUser().getId());
		milestoneMapper.insert(milestone);
		
		return project;
	}
	
	@Override
	public ProjectDO getProjectByOuterId(String outerId) {
		QueryWrapper<ProjectDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(ProjectDO::getOuterId, outerId);
		return this.getOne(queryWrapper);
	}

	@Override
	public boolean checkProjectExistByOuterId(String outerId) {
		int rows = this.baseMapper.selectCountByOuterId(outerId);
		return rows > 0;
	}

	@Override
	public List<ProjectDO> selectProjectByNameWithKeyword(String keyword) {
		return this.baseMapper.selectByNameLikeKeyword(keyword);
	}

	@Override
	public ApproveProjectDTO acceptProject(RetrieveProjectDTO projectInfo) {
		if (!projectInfo.getProject().getState().equals("申请立项")) {
			throw new ForbiddenException("The project is not in the state of applying for project approval.", 20003);
		}
		ApproveProjectDTO approveProject = new ApproveProjectDTO();
		approveProject.setProjectInfo(projectInfo);
		approveProject.setReviewResult(true);
		ProjectDO project = new ProjectDO();
		BeanUtil.copyProperties(projectInfo.getProject(), project);
		project.setState("已立项");
		projectMapper.updateById(project);
		return approveProject;
	}

	@Override
	public ApproveProjectDTO rejectProject(RetrieveProjectDTO projectInfo) {
		if (!projectInfo.getProject().getState().equals("申请立项")) {
			throw new ForbiddenException("The project is not in the state of applying for project approval.", 20003);
		}
		ApproveProjectDTO approveProject = new ApproveProjectDTO();
		approveProject.setProjectInfo(projectInfo);
		approveProject.setReviewResult(false);
		ProjectDO project = new ProjectDO();
		BeanUtil.copyProperties(projectInfo.getProject(), project);
		project.setState("立项驳回");
		projectMapper.updateById(project);
		return approveProject;
	}

	@Override
	public ProjectDO assignQA(String outerId, List<Long> userId) {
//		1.改变project表的qa_assigned
		ProjectDO project = this.getProjectByOuterId(outerId);
		project.setQaAssigned(1);
		projectMapper.updateById(project);
//		2.将分配的QA加入project_member表
		Long projectId = project.getId();
		MemberDO member = new MemberDO();
		member.setProjectId(projectId);
		member.setProjectName(project.getName());
		for (Long id: userId) {
			if (!memberService.checkMemberExistByProjectIdAndUserId(projectId, id)) {
				member.setUserId(id);
				member.setUsername(userService.getById(id).getUsername());
				memberMapper.insert(member);
			}
		}
//		3.将分配的QA加入user_role表
		Long roleId = 2L; // 角色QA对应的id
		for (Long id: userId) {
			if (!userRoleService.checkUserRoleExistByUserIdAndRoleId(id, roleId)) {
				UserRoleDO userRole = new UserRoleDO(id, roleId);
				userRoleMapper.insert(userRole);
			}
		}
		return project;
	}

	@Override
	public ProjectDO assignEQG(String outerId, List<Long> userId) {
//		1.改变project表的epg_assigned
		ProjectDO project = this.getProjectByOuterId(outerId);
		project.setEpgAssigned(1);
		projectMapper.updateById(project);
//		2.将分配的QA加入project_member表
		Long projectId = project.getId();
		MemberDO member = new MemberDO();
		member.setProjectId(projectId);
		member.setProjectName(project.getName());
		for (Long id: userId) {
			if (!memberService.checkMemberExistByProjectIdAndUserId(projectId, id)) {
				member.setUserId(id);
				member.setUsername(userService.getById(id).getUsername());
				memberMapper.insert(member);
			}
		}
//		3.将分配的EPG加入user_role表
		Long roleId = 3L; // 角色EPG对应的id
		for (Long id: userId) {
			if (!userRoleService.checkUserRoleExistByUserIdAndRoleId(id, roleId)) {
				UserRoleDO userRole = new UserRoleDO(id, roleId);
				userRoleMapper.insert(userRole);
			}
		}
		return project;
	}

	@Override
	public ProjectDO endProject(String outerId) {
		ProjectDO project = this.getProjectByOuterId(outerId);
		project.setState("结束");
		projectMapper.updateById(project);
		return project;
	}

	@Override
	public ProjectDO acceptArchive(String outerId) {
		ProjectDO project = this.getProjectByOuterId(outerId);
		project.setState("已归档");
		projectMapper.updateById(project);
		return project;
	}

}
