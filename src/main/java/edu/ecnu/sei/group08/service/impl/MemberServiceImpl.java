package edu.ecnu.sei.group08.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.MemberMapper;
import edu.ecnu.sei.group08.model.MemberDO;
import edu.ecnu.sei.group08.service.MemberService;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberDO> implements MemberService {

	@Override
	public int selectCountByProjectId(Long projectId) {
		return this.baseMapper.selectCountByProjectId(projectId);
	}

	@Override
	public boolean checkMemberExistByProjectIdAndUserId(Long projectId, Long userId) {
		QueryWrapper<MemberDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(MemberDO::getProjectId, projectId).eq(MemberDO::getUserId, userId);
		int row = this.baseMapper.selectCount(queryWrapper);
		return row > 0;
	}

}
