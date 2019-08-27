<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Primo Accesso?</h1>
<h2>Registrati come rettore!</h2>

<form action="FirstAccess" method="post"> 

<label for="nome">Nome Professore</label><br>
<input type="text" id="nome" name="nome"/><br>

<label for="cognome">Cognome Professore</label><br>
<input type="text" id="cognome" name="cognome"/><br>

<label for="nascita-data">Data Nascita</label><br>
<input type="date" id="nascita-data" name="nascita-data"/><br>

<label for="nascita-luogo">Luogo Nascita</label><br>
<input type="text" id="nascita-luogo" name="nascita-luogo"/><br>

<label for="fiscale">Codice Fiscale</label><br>
<input type="text" id="fiscale" name="fiscale"/><br>

<label for="sesso">Sesso:</label><br>

<input type="radio" id="uomo" name="sesso" value="uomo"/>
<label for="uomo">Uomo</label><br>

<input type="radio" id="sesso" name="sesso" value="donna"/>
<label for="donna">Donna</label><br>

<label for="titoli">Titoli di studio</label><br>
<input type="text" id="titoli" name="titoli"/><br>

<hr>

<label for="username">Username</label><br>
<input type="text" id="username" name="username"/><br>

<label for="password">Password</label><br>
<input type="text" id="password" name="password"/><br>

<input type="submit"/>

</form>
</body>
</html>