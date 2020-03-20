package edu.ecnu.sei.group08.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.ecnu.sei.group08.mapper.ClientMapper;
import edu.ecnu.sei.group08.model.ClientDO;
import edu.ecnu.sei.group08.service.ClientService;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, ClientDO> implements ClientService {

	@Override
	public Long getIdByOuterIdAndCompany(String outerId, String company) {
		QueryWrapper<ClientDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(ClientDO::getOuterId, outerId).eq(ClientDO::getCompany, company);
		ClientDO client = this.getOne(queryWrapper);
		return client.getId();
	}

	@Override
	public String getCompanyById(Long id) {
		QueryWrapper<ClientDO> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(ClientDO::getId, id);
		ClientDO client = this.getOne(queryWrapper);
		return client.getCompany();
	}

	@Override
	public ClientDO getClientById(Long id) {
		return this.baseMapper.selectById(id);
	}

}
