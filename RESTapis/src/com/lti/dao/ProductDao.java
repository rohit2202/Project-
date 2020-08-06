package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.entity.Product;

//classes which contain DB code are commonly said to as data Access objects
public class ProductDao {

	public Product select(int id) {
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
		String sql = "SELECT * from tbl_product WHERE id = ?";
		stmt= con.prepareStatement(sql);
		stmt.setInt(1, id);
		//stmt.setString(2, pass);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Product product = new Product();
			product.setId((rs.getInt("id")));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
			return product;
		}
		return null;
		
		}
		catch(ClassNotFoundException | SQLException se) {
			se.printStackTrace();
			System.out.println("Some issue");
			return null;
		}
		finally {
			try {
				con.close();
			}
			catch(Exception se) {} 
			}
			
		
	}
	public List<Product> selectAll() {
		Connection con = null;
		PreparedStatement stmt =null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		//Ensure the driver jar file ready after locating the same and copy the same in project WEBCONTENT/WEB-INF/lib 
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "system";
		String pass = "12345678";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("connected");
		String sql = "SELECT * from tbl_product ";
		stmt= con.prepareStatement(sql);
	//	stmt.setString(1, user);
	//	stmt.setString(2, pass);
		rs = stmt.executeQuery();
		while(rs.next()) {
			Product product = new Product();
			product.setId((rs.getInt("id")));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
		
			list.add(product);
		}
		return list;
		
		}
		catch(ClassNotFoundException | SQLException se) {
			se.printStackTrace();
			System.out.println("Some issue");
			return null;
		}
		finally {
			try {
				con.close();
			}
			catch(Exception se) {} 
			}
		
		
	}
	public void insert(Product product) {
		Connection con = null;
		PreparedStatement stmt =null;
	//	ResultSet rs = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "system";
		String pass = "12345678";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("connected");
		String sql = "INSERT INTO tbl_product VALUES(?, ?, ? ) ";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, product.getId());
		stmt.setString(2, product.getName());
		stmt.setDouble(3, product.getPrice());
		int count = stmt.executeUpdate();
				
		}
		catch(ClassNotFoundException | SQLException se) {
			se.printStackTrace();
			System.out.println("Some issue");
			
		}
		finally {
			try {
				con.close();		
		
	} catch(Exception e) {}
}}}
