package edu.ecnu.sei.group08.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.ecnu.sei.group08.model.MemberDO;

/**
 * 
 * @author chenjialei
 *
 */
@Repository
public interface MemberMapper extends BaseMapper<MemberDO> {

	/**
	 * 查询项目表id为$projectId的项目数
	 * @param projectId
	 * @return
	 */
	int selectCountByProjectId(Long projectId);
	
}
