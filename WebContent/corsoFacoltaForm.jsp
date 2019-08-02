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

<%@ include file="/templates/header.jspf" %>

<h2>Inserimento Facoltà</h2>
<form action="Facolta" method="post">
	<label name="facolta">Facoltà: </label><br>
	<input name="facolta" type="text" /><br>
	<input type="submit">
</form>

<h2>Inserimento Corsi</h2>
<form action="Corso" method="post">
	<label name="corso">Corso: </label><br>
	<input name="corso" type="text" /><br>
	<input type="submit">
</form>

<h2>Aggiungi corsi a Facoltà</h2>
<form action="CorsiFacolta" method="post">
<select name="facolta">
<c:forEach items="${facolta}" var="f">
	<option value="${f.id}">${f.facolta}</option>
</c:forEach>
</select>

<select name="corso">
<c:forEach items="${corsi}" var="c">
	<option value="${c.id}">${c.corso}</option>
</c:forEach>
</select>

<input type="submit">
</form>

<c:forEach items="${facolta}" var="f">
<table>
<tr>
<th>${f.facolta}</th>
</tr>

	<c:forEach items="${f.corsi}" var="c">
	<tr>
		<td>${c.corso}</td>
	</tr>
	</c:forEach>
	</table>
</c:forEach>

</body>
</html>