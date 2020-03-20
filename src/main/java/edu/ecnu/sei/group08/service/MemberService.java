package edu.ecnu.sei.group08.service;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.MemberDO;

/**
 * 
 * @author chenjialei
 *
 */
public interface MemberService extends IService<MemberDO> {

	/**
	 * 利用project表id查询某个project的所有成员个数
	 * @param projectId
	 * @return 某个project的所有成员个数
	 */
	int selectCountByProjectId(Long projectId);
	
	/**
	 * 利用project表id和用户id查询某个project的所有成员个数
	 * @param projectId
	 * @param userId
	 * @return某个project的所有成员个数
	 */
	boolean checkMemberExistByProjectIdAndUserId(Long projectId, Long userId);
}
