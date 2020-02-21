package com.ecart.test;
import static org.junit.Assert.*;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.CartItemDAO;
import com.ecart.dao.CategoryDAO;
import com.ecart.model.CartItem;
import com.ecart.model.Category;

public class CartItemUnitTest {
	static CartItemDAO cartDAO;
	
    @Autowired
    CategoryDAO categoryDAO;
    
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		cartDAO=(CartItemDAO)context.getBean("CartDAO");
	}

	@Test
	public void addCartTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setProductId(1);
		cartItem.setCartId(1);
		cartItem.setQuantity(1);
		cartItem.setUsername("Deepika");
		cartItem.setPaymentStatus("NP");
		cartItem.setSubtotal(1);
		assertTrue("Problem in Cart Insertion",cartDAO.addCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(2));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}
    
	
	@Test
	public void updateCartTest()
	{
		CartItem cartItem=cartDAO.getCartItem(1);
		cartItem.setQuantity(2);
		assertTrue("Problem in Updation",cartDAO.updateCartItem(cartItem));
	}

	
}
