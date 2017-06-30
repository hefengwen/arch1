package com.yckj.architecture1.goodsmgr.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yckj.architecture1.common.service.impl.BaseServiceImpl;
import com.yckj.architecture1.goodsmgr.dao.GoodsDAO;
import com.yckj.architecture1.goodsmgr.service.GoodsService;
import com.yckj.architecture1.goodsmgr.vo.GoodsModel;
import com.yckj.architecture1.goodsmgr.vo.GoodsQueryModel;

@Service
@Transactional
public class GoodsServiceImpl extends BaseServiceImpl<GoodsModel,GoodsQueryModel> implements GoodsService{
	private GoodsDAO dao = null;
	@Autowired
	private void setDao(GoodsDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}