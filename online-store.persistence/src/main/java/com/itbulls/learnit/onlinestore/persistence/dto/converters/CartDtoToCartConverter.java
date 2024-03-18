package com.itbulls.learnit.onlinestore.persistence.dto.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbulls.learnit.onlinestore.persistence.dto.CartDto;
import com.itbulls.learnit.onlinestore.persistence.entities.Cart;
import com.itbulls.learnit.onlinestore.persistence.entities.impl.DefaultCart;

@Service
public class CartDtoToCartConverter {

	@Autowired
	private ProductDtoToProductConverter productConverter;

	@Autowired
	private UserDtoToUserConverter userConverter;

	public Cart convertCartDtoToCart(CartDto cartDto) {
		Cart cart = new DefaultCart();

		cart.setCustomer(userConverter.convertUserDtoToUser(cartDto.getUserDto()));
		cart.setProducts(productConverter.convertProductDtosToProducts(cartDto.getProductDtos()));

		return cart;
	}

	public CartDto convertCartToCartDto(Cart cart) {
		CartDto cartDto = new CartDto();

		cartDto.setProductDtos(productConverter.convertProductsToProductDtos(cart.getProducts()));
		cartDto.setUserDto(userConverter.convertUserToUserDto(cart.getCustomer()));

		return cartDto;
	}

	public List<Cart> convertCartDtosToCart(List<CartDto> cartDtos) {
		List<Cart> cartProducts = new ArrayList<>();
		if (cartDtos != null) {
			for (CartDto  cartDto : cartDtos) {
				cartProducts.add(convertCartDtoToCart(cartDto));
			}
		}
		return cartProducts;
	}

}
