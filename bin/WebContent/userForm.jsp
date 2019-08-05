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
<form action="Studente" method="post">
<label name="nome">Nome: </label><br>
<input name="nome" type="text"><br>

<label name="cognome">Cognome: </label><br>
<input name="cognome" type="text"><br>

<label name="facolta">Facoltà: </label><br>
<select name="facolta">
<c:forEach items="${facolta}" var="fac">
	<option value="${fac.id}">${fac.facolta}</option>
</c:forEach>
</select><br>

<label name="username">Username: </label><br>
<input name="username" type="text"><br>

<label name="password">Password: </label><br>
<input name="password" type="text"><br>

<input type="submit">
</form>
</body>
</html>