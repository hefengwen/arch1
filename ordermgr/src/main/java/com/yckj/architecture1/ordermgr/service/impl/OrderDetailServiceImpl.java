package com.yckj.architecture1.ordermgr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yckj.architecture1.common.service.impl.BaseServiceImpl;
import com.yckj.architecture1.ordermgr.dao.OrderDetailDAO;
import com.yckj.architecture1.ordermgr.service.OrderDetailService;
import com.yckj.architecture1.ordermgr.vo.OrderDetailModel;
import com.yckj.architecture1.ordermgr.vo.OrderDetailQueryModel;
@Service
@Transactional
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetailModel,OrderDetailQueryModel> implements OrderDetailService{
	private OrderDetailDAO dao = null;
	@Autowired
	private void setDao(OrderDetailDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
}
