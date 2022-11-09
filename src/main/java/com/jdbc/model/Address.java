package com.jdbc.model;

public class Address {

	private int id;
	private String place;
	private  User user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}

	public Address() {
		
	}
	public Address(int id, String place) {
	
		this.id = id;
		this.place = place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	} 
}
