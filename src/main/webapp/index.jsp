<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring REST</title>
</head>
<body>
<h2>Spring REST</h2>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a><br>
<a href="${pageContext.request.contextPath}/api/students">Get Students</a><br>
<a href="${pageContext.request.contextPath}/api/students/1">Get Student 1</a><br>
<a href="${pageContext.request.contextPath}/api/students/999">Get Student 999 (exception)</a><br>
</body>
</html>