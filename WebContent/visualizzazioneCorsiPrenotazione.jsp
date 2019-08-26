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

<h1>Corsi disponibili</h1>

<c:forEach items="corsi" var="c">
<a href="/Campus/PrenotazioneCorso/${c.id}">${c.corso}</a>
</c:forEach>
</body>
</html>