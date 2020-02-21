package com.ecart.dao;
import java.util.List;

import com.ecart.model.User;

public interface UserDAO {
	
	
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUser(int user);
	public List<User> getUser();
	public boolean isValidUser(String username, String password);
	public boolean save(User user);


	public User get(String username);
//	User getCustomerByUsername (String username);


}
