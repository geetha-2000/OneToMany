package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.User;

public interface UserDao {
	
	    User saveUser(User user);

	    User updateUser(User user);

	    User getUserById(int id);

	    String deleteById(int id);

	    List<User> allUsers();
}
