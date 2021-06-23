package com.deepbarankar.jdbc.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataDAO {
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2", "password");
				Statement stmt = con.createStatement();) {
			ResultSet resultSet = stmt.executeQuery("select * from account");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();

			for (int i = 1; i <= columnCount; i++) { // Start from 1 and not 0
				System.out.println(resultSetMetaData.getColumnName(i) + " " + resultSetMetaData.getColumnTypeName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
