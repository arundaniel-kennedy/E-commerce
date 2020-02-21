package com.ecart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecart.dao.CartItemDAO;
import com.ecart.dao.ProductDAO;
import com.ecart.dao.UserDAO;
import com.ecart.model.CartItem;

@Controller
public class OrderController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartItemDAO cartItemDAO;
	
	@RequestMapping("/ConfirmOrder")
	public String ConfirmOrder(HttpSession session,Model m)
	{ 
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartItemDAO.getCartItems(username);
		m.addAttribute("cartList",listCartItems);
		m.addAttribute("grandTotal",this.grandTotal(listCartItems));
		
		return "OrderConfirm";
	}
	
	public int grandTotal(List<CartItem> listCartItems)
	{
		int grandTotal=0;
		for(CartItem cartItem: listCartItems)
		{
			grandTotal=grandTotal+cartItem.getQuantity()*(productDAO.getProduct(cartItem.getProductId()).getPrice());
		}	
		return grandTotal;
	}
	
	@RequestMapping("/PaymentConfirm")
	public String PaymentConfirm()
	{ 
		
		
		return "ThankYou";
		
	}
}
