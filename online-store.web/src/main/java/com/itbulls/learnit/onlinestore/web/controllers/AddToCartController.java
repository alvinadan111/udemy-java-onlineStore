package com.itbulls.learnit.onlinestore.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itbulls.learnit.onlinestore.core.facades.CartFacade;
import com.itbulls.learnit.onlinestore.core.facades.ProductFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.User;

@Controller
public class AddToCartController {

	@Autowired
	private CartFacade cartFacade;

	@Autowired
	private ProductFacade productFacade;

	@Autowired
	private MessageSource messageSource;


	@GetMapping("/addToCart")
	public String doGet(@RequestParam("guid") String productGuid, @RequestParam("categoryId") String categoryId, @RequestParam("page") Integer activePage, HttpSession session) {
		cartFacade.addProductToCart(
				(User) session.getAttribute(SignInController.LOGGED_IN_USER_ATTR),
				productFacade.getProductByGuid(productGuid));

		session.setAttribute("addToCartStatus", messageSource.getMessage("addToCart.successful.msg", null, LocaleContextHolder.getLocale()));
		return "redirect:/category?id=" +categoryId+ "&page=" +activePage;
	}

}
