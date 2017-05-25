package com.yckj.architecture1.customermgr.vo;

import com.yckj.architecture1.common.pageutil.Page;

public class CustomerQueryModel extends CustomerModel{
	private Page<CustomerModel> page = new Page<>();

	public Page<CustomerModel> getPage() {
		return page;
	}

	public void setPage(Page<CustomerModel> page) {
		this.page = page;
	}
}
