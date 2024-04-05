package com.itbulls.learnit.onlinestore.persistence.entities.impl;

import com.itbulls.learnit.onlinestore.persistence.entities.Cart;
import com.itbulls.learnit.onlinestore.persistence.entities.Product;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

public class DefaultCart implements Cart {

	private Product product;
	private User customer;

	@Override
	public void setProduct(Product product) {
		this.product = product;

	}
	@Override
	public Product getProduct() {
		return this.product;
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
