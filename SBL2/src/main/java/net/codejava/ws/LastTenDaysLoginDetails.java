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

@Path("/lastTen")
public class LastTenDaysLoginDetails {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Map<String, String>> LastTenDetails() {
		Map<String, Map<String, String>> employees = new TreeMap<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "Deepbaran2",
					"password");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select d.dates, d.days, (e001 + e002 + e003 + e004 + e005 + e006 + e007 + e008 + e009 + e010) as total_logins from dates d inner join login l on d.date_id = l.date_id group by l.date_id order by l.date_id desc limit 10;");
			while (rs.next()) {
				Map<String, String> empdetails = new TreeMap<>();
				empdetails.put("day", rs.getString(2));
				empdetails.put("logins", rs.getString(3));

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
