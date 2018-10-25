package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Userdetails;


@Controller
public class Usercontroller {
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	   public ModelAndView user() {
	      return new ModelAndView("user", "command", new Userdetails());
	   }
	   @RequestMapping(value = "/adduser", method = RequestMethod.POST)
	      public String adduser(@ModelAttribute("SpringWeb")Userdetails user,ModelMap model) {
	      model.addAttribute("username", user.getUsername());
	     
	      model.addAttribute("email", user.getEmail());
	      
	      return "result";
	   }
}
