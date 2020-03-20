package edu.ecnu.sei.group08.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.ProjectBusinessAreaMapper;
import edu.ecnu.sei.group08.model.ProjectBusinessAreaDO;
import edu.ecnu.sei.group08.service.ProjectBusinessAreaService;

@Service
public class ProjectBusinessAreaServiceImpl extends ServiceImpl<ProjectBusinessAreaMapper, ProjectBusinessAreaDO> implements ProjectBusinessAreaService {

	@Override
	public ProjectBusinessAreaDO getProjectBusinessAreaByProjectId(Long projectId) {
		ProjectBusinessAreaDO projectBusinessArea = this.baseMapper.selectProjectBusinessAreaByProjectId(projectId);
		return projectBusinessArea;
	}

	@Override
	public int deleteProjectBusinessAreaByProjectId(Long projectId) {
		return this.baseMapper.deleteProjectBusinessAreaByProjectId(projectId);
	}

}
