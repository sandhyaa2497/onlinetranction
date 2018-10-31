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
import com.niit.model.Categorydetails;
@Controller
public class Categorycontroller {
	@Autowired
	Categorydao categoryDao;
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	   public ModelAndView product() {
	      return new ModelAndView("Categoryf", "command", new Categorydetails());
	   }
	   @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	      public String addcategory(@ModelAttribute("SpringWeb")Categorydetails category, 
	   ModelMap model) {
		   
	      model.addAttribute("categoryname", category.getCategoryname());
	     
	      model.addAttribute("cid", category.getCid());
	      categoryDao.addcategory(category);
	      return "Categorydisplay";
	   }
	  @RequestMapping(value = "/getcategory", method = RequestMethod.GET)
	  public ModelAndView getcatt() {
		  List<com.niit.model.Categorydetails> clist=categoryDao.getAllCategorydetails();
		  ModelAndView mv=new ModelAndView("Categorydisplay","categories",clist);
		   mv.addObject("command",new com.niit.model.Categorydetails());
		 return mv;
		  
	  }
}
