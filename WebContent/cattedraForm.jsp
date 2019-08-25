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

<form action="AssegnazioneCattedra" method="post">

<label for="prof">Professore:</label>
<select id="prof" name="prof">
<c:forEach items="${professori}" var="prof">
	<option value="${prof.id}">${prof.nome} ${prof.cognome}</option>
</c:forEach>
</select><br>

<label for="facolta">Facoltà:</label>
<select id="facolta" name="facolta">
<c:forEach items="${facolta}" var="fac">
	<option value="${fac.id}">${fac.facolta}</option>
</c:forEach>
</select><br>

<label for="corso">Corso:</label>
<select id="corso" name="corso">
<c:forEach items="${corsi}" var="corso">
	<option value="${corso.id}">${corso.corso}</option>
</c:forEach>
</select><br>

<input type="submit"/>

</form>

</body>
</html>