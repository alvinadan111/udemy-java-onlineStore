package com.itbulls.learnit.onlinestore.persistence.entities;

public interface Cart {

	void setProduct(Product product);

	Product getProduct();

	void setCustomer(User customer);

	User getCustomer();




}

