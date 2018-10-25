package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.model.Productdetails;
@Controller
public class Productcontroller {
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	   public ModelAndView product() {
	      return new ModelAndView("product", "command", new Productdetails());
	   }
	   @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	      public String addproduct(@ModelAttribute("SpringWeb")Productdetails product,ModelMap model) {
	      model.addAttribute("prodname", product.getProdname());
	     
	      model.addAttribute("prodid", product.getProdid());
	      
	      return "result";
	   }
}
