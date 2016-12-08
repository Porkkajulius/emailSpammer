package com.spam.bean;

public class User {
	
	 private String email;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}
	 
	 

}
