package com.niit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Urlcontroller {
	String message = "Welcome to Crazyshopper !";
	 
	@RequestMapping("/home")
	public ModelAndView show()
	{

		System.out.println("in the controller");
		 
		ModelAndView mv = new ModelAndView("welcome");
		return mv;
	}
		 }
	