package net.codejava.ws;

import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/allEmp")
public class AllEmployeeLoginDetails {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Map<String, String>> AllEmpDetails() {
		Map<String, Map<String, String>> employees = new TreeMap<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "Deepbaran2",
					"password");
			Statement stmt1 = connection.createStatement();
			ResultSet rs1 = stmt1.executeQuery("select emp_id from employee where emp_id <> 'e000'");
			while (rs1.next()) {
				String empid = rs1.getString(1);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select months, count(*) from dates d inner join login l on d.date_id = l.date_id where "
								+ empid + " = 1 group by d.months;");
				Map<String, String> empdetails = new LinkedHashMap<>();
				while (rs.next()) {
					empdetails.put(rs.getString(1), String.valueOf(rs.getInt(2)));
				}
				employees.put(empid, empdetails);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
