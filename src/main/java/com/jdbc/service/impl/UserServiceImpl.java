package com.jdbc.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.dao.AddressDao;
import com.jdbc.dao.UserDao;
import com.jdbc.model.Address;
import com.jdbc.model.User;
import com.jdbc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Override
	public User createUser(User user) {
		
		if(user!=null && user.getId()!=0)
		{
			 user = userDao.saveUser(user);
			for (Address addr : user.getAddress()) {
				addressDao.saveAdrs(addr,user.getId());
			}
			
		}
		return user;
	}
	
	public User updateUser(User user) {
		User ur = userDao.updateUser(user);
		if(ur!=null && ur.getId()!=0)
		{
			for (Address addr : ur.getAddress()) {
				addressDao.updateAdrs(addr);
			}
			
		}
		return user;
	}
	
  
   
  public void deleteUser(int uid) {
	   
	  		addressDao.deleteById(uid);
	  		userDao.deleteById(uid);
		
    }

@Override
public List<User> getUser() {
	return userDao.allUsers();
}

//@Override
//public User getUserById(int id) {
//	User user= 
//	return user;
//}
	
    

}
