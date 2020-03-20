package edu.ecnu.sei.group08.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import edu.ecnu.sei.group08.model.ClientDO;

/**
 * 
 * @author chenjialei
 *
 */
public interface ClientService extends IService<ClientDO> {
	
	/**
	 * 通过客户ID和客户名称（公司名称）查找客户表Id
	 * @param outerId 客户ID
	 * @param company 公司名称
	 * @return
	 */
	Long getIdByOuterIdAndCompany(String outerId, String company);
	
	/**
	 * 通过客户表ID查找客户名称
	 * @param long 客户表Id
	 * @return 该客户表id对应的客户Id
	 */
	String getCompanyById(Long id);
	
	/**
	 * 通过客户表ID找到该客户
	 * @param id 客户表ID
	 * @return 客户
	 */
	ClientDO getClientById(Long id);
}
