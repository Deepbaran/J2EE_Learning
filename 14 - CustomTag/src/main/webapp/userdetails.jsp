<!-- For using any other tags (e.g: custom tags or JSTL tags) that are not included in the standard JSP tags, we need to use this taglib. We will reference this taglib using the prefix and we will find where the tags are defined using the uri  -->
<%@taglib prefix="deepbarankar" uri="http://deepbarankar.com"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display User Info</title>
</head>
<body>
	<deepbarankar:displayuser />
	<!-- prefix:tagname -->
	<!-- 
wContainer will go to the taglib at the top, because we are using the same prefix (deepbarankar). Then container will look at the uri and it will search, which tld has that uri.
Container will then go to that tld and search for a tag called, displayuser. And them container will execute the corresponding class.
 -->
</body>
</html>