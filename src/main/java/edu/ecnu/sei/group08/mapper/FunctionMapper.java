package edu.ecnu.sei.group08.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.ecnu.sei.group08.model.FunctionDO;

/**
 * 
 * @author chenjialei
 *
 */
@Repository
public interface FunctionMapper extends BaseMapper<FunctionDO> {

	/**
	 * 利用projectId找到所有该project的功能
	 * @param projectId
	 * @return 所有该project的功能
	 */
	List<FunctionDO> selectProjectFunctionByProjectId(@Param("projectId")Long projectId);
}
