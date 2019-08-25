<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento data appello</title>
</head>
<body>
<%@ include file="/templates/header.jspf" %>
<h2>Aggiungi professore</h2>
<label>Nome professore: ${account.utente.nome}</label><br>
<label>Cognome professore: ${ account.utente.cognome}</label><br>
<hr>

<h2>Aggiungi facolta e corso </h2>
<form action="AppelloInserimentoServlet" method="post">

	<select name="cattedra">
	<c:forEach items="${cattedre}" var="c">
		<option value="${c.facolta.id}-${c.corso.id}">${c.facolta} - ${c.corso}</option>
	</c:forEach>
	</select>


	<h2>Inserimento data appello </h2>
	<label>Data appello</label><br>
	<input type="date" name="data" placeholder="Data">
	<input type="submit" name="insData" value="Invia">
</form>

</body>
</html>