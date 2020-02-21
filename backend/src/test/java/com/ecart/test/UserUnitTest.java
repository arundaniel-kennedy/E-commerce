package com.ecart.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecart.dao.UserDAO;
import com.ecart.model.User;


public class UserUnitTest {
	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecart");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}

	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setUserId(1);
		user.setMobileNo("9988664422");
		user.setPassword("deepika");
		user.setUsername("deepika");
		user.setRole("Admin");
		user.setEmail("admin@google.com");
		assertTrue("Problem in User Insertion",userDAO.addUser(user));
	}
    
	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser(1);
	    user.setUsername("The Admin");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
	
	@Ignore
	@Test
	public void listUserTest()
	{
		List<User> listUser=userDAO.getUser();
		assertNotNull("No User",listUser);
		
		for(User user:listUser)
		{
			System.out.print(user.getUsername()+":::");
			System.out.print(user.getEmail()+":::");
			
		}
	}

}
