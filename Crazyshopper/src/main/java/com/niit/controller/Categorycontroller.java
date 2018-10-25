package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Categorydetails;
@Controller
public class Categorycontroller {
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	   public ModelAndView product() {
	      return new ModelAndView("category", "command", new Categorydetails());
	   }
	   @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	      public String addcategory(@ModelAttribute("SpringWeb")Categorydetails category, 
	   ModelMap model) {
	      model.addAttribute("categoryname", category.getCategoryname());
	     
	      model.addAttribute("cid", category.getCid());
	      
	      return "result";
	   }
}
