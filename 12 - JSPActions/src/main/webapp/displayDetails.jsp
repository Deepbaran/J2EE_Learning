<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<!-- We are creating an instance of the Product.java class in the com.deepnarankar.jsp package and the id is the reference variable. -->
	<!-- This is where we are going to be using the usebean tag to use the Product.java bean -->
	<jsp:useBean id="product" class="com.deepbarankar.jsp.Product">
		<!-- Set property in the Product.java bean using the setProperty tag. -->
		<!-- Give the value of the name property, same as the id of the useBean tag as this will show that the setProperty is for that particular useBean through the reference -->
		<!-- As all the fields and Getters and Setters in the bean are following the Java Convention, so all the respective values will be automatically set using reflection -->
		<!-- That's why we are giving * as the value of the property attribute -->
		<!-- If this was not the case, then we would have to set it manually -->
		<jsp:setProperty name="product" property="*" />
	</jsp:useBean>

	Product Details
	<br /> Id:
	<jsp:getProperty property="id" name="product" />
	<br /> Name:
	<jsp:getProperty property="name" name="product" />
	<br /> Description:
	<jsp:getProperty property="description" name="product" />
	<br /> Price:
	<jsp:getProperty property="price" name="product" />
	<!-- In getProperty tag, the name attribute defines, which useBean(bean) it needs to refer to and the property attribute defines, which field's value it needs to get from the referred bean. -->
	<!-- getProperty does two things: It gets the property from the bean and it writes it in the browser. -->
</body>
</html>