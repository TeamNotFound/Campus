<%@ include file="/views/templates/header.jspf" %>
<head>
<title>Cambia Password</title>
</head>
<body>
<h4>Cambia Password</h4>
<form action="${pageContext.request.contextPath}/CambiaPassword" method="post">
<label id="oldPassword">Vecchia Password:</label><br>
<input type="password" name="oldPassword" id="oldPassword" /><br>

<label id="newPassword">nuova Password:</label><br>
<input type="password" name="newPassword" id="newPassword" /><br>

<input type="submit" value="Cambia Password" />
</form>
</body>
</html>