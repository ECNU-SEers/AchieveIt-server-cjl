package edu.ecnu.sei.group08.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.BusinessAreaMapper;
import edu.ecnu.sei.group08.model.BusinessAreaDO;
import edu.ecnu.sei.group08.service.BusinessAreaService;

@Service
public class BusinessAreaServiceImpl extends ServiceImpl<BusinessAreaMapper, BusinessAreaDO> implements BusinessAreaService {

	@Override
	public Long getBusinessAreaIdByBusinessAreaName(String businessAreaName) {
		QueryWrapper<BusinessAreaDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(BusinessAreaDO::getName, businessAreaName);
		BusinessAreaDO businessArea = this.getOne(queryWrapper);
		return businessArea.getId();
	}

}
