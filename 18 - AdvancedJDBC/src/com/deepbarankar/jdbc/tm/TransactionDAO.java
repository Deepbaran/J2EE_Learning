package com.deepbarankar.jdbc.tm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2", "password");
			stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.executeUpdate("update account set bal=bal-500 where accno=2");
			
			stmt.executeUpdate("update account set bal=bal+500 where accno=1");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				con.close();
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
