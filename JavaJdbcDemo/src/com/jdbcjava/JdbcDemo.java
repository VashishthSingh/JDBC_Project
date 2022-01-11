package com.jdbcjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDemo {
	public static void main(String[] args) {
		// Muni Singh.
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "password");
			
//			stmt=con.createStatement();
//			String q="insert into student values(7072,'Ramesh',21)";
//			int res=stmt.executeUpdate(q);
//			System.out.println(res);
			
			PreparedStatement pstmt=con.prepareStatement("select * from student where id=?");
			pstmt.setInt(1, 7071);
			//pstmt.setString(2, "Muni");
			//pstmt.setInt(3, 25);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("name")+" "+rs.getInt("age"));
			}
			
			con.close();
			pstmt.close();
			//stmt.close();
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
