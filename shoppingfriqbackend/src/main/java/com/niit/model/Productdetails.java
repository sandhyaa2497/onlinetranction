package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity 
@Component
public class Productdetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prodid;
	
	   @NotEmpty(message="Productname is mandatory") private String prodname;
	   @NotEmpty(message="productname is required") private String prodetails;
	   @Min(value=0,message="Minimum quantity must be 0")
	   private int quantity;
	   private int prize;
	   @Transient
	   private MultipartFile image;
	  
	   @ManyToOne
	   private Categorydetails category;
	   
	   
	
	public Categorydetails getCategory() {
		return category;
	}
	public void setCategory(Categorydetails category) {
		this.category = category;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	
	
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public String getProdetails() {
		return prodetails;
	}
	public void setProdetails(String prodetails) {
		this.prodetails = prodetails;
	}

}
