[![N|Solid](https://i.imgur.com/TYs9xKp.png)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Il primo accesso al nostro portale "Campus Not Found" avviene con **la registrazione del rettore.**

Una volta compilati tutti i campi del form, la registrazione sarà avvenuta con successo e verrà fatto un redirect alla pagina dove il rettore potrà fare il login con username e password scelti in fase di registrazione.

Effettuato il login, **il rettore avrà il controllo completo su tutto.**

## Features del rettore:

 - Aggiungere/Rimuovere le facoltà
 - Aggiungere/Rimuovere i corsi
  - Associare i corsi alle relative facoltà
  - Aggiungere/Rimuovere professori
  - Assegnare la cattedra ad un professore
  - Liberare la cattedra

Una volta che il rettore avrà **aggiunto il professore, quest'ultimo potrà - a sua volta - loggarsi con le proprie credenziali.**

## Features del professore:

 - Creare date di appello
 - Convalidare Esami

**Lo studente, infine, una volta iscritto al portale potrà gestire le prenotazioni** e controllare gli esami.

## Features dello studente:

 - Visualizzare le date di appello dei corsi inerenti alla sua facoltà
 - Prenotarsi alle suddette date di appello
 - Visualizzare le prenotazioni effettuate
 - Visualizzare gli esami
 
# Live Sand-Box

Il sito è stato caricato sulla piattaforma Heroku ed è ora disponibile a tutti! 
[Clicca quì](https://floating-mountain-59143.herokuapp.com/) per accedere al sito e provare in prima persona tutte le funzionalità che vi abbiamo messo a disposizione!

Nel caso voleste provare le funzionalità del rettore, le sue credenziali sono:
 - USERNAME: admin
 - PASSWORD: abcdef

Ma attenzione, che se la password dovesse cambiare o un altro professore fosse promosso a rettore saremmo costretti a "droppare" il database e a ripopolare il sito da zero!
