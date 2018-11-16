package com.niit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.springframework.stereotype.Component;


@Entity 
@Component
public class Categorydetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String categoryname;
	  
	   @OneToMany(mappedBy="category")  
		private List<Productdetails> products;
	   
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	public List<Productdetails> getProducts() {
		return products;
	}
	public void setProducts(List<Productdetails> products) {
		this.products = products;
	}
	

	
	
	
	
	
	



}
