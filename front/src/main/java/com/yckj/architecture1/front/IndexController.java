package com.yckj.architecture1.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yckj.architecture1.cartmgr.service.CartService;
import com.yckj.architecture1.cartmgr.vo.CartModel;
import com.yckj.architecture1.cartmgr.vo.CartQueryModel;
import com.yckj.architecture1.common.pageutil.Page;
import com.yckj.architecture1.common.util.DateFormatHelper;
import com.yckj.architecture1.goodsmgr.service.GoodsService;
import com.yckj.architecture1.goodsmgr.vo.GoodsModel;
import com.yckj.architecture1.goodsmgr.vo.GoodsQueryModel;
import com.yckj.architecture1.ordermgr.service.OrderDetailService;
import com.yckj.architecture1.ordermgr.service.OrderService;
import com.yckj.architecture1.ordermgr.vo.OrderDetailModel;
import com.yckj.architecture1.ordermgr.vo.OrderModel;
import com.yckj.architecture1.ordermgr.vo.OrderQueryModel;
import com.yckj.architecture1.storemgr.service.StoreService;
import com.yckj.architecture1.storemgr.vo.StoreModel;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private GoodsService gs;
	@Autowired
	private CartService cs;
	@Autowired
	private OrderService os;
	@Autowired
	private OrderDetailService ods;
	@Autowired
	private StoreService ss;
	
	@RequestMapping(value="/toIndex",method=RequestMethod.GET)
	public String toIndex(Model model){
		GoodsQueryModel gqm = new GoodsQueryModel();
		gqm.getPage().setPageShow(100);
		
		Page<GoodsModel> page = gs.getByConditionPage(gqm);
		model.addAttribute("page", page);
		return "index";
	}
	@RequestMapping(value="/toGoodsDesc/{goodsUuid}",method=RequestMethod.GET)
	public String toGoodsDesc(Model model,@PathVariable("goodsUuid")int goodsUuid){
		GoodsModel gm = gs.getByUuid(goodsUuid);
		model.addAttribute("m", gm);
		return "goods/desc";
	}
	@RequestMapping(value="/toCart",method=RequestMethod.GET)
	public String toCart(@CookieValue("MyLogin")String myLogin,Model model){
		Integer customerUuid = Integer.parseInt(myLogin.split("#")[0]);
		
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(100);
		cqm.setCustomerUuid(customerUuid);
		Page<CartModel> page = cs.getByConditionPage(cqm);
		model.addAttribute("page", page);
		return "cart/myCart";
	}
	@RequestMapping(value="/addToCart/{goodsUuid}",method=RequestMethod.GET)
	public String addToCart(@PathVariable("goodsUuid")int goodsUuid,
			@CookieValue("MyLogin")String myLogin,Model model){
		Integer customerUuid = Integer.parseInt(myLogin.split("#")[0]);
		CartModel cm = new CartModel();
		cm.setBuyNum(1);
		cm.setCustomerUuid(customerUuid);
		cm.setGoodsUuid(goodsUuid);
		cs.create(cm);
		
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(100);
		cqm.setCustomerUuid(customerUuid);
		Page<CartModel> page = cs.getByConditionPage(cqm);
		model.addAttribute("page", page);
		return "redirect:/toCart";
	}
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String order(@CookieValue("MyLogin")String myLogin){
		Integer customerUuid = Integer.parseInt(myLogin.split("#")[0]);
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(100);
		cqm.setCustomerUuid(customerUuid);
		Page<CartModel> page = cs.getByConditionPage(cqm);
		
		float totalMoney = 0.0f;
		for(CartModel cm:page.getResult()){
			totalMoney += 10;
		}
		OrderModel order = new OrderModel();
		order.setCustomerUuid(customerUuid);
		order.setOrderTime(DateFormatHelper.long2Str(System.currentTimeMillis()));
		order.setSaveMoney(0.0f);
		order.setTotalMoney(totalMoney);
		order.setState(1);
		os.create(order);
		
		OrderQueryModel oqm = new OrderQueryModel();
		oqm.setOrderTime(order.getOrderTime());
		Page<OrderModel> orderPage = os.getByConditionPage(oqm);
		order = orderPage.getResult().get(0);
		
		for(CartModel cm:page.getResult()){
			OrderDetailModel odm = new OrderDetailModel();
			odm.setGoodsUuid(cm.getGoodsUuid());
			odm.setOrderNum(cm.getBuyNum());
			odm.setPrice(10.0f);
			odm.setMoney(odm.getPrice()*odm.getOrderNum());
			odm.setSaveMoney(0f);
			odm.setOrderUuid(Integer.parseInt(order.getUuid()));
			ods.create(odm);
			
			StoreModel storeModel = ss.getByGoodsUuid(cm.getGoodsUuid());
			storeModel.setStoreNum(storeModel.getStoreNum()-odm.getOrderNum());
			ss.update(storeModel);
			
			cs.delete(Integer.parseInt(cm.getUuid()));
		}
		
		
		return "success";
	}
}
