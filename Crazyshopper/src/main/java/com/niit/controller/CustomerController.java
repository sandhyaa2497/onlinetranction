package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.Categorydao;
import com.niit.dao.CustomerDao;
import com.niit.dao.Productdao;
import com.niit.model.Categorydetails;
import com.niit.model.Customer;
import com.niit.model.Productdetails;



@Controller
public class CustomerController {
	@Autowired
	  private CustomerDao customerDao;
	@Autowired
	Productdao productDao;
	@Autowired
	Categorydao categoryDao;
		
		
		@RequestMapping(value="/all/getregistrationform")
		public String getRegistrationForm(Model model){
		Customer customer	=new Customer();
		model.addAttribute("customer",customer);	
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return "registrationform";	
		}
		@RequestMapping(value="/all/registercustomer")
		public String registerCustomer(@ModelAttribute Customer customer,Model model){
			String email=customer.getUser().getEmail();
			if(!customerDao.isEmailUnique(email)){
				model.addAttribute("errorMessage","Email already exists.. please choose different email id");
				return "registrationform";
			}
			customerDao.registerCustomer(customer);
			List<Productdetails> plist=productDao.getAllProductdetails();
	        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
			
			model.addAttribute("categories",clist);
			model.addAttribute("products",plist);
			
			return "login";
		}
	}
