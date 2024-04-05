package com.itbulls.learnit.onlinestore.persistence.dao;

import java.util.List;

import com.itbulls.learnit.onlinestore.persistence.dto.CartDto;


public interface CartDao {

	void saveCart(CartDto cart);

	List<CartDto> getProductsFromCartByUserId(int userId);

	void deleteCartProductsByUserId(int userId);


}
