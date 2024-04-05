package com.itbulls.learnit.onlinestore.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbulls.learnit.onlinestore.core.facades.CartFacade;
import com.itbulls.learnit.onlinestore.core.facades.ProductFacade;
import com.itbulls.learnit.onlinestore.core.facades.PurchaseFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.Cart;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

@Controller
public class CheckoutAllController {

	@Autowired
	private PurchaseFacade purchaseFacade;

	@Autowired
	private ProductFacade productFacade;

	@Autowired
	private CartFacade cartFacade;

	@Autowired
	private MessageSource messageSource;


	@GetMapping("/checkout-all")
	public String doGet(HttpSession session) {
		User loggedInUser = (User) session.getAttribute(SignInController.LOGGED_IN_USER_ATTR);
		List<Cart> cartProducts = cartFacade.getProductsFromCartByUserId(loggedInUser.getId());

		for (Cart cartProduct : cartProducts) {
		        Integer productId = cartProduct.getProduct().getId();
		        purchaseFacade.createPurchase(loggedInUser, productFacade.getProductById(productId));
		}
		cartFacade.deleteAllCartProductsByUserId(loggedInUser.getId());
		session.setAttribute("orderStatus", messageSource.getMessage("order.created.msg", null, LocaleContextHolder.getLocale()));
		return "redirect:/";
	}



}
