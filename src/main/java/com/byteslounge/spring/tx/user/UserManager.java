package com.byteslounge.spring.tx.user;

import java.util.List;

import com.byteslounge.spring.tx.model.User;

public interface UserManager {

	void insert() throws Exception;
	
	User getUserById(int userId);
	
	User getUser(String username);
	
	List<User> getUsers();
}
