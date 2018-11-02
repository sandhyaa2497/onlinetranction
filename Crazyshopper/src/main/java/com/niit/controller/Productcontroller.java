package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


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
	      public String addproduct(@ModelAttribute("SpringWeb")Productdetails product,ModelMap model,HttpServletRequest request) {
	      model.addAttribute("prodname", product.getProdname());
	     
	      model.addAttribute("prodid", product.getProdid());
	      productDao.addproduct(product);
	      
	      MultipartFile img=product.getImage();
	  	System.out.println(request.getServletContext().getRealPath("/"));
	  	
	  	
	  	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getProdid()+".jpg");
	  	
	  	try {
	  		if(img!=null && !img.isEmpty()){
	  		File file=new File(path.toString());
	  		img.transferTo(file);
	  		}
	  	} catch (IllegalStateException e) {
	  		e.printStackTrace();
	  	} catch (IOException e) {
	  		e.printStackTrace();
	  	}
	      
	      
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
