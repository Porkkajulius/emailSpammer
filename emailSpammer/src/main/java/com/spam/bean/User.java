package com.spam.bean;

/*
 * This is example class which could contain user information
 * Not necessary to use, but created ready for future needs
 */

public class User {
	
	 private String email;

	public User() {
		super();
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
