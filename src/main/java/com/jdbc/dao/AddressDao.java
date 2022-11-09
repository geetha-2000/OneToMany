package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.Address;


public interface AddressDao {

	
	 Address saveAdrs(Address adrs,int userId);

	 Address updateAdrs(Address adrs);

	 List<Address> getByAdrsId(int id);

	    String deleteById(int id);

	    List<Address> allAddress();
}
