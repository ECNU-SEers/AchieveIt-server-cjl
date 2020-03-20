package edu.ecnu.sei.group08.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.ProjectSkillDO;

/**
 * 
 * @author chenjialei
 *
 */
public interface ProjectSkillService extends IService<ProjectSkillDO> {

	/**
	 * 通过project_id找到项目使用的所有技术
	 * @param projectId
	 * @return 项目所有的技术
	 */
	List<ProjectSkillDO> getProjectSkillByProjectId(Long projectId);
	
	/**
	 * 通过project_id删除项目使用的所有技术
	 * @param projectId
	 * @return 
	 */
	int deleteProjectSkillByProjectId(Long projectId);
}
