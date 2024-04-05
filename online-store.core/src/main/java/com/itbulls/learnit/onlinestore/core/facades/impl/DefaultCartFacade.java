package com.itbulls.learnit.onlinestore.core.facades.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.core.facades.CartFacade;
import com.itbulls.learnit.onlinestore.persistence.dao.CartDao;
import com.itbulls.learnit.onlinestore.persistence.dto.converters.CartDtoToCartConverter;
import com.itbulls.learnit.onlinestore.persistence.entities.Cart;
import com.itbulls.learnit.onlinestore.persistence.entities.Product;
import com.itbulls.learnit.onlinestore.persistence.entities.User;
import com.itbulls.learnit.onlinestore.persistence.entities.impl.DefaultCart;
@Service
public class DefaultCartFacade implements CartFacade {

	@Autowired
	private CartDao cartDao;

	@Autowired
	private CartDtoToCartConverter cartConverter;

	@Override
	public void addProductToCart(User userId, Product product) {
		Cart cart = new DefaultCart();
		cart.setProduct(product);
		cart.setCustomer(userId);

		cartDao.saveCart(cartConverter.convertCartToCartDto(cart));

	}

	@Override
	public List<Cart> getProductsFromCartByUserId(Integer userId) {
		return cartConverter.convertCartDtosToCart(cartDao.getProductsFromCartByUserId(userId));
	}

	@Override
	public void deleteAllCartProductsByUserId(Integer userId) {
		cartDao.deleteCartProductsByUserId(userId);

	}



}
