# Condexo Back End

Questa applicazione è stata progettata per poter gestire degli user tramite l'utilizzo del framework Spring Boot e l'utilizzo del Database postgreSQL.

Al suo interno è presente un file csv con degli user generati in maniera casuale tramite il sito mockaroo.com in modo che all'avvio dell'applicazione il db venga riempito in maniera automatica.

## Contenuti
- [Oggetti e Interfacce](#Oggetti-e-Interfacce)
- [Metodi di ricerca](#Metodi-di-ricerca)
- [Metodi di scrittura](#Metodi-di-scrittura)
- [License](#License)

## Oggetti e Interfacce

Un oggetto User è così composto: 
- Id di tipo Long, generato automaticamente dal db
- Name 
- Surname di tipo String
- Address di tipo String
- ZipCode di tipo String
- UserType di tipo UserType
- Email di tipo String
- PhoneNumber di tipo String
- DateOfBirth di tipo LocalDate
- Genre di tipo Genre
- Password di tipo String
- Age di tipo Integer

L'interfaccia UserType è unu enum composto da 
- AMMINISTRATORE
- CONDOMINO
- FORNITORE

L'interfaccia Genre è un enum composto da 
- FEMALE
- MALE


