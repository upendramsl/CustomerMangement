package com.techpalle.model;

public class Customer 
{
	private String name;
	private String email;
	private long mobile;
	private String password;
	private String state;
	public Customer(String name,  String email,long mobile, String password,String state) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.setState(state);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile( long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	

}
