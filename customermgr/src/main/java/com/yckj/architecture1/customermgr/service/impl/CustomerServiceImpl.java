package com.yckj.architecture1.customermgr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yckj.architecture1.common.service.impl.BaseServiceImpl;
import com.yckj.architecture1.customermgr.dao.CustomerDAO;
import com.yckj.architecture1.customermgr.service.ICustomerService;
import com.yckj.architecture1.customermgr.vo.CustomerModel;
import com.yckj.architecture1.customermgr.vo.CustomerQueryModel;
@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerModel, CustomerQueryModel> implements ICustomerService{
	private CustomerDAO dao;
	@Autowired
	public void setDao(CustomerDAO dao) {
		this.dao = dao;
		super.setDao(dao);
	}
}
