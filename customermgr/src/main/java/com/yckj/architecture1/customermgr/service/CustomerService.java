package com.yckj.architecture1.customermgr.service;

import com.yckj.architecture1.common.service.BaseService;
import com.yckj.architecture1.customermgr.vo.CustomerModel;
import com.yckj.architecture1.customermgr.vo.CustomerQueryModel;

public interface CustomerService extends BaseService<CustomerModel, CustomerQueryModel>{

	CustomerModel getByCustomerId(String customerId);
}
