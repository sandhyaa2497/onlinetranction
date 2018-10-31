package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.Categorydao;
import com.niit.dao.Productdao;
import com.niit.model.Productdetails;
@Controller
public class Productcontroller {
	@Autowired
	Productdao productDao;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	   public ModelAndView product() {
	      return new ModelAndView("Productf", "command", new Productdetails());
	   }
	   @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	      public String addproduct(@ModelAttribute("SpringWeb")Productdetails product,ModelMap model) {
	      model.addAttribute("prodname", product.getProdname());
	     
	      model.addAttribute("prodid", product.getProdid());
	      productDao.addproduct(product);
	      return "Productdisplay";
	   }
	   @RequestMapping(value = "/getproduct", method = RequestMethod.GET)
		  public ModelAndView getprod() {
			  List<com.niit.model.Productdetails> clist=productDao.getAllProductdetails();
			  ModelAndView mv=new ModelAndView("Productdisplay","products",clist);
			   mv.addObject("command",new com.niit.model.Productdetails());
			 return mv;
			  
		  }
}
