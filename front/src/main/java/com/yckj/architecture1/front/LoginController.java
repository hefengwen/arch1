package com.yckj.architecture1.front;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yckj.architecture1.customermgr.service.CustomerService;
import com.yckj.architecture1.customermgr.vo.CustomerModel;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private CustomerService cs;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("customerId")String customerId,
			@RequestParam("pwd")String pwd,HttpServletResponse response){
		if(StringUtils.isBlank(customerId)){
			return "login";
		}
		
		CustomerModel cm = cs.getByCustomerId(customerId);
		if(cm==null)
			return "login";
		
		Cookie c = new Cookie("MyLogin",cm.getUuid()+","+System.currentTimeMillis());
		response.addCookie(c);
		return "redirect:/toIndex";
	}
}
