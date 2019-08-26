<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/templates/header.jspf" %>
<table>
	<tr>
		<th>Data</th>
		<th>Prenota</th>
	</tr>
<c:forEach items="${date}" var="d">
	<tr>
		<td>${d.dataAppello}</td>
		<td><a href="*">Prenota</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>