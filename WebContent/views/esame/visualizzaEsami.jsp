<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/templates/header.jspf" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<meta charset="ISO-8859-1">
<title>Visualizza esami</title>
</head>
<body>
<h1>Carriera</h1><br><br>

<h2>Studente:</h2><br>
<h3>${account.utente.nome}</h3>
<h3>${account.utente.cognome}</h3>
<hr>
<tr>
	<th>Esame</th>
	<th>Voto</th>
</tr><br>
<c:forEach items="${esami}" var="e">
	<tr>
		<td>${e.corso.corso}</td>
		<td>${e.votoEsame }</td>
	</tr>
</c:forEach>
</body>
</html>