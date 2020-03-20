package edu.ecnu.sei.group08.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.FunctionDO;

/**
 * 
 * @author chenjialei
 *
 */
public interface FunctionService extends IService<FunctionDO> {

	/**
	 * 通过project_id找到项目的所有功能
	 * @param projectId
	 * @return 项目所有的功能
	 */
	List<FunctionDO> getProjectFunctionByProjectId(Long projectId);
}
