package com.ecart.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ecart.dao.CartItemDAO;
import com.ecart.dao.ProductDAO;
import com.ecart.dao.UserDAO;
import com.ecart.model.CartItem;
import com.ecart.model.Product;
import com.ecart.model.User;

@Controller
public class CartController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	CartItemDAO cartDAO;
	@Autowired
	ProductDAO productDAO;
	
		
	
	
	@RequestMapping("/addToCart/{productId}")
	public String addCartItem(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session, Model m)
		{
			CartItem cartItem=new CartItem();
			Product product=productDAO.getProduct(productId);
			
			String username=(String)session.getAttribute("username");
			cartItem.setProductId(productId);
			cartItem.setQuantity(quantity);
			cartItem.getCartItemId();
		    cartItem.setCartId(1);
			cartItem.setUsername(username);
			cartItem.setPaymentStatus("NP");
			cartItem.setSubtotal(quantity*product.getPrice());
		
			cartDAO.addCartItem(cartItem);
			
			m.addAttribute("cartList",cartDAO.getCartItems(username));
			
			return "Cart";
			
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId") int cartItemId, @RequestParam("qty")int quantity,HttpSession session,Model m)
	{
		 CartItem cartItem=cartDAO.getCartItem(cartItemId);
		 Product product=productDAO.getProduct(cartItem.getProductId());
	     
	     cartItem.setQuantity(quantity);
	     cartItem.setSubtotal(quantity*product.getPrice());
	     cartDAO.updateCartItem(cartItem);
	     String username= (String)session.getAttribute("username");
		 List<CartItem> listCartItems= cartDAO.getCartItems(username);
	     m.addAttribute("cartList",listCartItems);
	     m.addAttribute("grandTotal",this.grandTotal(listCartItems));
	     return "Cart";
		
    }
    
	@RequestMapping("/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId, HttpSession session,Model m)
	{
	     CartItem cartItem=cartDAO.getCartItem(cartItemId);
	     
	     
	     cartDAO.deleteCartItem(cartItem);
	     
	     String username=(String)session.getAttribute("username");
	     List<CartItem> listCartItems= cartDAO.getCartItems(username);
	     m.addAttribute("cartList",listCartItems);
	     m.addAttribute("grandTotal",this.grandTotal(listCartItems));
	     
		 return "Cart";
		
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
	
	
}