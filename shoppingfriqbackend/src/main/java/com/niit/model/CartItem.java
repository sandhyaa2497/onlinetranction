package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int cartItemId;
	@ManyToOne
private Productdetails product;
	@ManyToOne
private Userdetails user;
public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Productdetails getProduct() {
		return product;
	}
	public void setProduct(Productdetails product) {
		this.product = product;
	}
	public Userdetails getUser() {
		return user;
	}
	public void setUser(Userdetails user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
private int quantity;
private double totalPrice;
}
