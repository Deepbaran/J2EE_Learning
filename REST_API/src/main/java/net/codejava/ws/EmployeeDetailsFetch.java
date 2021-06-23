package net.codejava.ws;

import javax.ws.rs.Path;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/empdetails")
public class EmployeeDetailsFetch {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Map<String, String>> EmployeeDetails() {
		Map<String, Map<String, String>> employees = new TreeMap<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "Deepbaran2", "password");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while(rs.next()) {
				Map<String, String> empdetails = new TreeMap<>();
				empdetails.put("password", rs.getString(2));
				empdetails.put("employee_name", rs.getString(3));
				empdetails.put("contactno", rs.getString(4));
				empdetails.put("email", rs.getString(5));
				empdetails.put("salary", rs.getString(6));
				
				employees.put(rs.getString(1), empdetails);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
