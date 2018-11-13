package com.niit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity 
@Component
public class Categorydetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String categoryname;
	   @Transient
	   private MultipartFile image;
	   @OneToMany(mappedBy="category")  
		private List<Productdetails> product;

	
	
	
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
	public List<Productdetails> getProduct() {
		return product;
	}
	public void setProduct(List<Productdetails> product) {
		this.product = product;
	}

	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	



}
