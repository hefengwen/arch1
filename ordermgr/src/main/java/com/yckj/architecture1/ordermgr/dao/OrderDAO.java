package com.yckj.architecture1.ordermgr.dao;

import org.springframework.stereotype.Repository;

import com.yckj.architecture1.common.dao.BaseDAO;
import com.yckj.architecture1.ordermgr.vo.OrderModel;
import com.yckj.architecture1.ordermgr.vo.OrderQueryModel;

@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel>{
	
}
