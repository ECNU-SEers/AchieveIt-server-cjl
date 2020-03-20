package edu.ecnu.sei.group08.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.MilestoneMapper;
import edu.ecnu.sei.group08.model.MilestoneDO;
import edu.ecnu.sei.group08.service.MilestoneService;

/**
 * 
 * @author chenjialei
 *
 */
@Service
public class MilestoneServiceImpl extends ServiceImpl<MilestoneMapper, MilestoneDO> implements MilestoneService {

	@Override
	public List<MilestoneDO> getProjectMilestoneByProjectId(Long projectId) {
		List<MilestoneDO> projectMilestones = this.baseMapper.selectProjectMilestoneByProjectId(projectId);
		return projectMilestones;
	}

}
