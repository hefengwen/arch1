package com.yckj.architecture1.goodsmgr.dao;

import org.springframework.stereotype.Repository;

import com.yckj.architecture1.common.dao.BaseDAO;
import com.yckj.architecture1.goodsmgr.vo.GoodsModel;
import com.yckj.architecture1.goodsmgr.vo.GoodsQueryModel;

@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel,GoodsQueryModel>{
	
}
