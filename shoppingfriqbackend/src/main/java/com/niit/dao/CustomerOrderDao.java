package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;

public interface CustomerOrderDao {

	 List<CustomerOrder> getCustomerOrder(String email);
}
