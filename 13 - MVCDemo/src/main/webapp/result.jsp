<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<%
	// request.getAttribute gives an Object. So, we need to typecast it.
	int result = (Integer) request.getAttribute("result");
	// out.print("<b>The Average is: " + result + "</b>");
	%>

	<b>The Average is: <%=result%></b>
</body>
</html>