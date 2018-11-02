package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity 
@Component
public class Productdetails {
	@Id
	private int prodid;
	   private String prodname;
	   private int prize;
	   private String prodetails;
	   private int quantity;
	   @Transient
	   private MultipartFile image;
	   
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
