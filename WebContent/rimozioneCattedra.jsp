<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libera cattedra</title>
</head>
<body>
<%@ include file="/templates/header.jspf" %>
<h1>Rimozione cattedra</h1><br>
<hr>
<h2>Professore</h2><br>
<h3>Nome: ${cattedra.professore.nome } </h3>
<h3>Cognome: ${cattedra.professore.cognome } </h3>
<hr>
<h2>Cattedra</h2>
<h3>Facolta: ${cattedra.facolta.facolta }</h3>
<h3>Corso: ${cattedra.corso.corso }</h3>
<hr>
<h2>Rimuovi</h2>
<form action="/Campus/RimozioneCattedra/${cattedra.corso.id}-${cattedra.professore.id }-${cattedra.facolta.id }" method="post">
<input type="hidden" name="corsoId" value=${cattedra.corso.id }>
<input type="hidden" name="facoltaId" value=${cattedra.facolta.id }>
<input type="hidden" name="profId" value=${cattedra.professore.id }>
<input type="submit" value="Invia">
</form>
</body>
</html>