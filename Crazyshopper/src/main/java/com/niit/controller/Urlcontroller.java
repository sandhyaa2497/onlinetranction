package com.niit.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.Categorydao;
import com.niit.dao.CustomerDao;
import com.niit.dao.Productdao;
import com.niit.model.CartItem;
import com.niit.model.Categorydetails;
import com.niit.model.Customer;
import com.niit.model.Productdetails;
import com.niit.model.Userdetails;

@Controller
public class Urlcontroller {
	String message = "Welcome to onlineshopping!";
	@Autowired
	 Categorydao categoryDao;
	@Autowired
	Productdao productDao;
	@Autowired
	CustomerDao customerDao;

	
	@RequestMapping(value={"/home","/"})
	public ModelAndView showMessage() {
		System.out.println("in home");
		List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		List<Productdetails> plist=productDao.getAllProductdetails();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("message","this is the first page");
		mv.addObject("categories",clist);
		mv.addObject("products",plist);
		return mv;
		}
	
	
	@RequestMapping("/admin/adminpage")
	public String admin(Model model){
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return "adminhome";
	}
	
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	@RequestMapping("/loginerror")
	public String loginError(Model model){
		model.addAttribute("loginError","Invalid email/password");
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return "login";
	}
	@RequestMapping(value="/logout")
	public String logout(Model model){
		model.addAttribute("message","Loggedout successfully..");
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return "login";
	}
	@RequestMapping("/aboutus")
	public String aboutus(Model model){
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return "aboutus";
	}
	@RequestMapping("/all/updatelogin")
	public String updatepassword(Model model){
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return "updatelogin";
	}

	@RequestMapping(value = "/all/resetpassword", method = RequestMethod.POST)
	public ModelAndView displayResetPasswordPage(@RequestParam("Email") String Email,@RequestParam("Password") String Password) {
		Userdetails user=customerDao.getUser(Email);
		
		user.setPassword(Password);
		Customer customer=user.getCustomer();
	
		
		user.setCustomer(customer);
		customer.setUser(user);
		customerDao.updateCustomer(customer);
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
		 }
	