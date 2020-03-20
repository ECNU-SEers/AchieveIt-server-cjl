package edu.ecnu.sei.group08.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.ecnu.sei.group08.model.MilestoneDO;

/**
 * 
 * @author chenjialei
 *
 */
@Repository
public interface MilestoneMapper extends BaseMapper<MilestoneDO> {

	/**
	 * 利用projectId找到所有该project的里程碑
	 * @param projectId
	 * @return 所有该project的里程碑
	 */
	List<MilestoneDO> selectProjectMilestoneByProjectId(@Param("projectId")Long projectId);
}
