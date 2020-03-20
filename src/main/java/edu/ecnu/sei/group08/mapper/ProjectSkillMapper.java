package edu.ecnu.sei.group08.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.ecnu.sei.group08.model.ProjectSkillDO;

/**
 * 
 * @author chenjialei
 *
 */
@Repository
public interface ProjectSkillMapper extends BaseMapper<ProjectSkillDO> {

	/**
	 * 利用projectId找到所有该project采用的技术
	 * @param projectId
	 * @return 所有该project采用的技术
	 */
	List<ProjectSkillDO> selectProjectSkillByProjectId(@Param("projectId")Long projectId);
	
	/**
	 * 利用projectId删除所有该project采用的技术
	 * @param projectId
	 * @return
	 */
	int deleteProjectSkillByProjectId(@Param("projectId")Long projectId);
}
