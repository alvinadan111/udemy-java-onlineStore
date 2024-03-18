package com.itbulls.learnit.onlinestore.persistence.entities.impl;

import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.onlinestore.persistence.entities.Cart;
import com.itbulls.learnit.onlinestore.persistence.entities.Product;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

public class DefaultCart implements Cart {

	private List<Product> products;
	private User customer;

	@Override
	public void setProducts(List<Product> products) {
		this.products = new ArrayList<>(products);
	}

	@Override
	public List<Product> getProducts() {
		return this.products;
	}

	@Override
	public void setCustomer(User customer) {
		this.customer = customer;

	}

	@Override
	public User getCustomer() {
		return this.customer;
	}


}
