package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CartItemDao;
import com.niit.dao.Categorydao;
import com.niit.dao.CustomerDao;
import com.niit.dao.CustomerOrderDao;
import com.niit.dao.Productdao;
import com.niit.model.CartItem;
import com.niit.model.Categorydetails;
import com.niit.model.CustomerOrder;
import com.niit.model.Productdetails;

@Controller
public class CustomerOrderController {
	@Autowired
	private CustomerOrderDao customerorderDao;
	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	Categorydao categoryDao;
@Autowired
private Productdao productDao;
@Autowired
	private CustomerDao customerDao;
	
	
	@RequestMapping(value="/cart/getcustomerorder")
	public String getCart(@AuthenticationPrincipal Principal principal,Model model,HttpSession session){ 
	
	String email=principal.getName();
	List<CustomerOrder> customerorder=customerorderDao.getCustomerOrder(email);
		
		session.setAttribute("orderSize",customerorder.size());
	model.addAttribute("customerorders",customerorder);
	  List<Productdetails> plist=productDao.getAllProductdetails();
      List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	return "order";
	}
	
}
