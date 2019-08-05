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
<form action="Utente" method="post">
<label for="nome">Nome: </label><br>
<input id="nome" name="nome" type="text"><br>

<label for="cognome">Cognome: </label><br>
<input id="cognome" name="cognome" type="text"><br>

<label for="facolta">Facoltà: </label><br>
<select id="facolta" name="facolta">
<c:forEach items="${facolta}" var="fac">
	<option value="${fac.id}">${fac.facolta}</option>
</c:forEach>
</select><br>

<label for="ruolo" >Ruolo: </label><br>
<select id="ruolo" name="ruolo">
<c:forEach items="${ruoli}" var="role">
	<option value="${role.id}">${role.ruolo}</option>
</c:forEach>
</select><br>

<label for="username">Username: </label><br>
<input id="username" name="username" type="text"><br>

<label for="password">Password: </label><br>
<input id="password" name="password" type="text"><br>

<input type="submit">
</form>
</body>
</html>