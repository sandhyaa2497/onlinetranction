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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.Categorydao;
import com.niit.dao.Productdao;
import com.niit.model.Categorydetails;
import com.niit.model.Productdetails;
@Controller
public class Productcontroller {
	@Autowired
	Productdao productDao;
	@Autowired
	Categorydao categoryDao;
	@RequestMapping(value="/admin/getproductform")
	   public ModelAndView product(Model model) {
		ModelAndView mv=new ModelAndView("Productf", "product", new Productdetails());
		List<Categorydetails> categories=productDao.getAllCategorydetails();
		model.addAttribute("categories",categories);
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return mv;
	   }
	@RequestMapping("/viewproduct-{prodid}")
	public String getproduct(Model model,@PathVariable int prodid) {
		Productdetails p=productDao.getproduct(prodid);
		model.addAttribute("productAttr",p);
		List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	
		return "viewproduct";
	}
	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public String getProductForm(Model model){
		List<Productdetails> plist=productDao.getAllProductdetails();
		model.addAttribute("prodlist",plist);
		List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return "Productdisplay";
		
	}
	
	@RequestMapping("/filterproduct/{catid}")
	public String getproductbycategory(Model model,@PathVariable int catid) {
		List<Productdetails> plist=productDao.getproductbycat(catid);
		if(plist.size()!=0)
		{
			System.out.println(plist);
		model.addAttribute("products",plist);
		}
		else {
			model.addAttribute("prodcat","Products under this category are currently not available!!!. We will upload soon.....");
		}
		
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
		return "home";
	}
	   @RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
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
		
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	      return "Productdisplay";
	   }
	   @RequestMapping(value = "/admin/getproduct",method = RequestMethod.GET)
		  public ModelAndView getprod() {
			  List<com.niit.model.Productdetails> clist=productDao.getAllProductdetails();
			  ModelAndView mv=new ModelAndView("Productdisplay","products",clist);
			   mv.addObject("command",new com.niit.model.Productdetails());
			   List<Productdetails> plist=productDao.getAllProductdetails();
		        List<Categorydetails> catlist=categoryDao.getAllCategorydetails();
				
		        mv.addObject("categories",catlist);
				mv.addObject("products",plist);
			 return mv;
			  
		  }
	   @RequestMapping(value="/admin/deleteproduct")
	   public String deleteProduct(@RequestParam int id,Model model){
	   	productDao.deleteproduct(id);
	   	List<Productdetails> plist=productDao.getAllProductdetails();
		model.addAttribute("prodlist",plist);
		
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	   	return "Productdisplay";
	   	
}
	   @RequestMapping(value="/admin/getupdateproduct")
	   public String getupdateproduct(@RequestParam int id,Model model){
	   	Productdetails product=productDao.getproduct(id);
	   	System.out.println(product.getProdname());
	   	model.addAttribute("product",product);
	   	List<Categorydetails> categories=productDao.getAllCategorydetails();
	   	model.addAttribute("categories",categories);
	   	List<Productdetails> plist=productDao.getAllProductdetails();
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	   	return "updateproductform";
	   }
	   @RequestMapping(value="/admin/updateproduct")
	   public String updateProduct(@Valid @ModelAttribute("product") Productdetails product,BindingResult result,Model model,HttpServletRequest request){
	   	if(result.hasErrors()){
	   		List<Categorydetails> categories=productDao.getAllCategorydetails();
	   		model.addAttribute("categories",categories);
	   		List<Productdetails> plist=productDao.getAllProductdetails();
	        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
			
			model.addAttribute("categories",clist);
			model.addAttribute("products",plist);
	   		return "updateproductform";
	   	}
	   	productDao.updateProduct(product);
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
		
        List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		
		model.addAttribute("categories",clist);
		model.addAttribute("products",plist);
	   	return "Productdisplay";
	   }
}
