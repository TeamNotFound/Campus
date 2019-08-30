<html>
<head>
<title>Prenotazione Esame</title>
</head>
<%@ include file="/templates/header.jspf" %>
<c:forEach items="${date}" var="data">
<a href="${pageContext.request.contextPath}/Esami/Data/${data.id}">${data.dataAppello}</a><br>
</c:forEach>
<%@ include file="/templates/footer.jspf" %>