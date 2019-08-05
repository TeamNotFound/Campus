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
Corsi disponibili per ${studente.nome} in facoltà ${studente.facolta.facolta}:<br>
<form action="Prenotazione" method="post">
<select name="corso">
<c:forEach items="${corsi}" var="corso">
	<option value="${corso.id}">${corso.corso}</option>
</c:forEach>
<input type="submit" value="Prenota">
</select>
</form>
</body>
</html>