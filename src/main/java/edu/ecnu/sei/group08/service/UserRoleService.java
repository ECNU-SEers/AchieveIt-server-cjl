package edu.ecnu.sei.group08.service;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.UserRoleDO;

/**
 * 
 * @author chenjialei
 *
 */
public interface UserRoleService extends IService<UserRoleDO> {

	/**
	 * 根据用户id和角色id检查用户角色是否存在
	 * @param userId
	 * @param roleId
	 * @return true代表存在
	 */
	boolean checkUserRoleExistByUserIdAndRoleId(Long userId, Long roleId);
}
