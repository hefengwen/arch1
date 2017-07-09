package com.yckj.architecture1.customermgr.dao;

import org.springframework.stereotype.Repository;

import com.yckj.architecture1.common.dao.BaseDAO;
import com.yckj.architecture1.customermgr.vo.CustomerModel;
import com.yckj.architecture1.customermgr.vo.CustomerQueryModel;
@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel,CustomerQueryModel>{
	
	CustomerModel getByCustomerId(String customerId);
}
