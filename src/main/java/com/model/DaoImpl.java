package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entities.AccountClient;


public class DaoImpl implements Dao{
	
	

	public Connection ConnectDB() {
		String DB_URL = "jdbc:mysql://localhost:3306/JobsIt";
	    String USER_NAME = "root";
	    String PASSWORD = "root";
	    Connection conn = null;
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
		return conn;
	}
	
	
	
	
public boolean checkLogin(String u, String p) {
		
	    
	    try {
	    	Connection conn = ConnectDB();
			PreparedStatement pst = conn.prepareStatement("select * from AccountClient where user=? and pass=?");
			pst.setString(1, u);
			pst.setString(2, p);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		return false;
	}



@Override
public boolean addAccount(AccountClient acc) {
	try {
		Connection conn = ConnectDB();
		PreparedStatement pst = conn.prepareStatement("insert into AccountClient (email,user,pass) values (?,?,?)");
		pst.setString(1, acc.getEmail());
		pst.setString(2, acc.getUser());
		pst.setString(3, acc.getPass());
		pst.execute();
	    
		return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
}






	

}
