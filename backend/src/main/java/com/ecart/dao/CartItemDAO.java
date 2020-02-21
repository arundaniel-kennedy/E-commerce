package com.ecart.dao;

import java.util.List;

import com.ecart.model.CartItem;


public interface CartItemDAO {
	public boolean addCartItem(CartItem cartItem);
    public CartItem getCartItem(int cartItemId);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public List<CartItem> getCartItems(String username);
}
