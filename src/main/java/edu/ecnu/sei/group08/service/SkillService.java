package edu.ecnu.sei.group08.service;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.SkillDO;

public interface SkillService extends IService<SkillDO> {

	/**
	 * 通过技术名称查找技术Id
	 * @param skillName 技术名称
	 * @return 该技术名称对应的技术Id
	 */
	Long getSkillIdBySkillName(String skillName);
}
