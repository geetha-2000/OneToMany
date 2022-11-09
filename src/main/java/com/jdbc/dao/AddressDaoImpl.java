package com.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdbc.model.Address;

@Service
public class AddressDaoImpl implements AddressDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Address saveAdrs(Address adrs, int userId) {
		jdbcTemplate.update("insert into address(id,place,user_id) values(?,?,?)",adrs.getId(),adrs.getPlace(),userId);
		return adrs;
	}

	@Override
	public Address updateAdrs(Address adrs) {
		jdbcTemplate.update("update address set place=? where id=?",adrs.getPlace(),adrs.getId());
		return adrs;
	}

	@Override
	public List<Address> getByAdrsId(int id) {
		String query = "select * from address where user_id=?";
		List<Address> addressList = new ArrayList<>();
		 jdbcTemplate.query(query, (rs) -> {

			 addressList.add(new Address(rs.getInt("id"),rs.getString("place")));
//		 return addressList;	 
		}, id);
 	return addressList;
	}

	@Override
	public String deleteById(int id) {
		jdbcTemplate.update("delete from address where user_id=?",id);
		return "address deleted";
	}

	@Override
	public List<Address> allAddress() {
		return jdbcTemplate.query("select * from address", (rs, rowNum) -> {

			return new Address(rs.getInt("id"),rs.getString("place"));
		});
	}
	
	
}
