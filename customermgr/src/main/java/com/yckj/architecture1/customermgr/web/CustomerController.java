package com.yckj.architecture1.customermgr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yckj.architecture1.common.pageutil.Page;
import com.yckj.architecture1.common.util.DateFormatHelper;
import com.yckj.architecture1.common.util.JsonHelper;
import com.yckj.architecture1.customermgr.service.ICustomerService;
import com.yckj.architecture1.customermgr.vo.CustomerModel;
import com.yckj.architecture1.customermgr.vo.CustomerQueryModel;
import com.yckj.architecture1.customermgr.web.vo.CustomerWebModel;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;
	
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(){
		System.out.println("==========>");
		return "customer/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute("cm") CustomerModel cm){
		cm.setRegisterTime(DateFormatHelper.long2Str(System.currentTimeMillis()));
		service.create(cm);
		return "customer/success";
	}
	
	@RequestMapping(value="/toUpdate/{customerUuid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("customerUuid") int customerUuid){
		CustomerModel cm = service.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute("cm") CustomerModel cm){
		service.update(cm);
		return "customer/success";
	}
	
	@RequestMapping(value="/toDelete/{customerUuid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable(value="customerUuid") int customerUuid){
		CustomerModel cm = service.getByUuid(customerUuid);
		model.addAttribute("cm", cm);
		return "customer/delete";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("uuid") int customerUuid){
		service.delete(customerUuid);
		return "customer/success";
	}
	
	@RequestMapping(value="/toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm") CustomerWebModel wm,Model model){
		CustomerQueryModel cqm = null;
		if(StringUtils.isEmpty(wm.getQueryJsonStr())){
			cqm = new CustomerQueryModel();
		}else{
			cqm = (CustomerQueryModel) JsonHelper.str2Object(wm.getQueryJsonStr(), CustomerQueryModel.class);
		}
		
		cqm.getPage().setNowPage(wm.getNowPage());
		if(wm.getPageShow()>0)
			cqm.getPage().setPageShow(wm.getPageShow());
		Page<CustomerModel> dbPage = service.getByConditionPage(cqm);
		
		model.addAttribute("queryJsonStr", wm.getQueryJsonStr());
		model.addAttribute("page",dbPage);
		
		return "customer/list";
	}
	@RequestMapping(value="/toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "customer/query";
	}
}
