<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prenotazione Esame</title>
</head>
<body>
<%@ include file="/templates/header.jspf" %>

<h1>Studente</h1>
<h2>Nome: ${account.utente.nome }</h2>
<h2>Cognome: ${account.utente.cognome }</h2>
<hr>
<h1>Appello</h1><br>
<h2>Facolta: ${dataPrenotata.facolta.facolta }</h2>
<h2>Corso: ${dataPrenotata.corso.corso }</h2>
<h2>Professore: ${dataPrenotata.professore.cognome } ${dataPrenotata.professore.nome }</h2>
<h2>Data appello: ${dataPrenotata.dataAppello}</h2>
<hr>

<h2>Prenotati</h2>
<form action="/Campus/Prenotazione/PrenotazioneEsame/${ dataPrenotata.id}" method="post">
<input type="hidden" name="dataPrenotaId" value=${dataPrenotata.id }>
<input type="submit" value="Invia">
</form>
<hr>
</body>
</html>