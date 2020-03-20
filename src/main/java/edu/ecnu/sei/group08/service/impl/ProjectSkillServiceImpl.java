package edu.ecnu.sei.group08.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.ProjectSkillMapper;
import edu.ecnu.sei.group08.model.ProjectSkillDO;
import edu.ecnu.sei.group08.service.ProjectSkillService;

/**
 * 
 * @author chenjialei
 *
 */
@Service
public class ProjectSkillServiceImpl extends ServiceImpl<ProjectSkillMapper, ProjectSkillDO> implements ProjectSkillService {

	@Override
	public List<ProjectSkillDO> getProjectSkillByProjectId(Long projectId) {
		List<ProjectSkillDO> projectSkills = this.baseMapper.selectProjectSkillByProjectId(projectId);
		return projectSkills;
	}

	@Override
	public int deleteProjectSkillByProjectId(Long projectId) {
		return this.baseMapper.deleteProjectSkillByProjectId(projectId);
	}

}
