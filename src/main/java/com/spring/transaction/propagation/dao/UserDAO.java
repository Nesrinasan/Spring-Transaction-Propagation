package com.spring.transaction.propagation.dao;

import com.spring.transaction.propagation.model.User;

import java.util.List;


public interface UserDAO {

    void insertUser_REQUIRED(User user);

	void insertUser_REQUIRES_NEW(User user);

    void insertUser_MANDATORY(User user);

    void insertUser_NEVER(User user);

	User getUser(String username);

    User getUserById(int userId);

	List<User> getUsers();
}
