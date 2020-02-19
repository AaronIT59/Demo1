package com.entities;

public class AccountClient {
	
	private int acId;
	private String email;
	private String user;
	private String pass;
	public AccountClient() {
		
	}
	public AccountClient(int acId, String email, String user, String pass) {
		super();
		this.acId = acId;
		this.email = email;
		this.user = user;
		this.pass = pass;
	}
	public int getAcId() {
		return acId;
	}
	public void setAcId(int acId) {
		this.acId = acId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	
}
