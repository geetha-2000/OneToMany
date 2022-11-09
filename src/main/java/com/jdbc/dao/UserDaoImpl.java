package com.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdbc.model.Address;
import com.jdbc.model.User;


@Service
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AddressDao adrsDao;
	
	@Override
	public User saveUser(User user) {
		try {
		jdbcTemplate.update("insert into user(id,name) values(?,?)",user.getId(),user.getName());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		jdbcTemplate.update("update user set name=? where id=?",user.getName(),user.getId());
		return user;
	}

	@Override
	public User getUserById(int id) {
		return jdbcTemplate.queryForObject("select * from user where id=?", (rs, rowNum) -> {

			return new User(rs.getInt("id"),rs.getString("name"));
		}, id);
	}

	@Override
	public String deleteById(int id) {
		jdbcTemplate.update("delete from user where id=?",id);
		return "user deleted";
	}

	@Override
	public List<User> allUsers() {
		
		List<User> usersList=new ArrayList<>();
		
		 jdbcTemplate.query("select * from user", (rs) -> {
			List<Address>  adrsList= adrsDao.getByAdrsId(rs.getInt("id"));
			usersList.add(new User(rs.getInt("id"),rs.getString("name"),adrsList));
		});
			
	return usersList;
			
	

}
}
