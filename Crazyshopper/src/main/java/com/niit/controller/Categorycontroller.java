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

import com.niit.dao.Categorydao;
import com.niit.model.Categorydetails;



@Controller
public class Categorycontroller {
	@Autowired
	Categorydao categoryDao;
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategory(Model model){
		List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",clist);
		
		return "Categorydisplay";
	}
	   @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	      public String addcategory(@ModelAttribute("SpringWeb")Categorydetails category,BindingResult result, ModelMap model,HttpServletRequest request) {
		   if(result.hasErrors()){
				return "Categoryf";
			}
	      model.addAttribute("categoryname", category.getCategoryname());
	     
	      model.addAttribute("cid", category.getCid());
	     categoryDao.addcategory(category);
	      
	      MultipartFile img=category.getImage();
	  	System.out.println(request.getServletContext().getRealPath("/"));
	  	
	  	
	  	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+category.getCid()+".jpg");
	  	
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
	  	List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",clist);
	      
	      return "Categorydisplay";
	   }
	  @RequestMapping(value = "/getcategory", method = RequestMethod.GET)
	  public ModelAndView getcatt() {
		  List<com.niit.model.Categorydetails> clist=categoryDao.getAllCategorydetails();
		  ModelAndView mv=new ModelAndView("Categorydisplay","categories",clist);
		   mv.addObject("command",new com.niit.model.Categorydetails());
		 return mv;
		  
	  }
	  @RequestMapping(value="/deletecategory")
	   public String deleteCategory(@RequestParam int id,Model model){
	   categoryDao.deletecategory(id);
	   	List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",clist);
	   	return "Categorydisplay";
	   	
}
	  @RequestMapping(value="/getupdatecategory")
	   public String getupdatecategory(@RequestParam int id,Model model){
	   	Categorydetails category=categoryDao.getcategory(id);
	   	System.out.println(category.getCategoryname());
	   	model.addAttribute("category",category);
	   	List<Categorydetails> categories=categoryDao.getAllCategorydetails();
	   	model.addAttribute("categories",categories);
	   	return "updatecategoryform";
	   }
	  @RequestMapping(value="/updatecategory")
	   public String updateCategory(@Valid @ModelAttribute("category") Categorydetails category,BindingResult result,Model model,HttpServletRequest request){
	   	if(result.hasErrors()){
	   		List<Categorydetails> categories=categoryDao.getAllCategorydetails();
	   		model.addAttribute("categories",categories);
	   		return "updatecategoryform";
	   	}
	   	categoryDao.updateCategory(category);
	   	MultipartFile img=category.getImage();
	   	System.out.println(request.getServletContext().getRealPath("/"));
	   	
	   
	   	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+category.getCid()+".jpg");
	   	

	   	
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
	   	List<Categorydetails> clist=categoryDao.getAllCategorydetails();
		model.addAttribute("categories",clist);
	   	return "Categorydisplay";
	   }
}

