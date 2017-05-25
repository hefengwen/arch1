package com.yckj.architecture1.customermgr.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yckj.architecture1.customermgr.BaseTest;
import com.yckj.architecture1.customermgr.vo.CustomerModel;
import com.yckj.architecture1.customermgr.vo.CustomerQueryModel;

public class CustomerDAOTest extends BaseTest{
	@Autowired
	private CustomerDAO dao;
	@Test
	public void testCreate(){
		
		CustomerModel cm = new CustomerModel();
		cm.setCustomerId("1");
		cm.setPwd("c1");
		cm.setRegisterTime("111");
		cm.setShowName("c1");
		cm.setTrueName("t1");
		
		dao.create(cm);
	}
	@Test
	public void testGetByConditionPage(){
		List<CustomerModel> list = dao.getByConditionPage(new CustomerQueryModel());
		System.out.println("list="+list);
	}
}
