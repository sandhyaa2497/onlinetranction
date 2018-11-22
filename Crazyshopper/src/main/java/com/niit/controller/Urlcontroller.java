package com.niit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.Categorydao;
import com.niit.dao.Productdao;
import com.niit.model.Categorydetails;
import com.niit.model.Productdetails;

@Controller
public class Urlcontroller {
	String message = "Welcome to onlineshopping!";
	@Autowired
	 Categorydao categoryDao;
	@Autowired
	Productdao productDao;
	

	
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
	public String admin(){
		return "adminhome";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/loginerror")
	public String loginError(Model model){
		model.addAttribute("loginError","Invalid email/password");
		return "login";
	}
	@RequestMapping(value="/logout")
	public String logout(Model model){
		model.addAttribute("message","Loggedout successfully..");
		return "login";
	}
	@RequestMapping("/aboutus")
	public String aboutus(){
		return "aboutus";
	}

		 }
	