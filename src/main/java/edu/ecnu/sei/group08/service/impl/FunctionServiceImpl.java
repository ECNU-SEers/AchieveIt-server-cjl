package edu.ecnu.sei.group08.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.FunctionMapper;
import edu.ecnu.sei.group08.model.FunctionDO;
import edu.ecnu.sei.group08.service.FunctionService;

/**
 * 
 * @author chenjialei
 *
 */
@Service
public class FunctionServiceImpl extends ServiceImpl<FunctionMapper, FunctionDO> implements FunctionService {

	@Override
	public List<FunctionDO> getProjectFunctionByProjectId(Long projectId) {
		List<FunctionDO> projectFunctions = this.baseMapper.selectProjectFunctionByProjectId(projectId);
		return projectFunctions;
	}

}
