package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.dao.Supplierdao;
import com.niit.model.Supplierdetails;


@Controller
public class Suppliercontroller {
	@Autowired
	Supplierdao supplierDao;
	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	   public ModelAndView supplier() {
	      return new ModelAndView("Supplierf", "command", new Supplierdetails());
	   }
	   @RequestMapping(value = "/addsupplier", method = RequestMethod.POST)
	      public String addsupplier(@ModelAttribute("SpringWeb")Supplierdetails supplier,ModelMap model) {
	      model.addAttribute("supname", supplier.getSupname());
	     
	      model.addAttribute("supid", supplier.getSupid());
	      supplierDao.addsupplier(supplier);
	      return "Supplierdisplay";
	   }
	   @RequestMapping(value = "/getsupplier", method = RequestMethod.GET)
		  public ModelAndView getsup() {
			  List<com.niit.model.Supplierdetails> clist=supplierDao.getAllSupplierdetails();
			  ModelAndView mv=new ModelAndView("Supplierdisplay","suppliers",clist);
			   mv.addObject("command",new com.niit.model.Supplierdetails());
			 return mv;
			  
		  }
}
