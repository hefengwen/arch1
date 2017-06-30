package com.yckj.architecture1.cartmgr.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yckj.architecture1.cartmgr.dao.CartDAO;
import com.yckj.architecture1.cartmgr.service.CartService;
import com.yckj.architecture1.cartmgr.vo.CartModel;
import com.yckj.architecture1.cartmgr.vo.CartQueryModel;
import com.yckj.architecture1.common.service.impl.BaseServiceImpl;

@Service
@Transactional
public class CartServiceImpl extends BaseServiceImpl<CartModel,CartQueryModel> implements CartService{
	private CartDAO dao = null;
	@Autowired
	private void setDao(CartDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}