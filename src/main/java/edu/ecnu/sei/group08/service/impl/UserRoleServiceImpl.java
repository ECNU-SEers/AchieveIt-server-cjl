package edu.ecnu.sei.group08.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.UserRoleMapper;
import edu.ecnu.sei.group08.model.UserRoleDO;
import edu.ecnu.sei.group08.service.UserRoleService;

/**
 * 
 * @author chenjialei
 *
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleDO> implements UserRoleService {

	@Override
	public boolean checkUserRoleExistByUserIdAndRoleId(Long userId, Long roleId) {
		QueryWrapper<UserRoleDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(UserRoleDO::getUserId, userId).eq(UserRoleDO::getRoleId, roleId);
		int row = this.baseMapper.selectCount(queryWrapper);
		return row > 0;
	}

}
