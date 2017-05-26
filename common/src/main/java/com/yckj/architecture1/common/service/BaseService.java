package com.yckj.architecture1.common.service;

import com.yckj.architecture1.common.pageutil.Page;
import com.yckj.architecture1.common.vo.BaseModel;

public interface BaseService<M, QM extends BaseModel> {
	public void create(M m);

	public void update(M m);

	public void delete(int uuid);

	public M getByUuid(int uuid);

	public Page<M> getByConditionPage(QM qm);
}
