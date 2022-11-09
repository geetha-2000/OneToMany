package com.jdbc.model;

import java.util.List;

public class User {

	
	private int id;
	private String name;
	private List<Address> address;
	

	public User() {
		
}
	public User(int id, String name) {
		
		this.id = id;
		this.name = name;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public User(int id, String name, List<Address> address) {
		
		this(id,name);
		this.address = address;
	}
	

	
	
	
}
