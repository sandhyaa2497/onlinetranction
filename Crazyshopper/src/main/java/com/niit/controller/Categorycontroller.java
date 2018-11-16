package com.niit.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.Categorydao;
import com.niit.model.Categorydetails;




@Controller
public class Categorycontroller {
	@Autowired
	Categorydao categoryDao;
	
	@RequestMapping(value="/getcategoryform")
	   public ModelAndView category(Model model) {
		ModelAndView mv=new ModelAndView("Categoryf", "command", new Categorydetails());
		List<Categorydetails> categorylist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",categorylist);
		return mv;
	   }
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategory(Model model){
		List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",clist);
		
		return "Categorydisplay";
	}
	   @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	      public String addcategory(@ModelAttribute("SpringWeb")Categorydetails category, ModelMap model) 
		   {
	      model.addAttribute("categoryname", category.getCategoryname());
	     
	      model.addAttribute("cid", category.getCid());
	     categoryDao.addcategory(category);
	      
	     
	  	List<Categorydetails> categorylist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",categorylist);
	      return "Categorydisplay";
	   }
	  @RequestMapping(value = "/getcategory", method = RequestMethod.GET)
	  public ModelAndView getcatt() {
		  List<Categorydetails> categorylist=categoryDao.getAllCategorydetails();
		  ModelAndView mn=new ModelAndView("Categorydisplay","command",new Categorydetails());
		  mn.addObject("categories",categorylist);
		 return mn;
		  
	  }
	  @RequestMapping(value="/deletecategory")
	   public String deleteCategory(@RequestParam int id,Model model){
	   categoryDao.deletecategory(id);
	   	List<Categorydetails> categorylist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",categorylist);
	   	return "Categorydisplay";
	   	
}
	  @RequestMapping(value="/getupdatecategory")
	   public String getupdatecategory(@RequestParam int id,Model model){
	   	Categorydetails categoryd=categoryDao.getcategory(id);
	   	model.addAttribute("category",categoryd);
	   	System.out.println(categoryd.getCategoryname());
	   	List<Categorydetails> categorylist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",categorylist);
	 
	  
	   	return "updatecategoryform";
	   }
	  @RequestMapping(value="/updatecategory",method=RequestMethod.POST)
	   public String updateCategory(@Valid @ModelAttribute("category") Categorydetails category,BindingResult result,Model model,HttpServletRequest request){
	   	if(result.hasErrors()){
	   		List<Categorydetails> categorylist=categoryDao.getAllCategorydetails();
	   		model.addAttribute("categories",categorylist);
	   		return "Categorydisplay";
	   	}
	   	categoryDao.updateCategory(category);
	   	
	   	List<Categorydetails> categorylist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",categorylist);
	   	return "Categorydisplay";
	   }
}

