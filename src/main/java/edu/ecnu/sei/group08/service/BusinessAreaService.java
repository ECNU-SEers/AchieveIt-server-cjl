package edu.ecnu.sei.group08.service;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.BusinessAreaDO;

public interface BusinessAreaService extends IService<BusinessAreaDO> {

	/**
	 * 通过业务领域名称查找业务领域Id
	 * @param businessAreaName 业务名称
	 * @return 该业务名称对应的业务Id
	 */
	Long getBusinessAreaIdByBusinessAreaName(String businessAreaName);
}
