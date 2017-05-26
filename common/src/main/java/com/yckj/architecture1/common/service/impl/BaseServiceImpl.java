package com.yckj.architecture1.common.service.impl;

import java.util.List;

import com.yckj.architecture1.common.dao.BaseDAO;
import com.yckj.architecture1.common.pageutil.Page;
import com.yckj.architecture1.common.service.BaseService;
import com.yckj.architecture1.common.vo.BaseModel;

public class BaseServiceImpl<M,QM extends BaseModel> implements BaseService<M,QM>{
	
	private BaseDAO<M,QM> dao = null;
	
	public void setDao(BaseDAO<M,QM> dao) {
		this.dao = dao;
	}

	@Override
	public void create(M m) {
		dao.create(m);
	}

	@Override
	public void update(M m) {
		dao.update(m);
	}

	@Override
	public void delete(int uuid) {
		dao.delete(uuid);
	}

	@Override
	public M getByUuid(int uuid) {
		return dao.getByUuid(uuid);
	}

	@Override
	public Page<M> getByConditionPage(QM qm) {
		List<M> list = dao.getByConditionPage(qm);
		qm.getPage().setResult(list);
		return qm.getPage();
	}

}
