package com.yckj.architecture1.ordermgr.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yckj.architecture1.common.service.impl.BaseServiceImpl;
import com.yckj.architecture1.ordermgr.dao.OrderDAO;
import com.yckj.architecture1.ordermgr.service.OrderService;
import com.yckj.architecture1.ordermgr.vo.OrderModel;
import com.yckj.architecture1.ordermgr.vo.OrderQueryModel;

@Service
@Transactional
public class OrderServiceImpl extends BaseServiceImpl<OrderModel,OrderQueryModel> implements OrderService{
	private OrderDAO dao = null;
	@Autowired
	private void setDao(OrderDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}