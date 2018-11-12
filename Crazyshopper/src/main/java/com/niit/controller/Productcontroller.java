package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.niit.dao.Productdao;
import com.niit.model.Categorydetails;
import com.niit.model.Productdetails;
@Controller
public class Productcontroller {
	@Autowired
	Productdao productDao;
	
	@RequestMapping(value="/getproductform")
	   public ModelAndView product(Model model) {
		ModelAndView mv=new ModelAndView("Productf", "product", new Productdetails());
		List<Categorydetails> categories=productDao.getAllCategorydetails();
		model.addAttribute("categories",categories);
		return mv;
	   }
	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public String getProductForm(Model model){
		List<Productdetails> plist=productDao.getAllProductdetails();
		model.addAttribute("prodlist",plist);
		
		return "productdisplay";
	}
	   @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	      public String addproduct(@Valid @ModelAttribute("product")Productdetails product,BindingResult result,ModelMap model,HttpServletRequest request) {
		   if(result.hasErrors()){
				return "Productf";
			}
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
	  	List<Productdetails> plist=productDao.getAllProductdetails();
		model.addAttribute("prodlist",plist);
	      
	      return "Productdisplay";
	   }
	   @RequestMapping(value = "/getproduct", method = RequestMethod.GET)
		  public ModelAndView getprod() {
			  List<com.niit.model.Productdetails> clist=productDao.getAllProductdetails();
			  ModelAndView mv=new ModelAndView("Productdisplay","products",clist);
			   mv.addObject("command",new com.niit.model.Productdetails());
			 return mv;
			  
		  }
	   @RequestMapping(value="/deleteproduct")
	   public String deleteProduct(@RequestParam int id){
	   	productDao.deleteproduct(id);
	   	return "Productdisplay";
	   	
}
	   @RequestMapping(value="/getupdateproductform")
	   public String getUpdateProductForm(@RequestParam int prodid,Model model){
	   	Productdetails product=productDao.getproduct(prodid);
	   	model.addAttribute("product",product);
	   	List<Categorydetails> categories=productDao.getAllCategorydetails();
	   	model.addAttribute("categories",categories);
	   	return "updateproductform";
	   }
}
