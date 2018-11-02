package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.dao.Userdao;
import com.niit.model.Userdetails;


@Controller
public class Usercontroller {
	@Autowired
	Userdao userDao;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	   public ModelAndView user() {
	      return new ModelAndView("Userf", "command", new Userdetails());
	   }
	   @RequestMapping(value = "/adduser", method = RequestMethod.POST)
	      public String adduser(@ModelAttribute("SpringWeb")Userdetails user,ModelMap model) {
	      model.addAttribute("username", user.getUsername());
	     
	      model.addAttribute("email", user.getEmail());
	      userDao.adduser(user);
	      return "Userdisplay";
	   }
	   @RequestMapping(value = "/getuser", method = RequestMethod.GET)
		  public ModelAndView getuser() {
			  List<com.niit.model.Userdetails> clist=userDao.getAllUserdetatils();
			  ModelAndView mv=new ModelAndView("Userdisplay","users",clist);
			   mv.addObject("command",new com.niit.model.Userdetails());
			 return mv;
			  
		  }
}
