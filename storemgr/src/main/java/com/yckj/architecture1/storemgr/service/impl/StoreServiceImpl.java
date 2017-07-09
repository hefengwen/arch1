package com.yckj.architecture1.storemgr.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yckj.architecture1.common.service.impl.BaseServiceImpl;
import com.yckj.architecture1.storemgr.dao.StoreDAO;
import com.yckj.architecture1.storemgr.service.StoreService;
import com.yckj.architecture1.storemgr.vo.StoreModel;
import com.yckj.architecture1.storemgr.vo.StoreQueryModel;

@Service
@Transactional
public class StoreServiceImpl extends BaseServiceImpl<StoreModel,StoreQueryModel> implements StoreService{
	private StoreDAO dao = null;
	@Autowired
	private void setDao(StoreDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	@Override
	public StoreModel getByGoodsUuid(int goodsUuid) {
		return dao.getByGoodsUuid(goodsUuid);
	}
	
}