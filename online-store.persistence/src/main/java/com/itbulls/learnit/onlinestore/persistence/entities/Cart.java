package com.itbulls.learnit.onlinestore.persistence.entities;

import java.util.List;

public interface Cart {

	void setProducts(List<Product> products);

	List<Product> getProducts();

	void setCustomer(User customer);

	User getCustomer();


}

