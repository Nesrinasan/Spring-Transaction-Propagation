package com.byteslounge.spring.tx.dao;

import java.util.List;

import com.byteslounge.spring.tx.model.User;

public interface UserDAO {

    void insertUser_REQUIRED(User user);

	void insertUser_REQUIRES_NEW(User user);

    void insertUser_MANDATORY(User user);

    void insertUser_NEVER(User user);

	User getUser(String username);

    User getUserById(int userId);

	List<User> getUsers();
}
