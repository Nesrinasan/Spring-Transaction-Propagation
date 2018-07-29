package com.spring.transaction.propagation.user;

import com.spring.transaction.propagation.model.User;

import java.util.List;


public interface UserManager {

	void insert() throws Exception;
	
	User getUserById(int userId);
	
	User getUser(String username);
	
	List<User> getUsers();
}
