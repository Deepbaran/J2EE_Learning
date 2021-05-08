package com.deepbarankar.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
	public static void main(String[] args) {
		// connection, stmt and rs will automatically close, once the try-catch block is done with execution. No need to explixitly call the close() methods of each of these objects in finally block.
		// It is because, these objects will implement a method called, autocloseable. This feature is added from Java 7
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2", "password");
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from account");) {
			// Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2", "password"); // url, user, password
			// url for oracle database -> jdbc:oracle:thin:@myhost:1521:orcl 
			// System.out.println(connection);
			// Statement stmt = connection.createStatement();
			
			/* Insert in the database */
			// int result = stmt.executeUpdate("insert into account values(1, 'kar', 'deepbaran', 10000);");
			// System.out.println(result+" rows got inserted");
			
			// int result = stmt.executeUpdate("update account set bal = 20000 where accno = 1;");
			// System.out.println(result+" rows got inserted");
			
			// int result = stmt.executeUpdate("delete from account where accno = 1;");
			// System.out.println(result+" rows got inserted");
			
			/* Reading the database */
			// ResultSet rs = stmt.executeQuery("select * from account");
			while(rs.next()) {
				System.out.println(rs.getInt("accno")+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Not needed anymore
		/*
		finally {
		// Explicitly close the objects
			rs.close();
			stmt.close();
			connection.close();
		}
		*/
	}
}
