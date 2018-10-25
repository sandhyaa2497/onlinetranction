package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Supplierdetails;


@Controller
public class Suppliercontroller {
	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	   public ModelAndView supplier() {
	      return new ModelAndView("supplier", "command", new Supplierdetails());
	   }
	   @RequestMapping(value = "/addsupplier", method = RequestMethod.POST)
	      public String addsupplier(@ModelAttribute("SpringWeb")Supplierdetails supplier,ModelMap model) {
	      model.addAttribute("supname", supplier.getSupname());
	     
	      model.addAttribute("supid", supplier.getSupid());
	      
	      return "result";
	   }

}
