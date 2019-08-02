<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${facolta.facolta}</h1>
<table>
<tr>
	<th>Corso</th>
	<th>Rimuovi</th>
</tr>
<c:forEach items="${facolta.corsi}" var="cor">
<tr>
	<td>${cor.corso }</th>
	<td><a href="#">Rimuovi</a></th>
</tr>
</c:forEach>

<h2>Aggiungi corsi a Facoltà</h2>
<form action="/Campus/CorsiFacolta" method="post">

<input type="hidden" name="facolta" value="${facolta.id}">

<select name="corso">
<c:forEach items="${corsi}" var="c">
	<option value="${c.id}">${c.corso}</option>
</c:forEach>
</select>

<input type="submit">
</form>
</table>
</body>
</html>