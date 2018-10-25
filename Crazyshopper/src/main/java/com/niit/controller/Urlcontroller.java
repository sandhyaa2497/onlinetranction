package com.niit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Urlcontroller {
	String message = "Welcome to onlineshopping!";
	 

	@RequestMapping("/home")
	public ModelAndView show() {
		System.out.println("in controller");
		 
		ModelAndView mv = new ModelAndView("welcome");
		return mv;
	}
		 }
	