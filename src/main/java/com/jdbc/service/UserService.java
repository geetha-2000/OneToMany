package com.jdbc.service;

import java.util.List;

import com.jdbc.model.User;

public interface UserService {
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(int id);
	
	List<User> getUser();
	
//	User getUserById(int id);

}
