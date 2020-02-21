package com.ecart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecart.model.CartItem;


@Repository("cartItemDAO")

public class CartItemDAOImpl implements CartItemDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	
	public boolean addCartItem(CartItem cartItem) {
		try
		{
		sessionFactory.getCurrentSession().save(cartItem);
	    
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
	}

	
	public CartItem getCartItem(int cartItemId) {
		try{
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
		return cartItem;
		}
		
		catch(Exception e){
			return null;
		}

		
	}
	@Transactional
	
	public boolean deleteCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}
    @Transactional
	
	public boolean updateCartItem(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}

		
	}

	@Transactional
	
	public List<CartItem> getCartItems(String username) {
		try
		{
			Session session=sessionFactory.openSession();
	//		CartItem cartItem=(CartItem)session.createQuery("form CartItem where username=:username and status=:'NP'");
			Query query=session.createQuery("from CartItem");
			List<CartItem> listCartItem=(List<CartItem>)query.list();
			return listCartItem;
		}
		catch(Exception e){
			return null;
		}
	

	}
	
}
