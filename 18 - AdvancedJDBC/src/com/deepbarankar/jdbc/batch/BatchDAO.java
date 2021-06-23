package com.deepbarankar.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2", "password");
				Statement stmt = con.createStatement();) {
			stmt.addBatch("insert into account values(1,'clinton','bill',10000)");
			stmt.addBatch("insert into account values(2,'clinton','hillary',20000)");

			int[] result = stmt.executeBatch();

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
