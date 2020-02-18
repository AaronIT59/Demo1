package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoImpl implements Dao{

	public boolean checkLogin(String u, String p) {
		String DB_URL = "jdbc:mysql://localhost:3306/dbname";
	    String USER_NAME = "root";
	    String PASSWORD = "root";
	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			PreparedStatement pst = conn.prepareStatement("select * from User where user=? and pass=?");
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

}
