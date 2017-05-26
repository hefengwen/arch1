package com.yckj.architecture1.customermgr.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yckj.architecture1.common.pageutil.Page;
import com.yckj.architecture1.customermgr.BaseTest;
import com.yckj.architecture1.customermgr.vo.CustomerModel;
import com.yckj.architecture1.customermgr.vo.CustomerQueryModel;

public class CustomerServiceTest  extends BaseTest{
	@Autowired
	private ICustomerService service;
	@Test
	public void testCreate(){
		
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("1");
		cm.setPwd("c1");
		cm.setRegisterTime("111");
		cm.setShowName("c1");
		cm.setTrueName("t1");
		
		service.create(cm);
	}
	@Test
	public void testGetByConditionPage(){
		Page<CustomerModel> list = service.getByConditionPage(new CustomerQueryModel());
		System.out.println("list="+list);
	} 
}
