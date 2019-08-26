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
<form action="Studente" method="post">
<label for="nome">Nome: </label><br>
<input id="nome" name="nome" type="text"><br>

<label for="cognome">Cognome: </label><br>
<input id="cognome" name="cognome" type="text"><br>

<label for="nascita-data">Data Nascita</label><br>
<input type="date" id="nascita-data" name="nascita-data"/><br>

<label for="nascita-luogo">Luogo Nascita</label><br>
<input type="text" id="nascita-luogo" name="nascita-luogo"/><br>

<label for="fiscale">Codice Fiscale</label><br>
<input type="text" id="fiscale" name="fiscale"/><br>

<label for="sesso">Sesso:</label><br>

<input type="radio" id="uomo" name="sesso" value="uomo"/>
<label for="uomo">Uomo</label><br>

<input type="radio" id="sesso" name="sesso" value="donna"/>
<label for="donna">Donna</label><br>

<label for="facolta">Facoltà: </label><br>
<select id="facolta" name="facolta">
<c:forEach items="${facolta}" var="fac">
	<option value="${fac.id}">${fac.facolta}</option>
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