package edu.ecnu.sei.group08.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.dto.project.ApproveProjectDTO;
import edu.ecnu.sei.group08.dto.project.CreateProjectDTO;
import edu.ecnu.sei.group08.dto.project.RetrieveProjectDTO;
import edu.ecnu.sei.group08.dto.project.ShowProjectListDTO;
import edu.ecnu.sei.group08.dto.project.UpdateProjectDTO;
import edu.ecnu.sei.group08.model.ProjectDO;
import edu.ecnu.sei.group08.model.RoleDO;

/**
 * 
 * @author chenjialei
 *
 */
public interface ProjectService extends IService<ProjectDO>  {
	
	/**
	 * 创建项目：项目经理录入项目信息并自动申请立项
	 * 
	 * @param validator 新建项目校验器
	 * @return 被创建的项目
	 */
	ProjectDO createProject(CreateProjectDTO validator);
	
	/**
	 * 查询项目基本信息
	 * @param outerId
	 * @return 项目基本信息
	 */
	RetrieveProjectDTO retrieveProject(String outerId);
	
	/**
	 * 查询所有项目名称中包含某关键字的项目详情
	 * @param keyword
	 * @return 所有项目名称包含该关键字的项目的详情
	 */
	List<RetrieveProjectDTO> retrieveProjectWithNameIncludingKeyword(String keyword);
	
	/**
	 * 展示项目列表
	 * @param outerId
	 * @return 项目列表信息
	 */
	ShowProjectListDTO showProjectList(String outerId);
	
    /**
     * 更新项目：修改项目信息
     *
     * @param validator 更新项目信息校验器
     * @return 被更新的项目
     */
	ProjectDO updateProjectInfo(UpdateProjectDTO validator);
	
    /**
     * 通过项目ID查找项目
     *
     * @param outerId 项目ID
     * @return 项目
     */
    ProjectDO getProjectByOuterId(String outerId);

    /**
     * 根据项目ID检查项目是否存在
     *
     * @param outerId 项目ID
     * @return true代表存在
     */
    boolean checkProjectExistByOuterId(String outerId);
    
    /**
     * 查询所有项目名称中包含某关键字的项目
     * @param keyword
     * @return 所有项目名称中包含某关键字的项目
     */
    List<ProjectDO> selectProjectByNameWithKeyword(String keyword);
    
    /**
     * 项目上级审批立项：审批通过
     * @param projectInfo
     * @return 项目信息和审批结果（通过）
     */
    ApproveProjectDTO acceptProject(RetrieveProjectDTO projectInfo);
    
    /**
     * 项目上级审批立项：驳回申请
     * @param projectInfo
     * @return 项目信息和审批结果（驳回）
     */
    ApproveProjectDTO rejectProject(RetrieveProjectDTO projectInfo);
    
    /**
     * QA经理为项目分配QA
     * @param outerId 项目ID
     * @param userId
     * @return 该项目
     */
    ProjectDO assignQA(String outerId, List<Long> userId);
    
    /**
     * EPG Leader为项目分配EPG
     * @param outerId 项目ID
     * @param userId
     * @return 该项目
     */
    ProjectDO assignEQG(String outerId, List<Long> userId);
    
    ProjectDO endProject(String outerId);
    
    ProjectDO acceptArchive(String outerId);
}
