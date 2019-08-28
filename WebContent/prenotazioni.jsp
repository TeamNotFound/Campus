<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/templates/header.jspf" %>

<h1>Prenotazioni effettuate: </h1>
<table>
<tr>
	<th>Corso</th>
	<th>Professore</th>
	<th>Data</th>
</tr>
<c:forEach items="${prenotazioni}" var="p">
<tr>
	<td>${p.dataAppello.corso.corso}</td>
	<td>${p.dataAppello.professore.cognome} ${p.dataAppello.professore.nome}</td>
	<td>${p.dataAppello.dataAppello }
</tr>
</c:forEach>
</table>

<%@ include file="/templates/footer.jspf" %>