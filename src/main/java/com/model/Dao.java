package com.model;


import com.entities.AccountClient;

public interface Dao {

	public boolean checkLogin(String u,String p);
	public boolean addAccount(AccountClient acc);
}
