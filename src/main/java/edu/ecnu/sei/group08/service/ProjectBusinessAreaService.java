package edu.ecnu.sei.group08.service;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.ProjectBusinessAreaDO;

public interface ProjectBusinessAreaService extends IService<ProjectBusinessAreaDO> {

	/**
	 * 通过project_id找到项目的业务领域
	 * @param projectId
	 * @return 项目的业务领域
	 */
	ProjectBusinessAreaDO getProjectBusinessAreaByProjectId(Long projectId);
	
	/**
	 * 通过project_id删除项目的业务领域
	 * @param projectId
	 * @return 
	 */
	int deleteProjectBusinessAreaByProjectId(Long projectId);
}
