<%@ page import="java.sql.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%!// It will go in the translated Servlet directly
	Connection con;
	PreparedStatement ps;

	public void jspInit() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2", "password");
			ps = con.prepareStatement("insert into account value(?,?,?,?)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jspDestroy() {
		try {
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>

<%
// It will go in the Service method of the translated Servlet
int accno = Integer.parseInt(request.getParameter("accno"));
String lastName = request.getParameter("lastname");
String firstName = request.getParameter("firstname");
int bal = Integer.parseInt(request.getParameter("bal"));

ps.setInt(1, accno);
ps.setString(2, lastName);
ps.setString(3, firstName);
ps.setInt(4, bal);

ps.executeUpdate();
%>

<!-- After execution, it includes the "openaccount.html". This is how, we can include a HTML page or a JSP page inside another JSP page. -->
<%@ include file="openaccount.html" %>