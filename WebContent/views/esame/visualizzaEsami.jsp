<%@ include file="/views/templates/header.jspf" %>
<head>
<title>Visualizza esami</title>
</head>
<body>
<h1>Carriera</h1><br><br>

<h2>Studente:</h2><br>
<h3>${account.utente.nome}</h3>
<h3>${account.utente.cognome}</h3>
<hr>
<table>
<tr>
	<th>Esame</th>
	<th>Voto</th>
</tr>
<c:forEach items="${esami}" var="e">
	<tr>
		<td>${e.corso.corso}</td>
		<td>${e.votoEsame }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
