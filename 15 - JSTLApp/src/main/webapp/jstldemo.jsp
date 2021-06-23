<!-- This taglib used for JSTL tags -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cout Demo</title>
</head>
<body>
	<c:out value="${10+9}" />

	<!-- 
	c:set -> Assign a value to a variable and assigning that variable to a particular scope.
	c:remove -> Delete a variable having a value from a particular scope.
	 -->
	<!-- scope can be session, request, application etc. Here we are setting 80 to variable testscore which is in the session scope -->
	<c:set var="testScore" value="${80}" scope="session" />
	<!-- This tag will search all the scopes for the testScore variable -->
	<c:out value="${testScore}" />
	<!-- This tag will search all the scopes for the testScore variable and then remove it -->
	<c:remove var="testScore" />
	After Removal the value is:
	<c:out value="${testScore}" />

	<c:set var="testScore" value="${70}" scope="session" />
	<!-- c:if -> Add conditional logic to JSP/view -->
	<c:if test="${testScore>=80}">
		<!-- Render it in the view only if testScore is >= 80 -->
		<p>
			Your score is awesome
			<c:out value="${testScore}" />
		</p>
	</c:if>

	<!-- 
	c:choose -> switch statement
	c:when -> case
	c:otherwise -> default
	 -->
	<c:choose>
		<c:when test="${testScore>=80}">
	A Grade
	</c:when>
		<c:when test="${testScore>=60 && testScore<80}">
	B Grade
	</c:when>
		<c:otherwise>
	C Grade
	</c:otherwise>
	</c:choose>

	<!-- c:forEach -> As a for loop -->
	<c:forEach var="i" begin="1" end="3">
		<c:out value="${i}" />
	</c:forEach>
	<%
	List<String> studentNames = new ArrayList<>();
	studentNames.add("Deepbaran");
	studentNames.add("Kar");
	request.setAttribute("studentNames", studentNames); // Assigning studentNames in the request scope
	%>
	<!-- c:forEach -> As a forEach loop to iterate through a collection or array -->
	<c:forEach var="studentName" items="${studentNames}">
		<c:out value="${studentName}" />
	</c:forEach>

	<!-- 
	JSTL Formatting Library:
	1. parseNumber
	2. formatNumber
	3. parseDate
	4. message
	5. formatDate
	 -->
	 <c:set var="accountBalance" value="123.456"/>
	 <!-- Parsing a string to a number -->
	 <!-- The parsed value will be stored in the value of the attribute var -->
	 <fmt:parseNumber var="i" type="number" value="${accountBalance}"/>
	 <p>Amount is: <c:out value="${i}"/></p>
	 
	 <c:set var="accountBalance" value="7777.4567"/>
	 <!-- This is similar to the format library we have internally in Java -->
	 <!-- formatting a number to our desired format -->
	 <p>Formatted Number 1: <fmt:formatNumber value="${accountBalance}" type="currency"/></p>
	 <!-- maxFractionDigits determines how many digits the number will be rounded off to. -->
	 <p>Formatted Number 2: <fmt:formatNumber value="${accountBalance}" type="number" maxFractionDigits="2"/></p>
	 <!-- maxIntegerDigits rounds off the left side of the decimal point -->
	 <p>Formatted Number 3: <fmt:formatNumber value="${accountBalance}" type="number" maxIntegerDigits="2"/></p>
	 <p>Formatted Number 4: <fmt:formatNumber value="${accountBalance}" type="percent"/></p>
	 <p>Formatted Number 5: <fmt:formatNumber value="${accountBalance}" type="number" pattern="####.##$"/></p>
	 
	 <c:set var="myDate" value="18-06-2021"/>
	 <fmt:parseDate var="parsedDate" value="${myDate}" pattern="dd-MM-yyyy"/>
	 <p>Parsed Date is: <c:out value="${parsedDate}"/></p>
</body>
</html>