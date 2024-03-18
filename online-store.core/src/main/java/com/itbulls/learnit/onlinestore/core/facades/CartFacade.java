package com.itbulls.learnit.onlinestore.core.facades;

import java.util.List;

import com.itbulls.learnit.onlinestore.persistence.entities.Cart;
import com.itbulls.learnit.onlinestore.persistence.entities.Product;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

public interface CartFacade {

	void addProductToCart(User userId, Product productGuid);

	List<Cart> getProductsFromCartByUserId(Integer userId);

}
