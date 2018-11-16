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


import com.niit.dao.Supplierdao;

import com.niit.model.Supplierdetails;


@Controller
public class Suppliercontroller {
	@Autowired
	Supplierdao supplierDao;
	@RequestMapping(value="/getsupplierform")
	   public ModelAndView supplier(Model model) {
		ModelAndView mv=new ModelAndView("Supplierf", "command", new Supplierdetails());
		List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
		model.addAttribute("suppliers",slist);
		return mv;
	   }
	@RequestMapping(value = "/supplierlist", method = RequestMethod.GET)
	public String getSupplier(Model model){
		List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
		model.addAttribute("suppliers",slist);
		
		return "Supplierdisplay";
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
			  List<com.niit.model.Supplierdetails> slist=supplierDao.getAllSupplierdetails();
			  ModelAndView mv=new ModelAndView("Supplierdisplay","suppliers",slist);
			 
			 return mv;
			  
		  }
	   @RequestMapping(value="/deletesupplier")
	   public String deleteSupplier(@RequestParam int id,Model model){
	   supplierDao.deletesupplier(id);
	   	List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
		model.addAttribute("suppliers",slist);
	   	return "Supplierdisplay";
	   	
}
	   @RequestMapping(value="/getupdatesupplier")
	   public String getupdatesupplier(@RequestParam int id,Model model){
	   	Supplierdetails supplierd=supplierDao.getsupplier(id);
	   	System.out.println(supplierd.getSupname());
	   	model.addAttribute("supplier",supplierd);
	   	List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
	   	model.addAttribute("suppliers",slist);
	   	return "updatesupplierform";
	   }
	   @RequestMapping(value="/updatesupplier")
	   public String updateSupplier(@Valid @ModelAttribute("supplier") Supplierdetails supplier,BindingResult result,Model model,HttpServletRequest request){
	   	if(result.hasErrors()){
	   		List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
	   		model.addAttribute("suppliers",slist);
	   		return "updatesupplierform";
	   	}
	   	supplierDao.updatesupplier(supplier);
		List<Supplierdetails> slist=supplierDao.getAllSupplierdetails();
		model.addAttribute("suppliers",slist);
	   	return "Supplierdisplay";
	   }
	   	
	   }
	   

	   
