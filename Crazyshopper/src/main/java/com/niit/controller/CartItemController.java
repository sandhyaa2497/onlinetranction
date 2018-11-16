package com.niit.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartItemDao;
import com.niit.dao.CustomerDao;
import com.niit.dao.Productdao;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Productdetails;
import com.niit.model.ShippingAddress;
import com.niit.model.Userdetails;

@Controller
public class CartItemController {
	@Autowired
	private CartItemDao cartItemDao;
@Autowired
private Productdao productDao;
@Autowired
	private CustomerDao customerDao;

	@RequestMapping(value="/addtocart")
	public String addToCart(
			@PathVariable int id,
			@RequestParam int requestedQuantity,
			@AuthenticationPrincipal Principal principal
			){
		String email=  principal.getName();
		
		Productdetails product=Productdao.getproduct(id);
		Userdetails user=customerDao.getuser(email);
		List<CartItem> cartItems=cartItemDao.getCart(email);
	for(CartItem cartItem:cartItems){
			if(cartItem.getProduct().getProdid()==id){
				cartItem.setQuantity(requestedQuantity);
				cartItem.setTotalPrice(requestedQuantity * product.getPrize());
		    cartItemDao.addToCart(cartItem);
			    return "redirect:/getcart";
			}
		}
		
		

		CartItem cartItem=new CartItem();
		cartItem.setProduct(product);
		cartItem.setUser(user);
		cartItem.setQuantity(requestedQuantity);
	cartItem.setTotalPrice(requestedQuantity * product.getPrize());
		
		cartItemDao.addToCart(cartItem);
		
	return "redirect:/getcart";
}
	@RequestMapping(value="/getcart")
	public String getCart(@AuthenticationPrincipal Principal principal,Model model,HttpSession session){ 
	
	String email=principal.getName();
	List<CartItem> cartItems=cartItemDao.getCart(email);
		
		session.setAttribute("cartSize", cartItems.size());
	model.addAttribute("cartItems",cartItems);
	return "cart";
	}
	@RequestMapping(value="/removecartitem")
	public String removeCartItem(@PathVariable int cartItemId){
		cartItemDao.removeCartItem(cartItemId);
		return "redirect:/getcart";
	}

	@RequestMapping(value="/clearcart")
	public String clearCart(@AuthenticationPrincipal Principal principal){
		List<CartItem> cartItems=cartItemDao.getCart(principal.getName());
	for(CartItem cartItem:cartItems)
			cartItemDao.removeCartItem(cartItem.getCartItemId());
	return "redirect:/getcart";
	}
	
	@RequestMapping(value="/shippingaddressform")
	public String getShippingAddressForm(@AuthenticationPrincipal Principal principal,Model model){
		String email=principal.getName();
		
	     Userdetails user=customerDao.getuser(email);
	     Customer customer= user.getCustomer();
	     ShippingAddress shippingAddress=customer.getShippingaddress();
	     model.addAttribute("shippingaddress",shippingAddress);
		return "shippingaddress";
	}
	@RequestMapping(value="/createorder")
	public String createCustomerOrder(@ModelAttribute ShippingAddress shippingaddress,
			Model model,
			@AuthenticationPrincipal Principal principal,HttpSession session){
		String email=principal.getName();
		

		Userdetails user=customerDao.getuser(email);
		List<CartItem> cartItems=cartItemDao.getCart(email);
		Customer customer=user.getCustomer();
	customer.setShippingaddress(shippingaddress);
		
		user.setCustomer(customer);
		customer.setUser(user);
				
	double grandTotal=0.0;
	for(CartItem cartItem:cartItems){
			grandTotal=grandTotal+cartItem.getTotalPrice();
		}
		
		
	CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setPurchaseDate(new Date());
		customerOrder.setGrandTotal(grandTotal);
		customerOrder.setUser(user);
		
		if(cartItems.size()>0)
		      cartItemDao.createCustomerOrder(customerOrder);
		
		
		
		for(CartItem cartItem:cartItems){
			Productdetails product=cartItem.getProduct();		
			product.setQuantity(product.getQuantity() - cartItem.getQuantity());
			productDao.updateProduct(product);
			cartItemDao.removeCartItem(cartItem.getCartItemId());
		}
		session.setAttribute("cartSize", 0);
	
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("customerorder",customerOrder);
		return "orderdetails";	}

}
