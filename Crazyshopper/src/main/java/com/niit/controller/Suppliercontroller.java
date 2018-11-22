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
import com.niit.dao.Productdao;
import com.niit.dao.Supplierdao;
import com.niit.model.Categorydetails;
import com.niit.model.Productdetails;
import com.niit.model.Supplierdetails;


@Controller
public class Suppliercontroller {
	@Autowired
	Supplierdao supplierDao;
	@Autowired
	Productdao productDao;
	@Autowired
	Categorydao categoryDao; 
	
	@RequestMapping(value="/admin/getsupplierform")
	   public ModelAndView supplier(Model model) {
		ModelAndView mv=new ModelAndView("Supplierf", "command", new Supplierdetails());
		List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
		model.addAttribute("suppliers",slist);
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return mv;
	   }
	@RequestMapping(value = "/supplierlist", method = RequestMethod.GET)
	public String getSupplier(Model model){
		List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
		model.addAttribute("suppliers",slist);
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);;
		
		return "Supplierdisplay";
	}
	   @RequestMapping(value = "/admin/addsupplier", method = RequestMethod.POST)
	      public String addsupplier(@ModelAttribute("SpringWeb")Supplierdetails supplier,ModelMap model) {
	      model.addAttribute("supname", supplier.getSupname());
	     
	      model.addAttribute("supid", supplier.getSupid());
	      supplierDao.addsupplier(supplier);
	      List<Productdetails> plist=productDao.getAllProductdetails();
	        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
			
			model.addAttribute("categories",clist);
			model.addAttribute("products",plist);
	      return "Supplierdisplay";
	   }
	   @RequestMapping(value = "/admin/getsupplier", method = RequestMethod.GET)
		  public ModelAndView getsup() {
			  List<com.niit.model.Supplierdetails> slist=supplierDao.getAllSupplierdetails();
			  ModelAndView mv=new ModelAndView("Supplierdisplay","suppliers",slist);
			  List<Productdetails> plist=productDao.getAllProductdetails();
		        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
				
		        mv.addObject("categories",clist);
				mv.addObject("products",plist);
			 return mv;
			  
		  }
	   @RequestMapping(value="/admin/deletesupplier")
	   public String deleteSupplier(@RequestParam int id,Model model){
	   supplierDao.deletesupplier(id);
	   	List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
		model.addAttribute("suppliers",slist);
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	   	return "Supplierdisplay";
	   	
}
	   @RequestMapping(value="/admin/getupdatesupplier")
	   public String getupdatesupplier(@RequestParam int id,Model model){
	   	Supplierdetails supplierd=supplierDao.getsupplier(id);
	   	System.out.println(supplierd.getSupname());
	   	model.addAttribute("supplier",supplierd);
	   	List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
	   	model.addAttribute("suppliers",slist);
	   	List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	   	return "updatesupplierform";
	   }
	   @RequestMapping(value="/admin/updatesupplier",method=RequestMethod.POST)
	   public String updateSupplier(@Valid @ModelAttribute("supplier") Supplierdetails supplier,BindingResult result,Model model,HttpServletRequest request){
	   	if(result.hasErrors()){
	   		List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
	   		model.addAttribute("suppliers",slist);
	   		
	   		return "updatesupplierform";
	   	}
	   	supplierDao.updatesupplier(supplier);
		List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
		model.addAttribute("suppliers",slist);
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	   	return "Supplierdisplay";
	   }
	   	
	   }
	   

	   
