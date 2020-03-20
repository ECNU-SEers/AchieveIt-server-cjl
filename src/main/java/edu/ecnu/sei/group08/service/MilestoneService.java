package edu.ecnu.sei.group08.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.MilestoneDO;

/**
 * 
 * @author chenjialei
 *
 */
public interface MilestoneService extends IService<MilestoneDO> {

	/**
	 * 通过project_id找到项目的里程碑
	 * @param projectId
	 * @return 项目的所有里程碑
	 */
	List<MilestoneDO> getProjectMilestoneByProjectId(Long projectId);
}
