<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
<c:forEach items="${facolta}" var="f">
	<li>${f.facolta}</li>
</c:forEach>
</ul>
<form action="Facolta" method="post">
	<label name="facolta">Facoltà: </label><br>
	<input name="facolta" type="text" /><br>
	<input type="submit">
</form>
</body>
</html>