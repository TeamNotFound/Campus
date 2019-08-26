<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/templates/header.jspf" %>
<table>
<tr>
	<th>Professore</th>
	<th>Rimuovi</th>
</tr>

<c:forEach items="${professori}" var="p">
<tr>
    <td>${p.nome} ${p.cognome}</td>
    <td>
    	<c:if test="${!p.rettore}">
    	
    		<a href="/Campus/Professore/Rimuovi/${p.id}">Rimuovi</a>
    	
    	</c:if>
    </td>
</tr>
</c:forEach>
</table>
</body>
</html>