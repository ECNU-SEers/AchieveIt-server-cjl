package edu.ecnu.sei.group08.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.SkillMapper;
import edu.ecnu.sei.group08.model.SkillDO;
import edu.ecnu.sei.group08.service.SkillService;

@Service
public class SkillServiceImpl extends ServiceImpl<SkillMapper, SkillDO> implements SkillService {

	@Override
	public Long getSkillIdBySkillName(String skillName) {
		QueryWrapper<SkillDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(SkillDO::getName, skillName);
		SkillDO skill = this.getOne(queryWrapper);
		return skill.getId();
	}

}
