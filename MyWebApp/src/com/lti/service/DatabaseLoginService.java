package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseLoginService {
	
	public boolean authenticate(String username, String password) {
	
		Connection con = null;
		PreparedStatement stmt =null;
		ResultSet rs = null;
		//Ensure the driver jar file ready after locating the same and copy the same in project WEBCONTENT/WEB-INF/lib 
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "system";
		String pass = "12345678";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("connected");
		String sql = "SELECT COUNT(user_id) from tbl_users WHERE user_name = ? AND user_pass = ?";
		stmt= con.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		rs = stmt.executeQuery();
		if(rs.next()) {
			int count = rs.getInt(1);
			if(count ==1)
				return true;
			
		}
		return false;
		
		}
		catch(ClassNotFoundException | SQLException se) {
			se.printStackTrace();
			System.out.println("Some issue");
			return false;
		}
		finally {
			try {
				con.close();
			}
			catch(Exception se) {}
		}
	}

	
}
