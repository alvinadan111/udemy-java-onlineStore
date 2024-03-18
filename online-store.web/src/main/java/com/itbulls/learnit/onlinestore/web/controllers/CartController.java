package com.itbulls.learnit.onlinestore.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbulls.learnit.onlinestore.core.facades.CartFacade;
import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.persistence.entities.Cart;

@Controller
public class CartController {

	@Autowired
	private CartFacade cartFacade;

	@Autowired
	private UserFacade userFacade;

//	@Autowired
//	private MessageSource messageSource;


	@GetMapping("/cart")
	public String doGet(HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute(SignInController.LOGGED_IN_USER_ATTR);
		List<Cart> cartProducts = cartFacade.getProductsFromCartByUserId(
				userFacade.getUserByEmail(loggedInUser.getUsername()).getId());
		model.addAttribute("cartProducts", cartProducts);
//		session.setAttribute("orderStatus", messageSource.getMessage("order.created.msg", null, LocaleContextHolder.getLocale()));
		return "cart";
	}

}
