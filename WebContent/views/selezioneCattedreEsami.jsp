<html>
<head>
<title>Prenotazione Esame</title>
</head>
<%@ include file="/views/templates/header.jspf" %>
<body>
	<c:forEach items="${cattedre}" var="cattedra">
	<a href="${pageContext.request.contextPath}/Esami/Cattedra/${cattedra.professore.id}-${cattedra.facolta.id}-${cattedra.corso.id}">
	${cattedra.facolta.facolta} | ${cattedra.corso.corso}</a><br>
	</c:forEach>
<%@ include file="/views/templates/footer.jspf" %>