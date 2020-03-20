package edu.ecnu.sei.group08.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.ecnu.sei.group08.model.ProjectBusinessAreaDO;

/**
 * 
 * @author chenjialei
 *
 */
@Repository
public interface ProjectBusinessAreaMapper extends BaseMapper<ProjectBusinessAreaDO> {

	/**
	 * 利用projectId找到所有该project的业务领域
	 * @param projectId
	 * @return 该project的业务领域
	 */
	ProjectBusinessAreaDO selectProjectBusinessAreaByProjectId(@Param("projectId")Long projectId);
	
	/**
	 * 利用projectId删除该project的业务领域
	 * @param projectId
	 * @return
	 */
	int deleteProjectBusinessAreaByProjectId(@Param("projectId")Long projectId);
}
