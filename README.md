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
- Name di tipo String (non può essere null)
- Surname di tipo String(non può essere null)
- Address di tipo String(non può essere null)
- ZipCode di tipo String
- UserType di tipo UserType(non può essere null)
- Email di tipo String(non può essere null)
- PhoneNumber di tipo String
- DateOfBirth di tipo LocalDate
- Genre di tipo Genre
- Password di tipo String (non può essere null)
- Age di tipo Integer
- FiscalCode di tipo String (non può essere null)

L'interfaccia UserType è unu enum composto da 
- AMMINISTRATORE
- CONDOMINO
- FORNITORE

L'interfaccia Genre è un enum composto da 
- FEMALE
- MALE

## METODI DI RICERCA

- Per recuperare tutti gli user presenti nel db 
  http://localhost:8080/user/getAll
  
- Per recuperare un user dal suo id
  http://localhost:8080/user/findById/{id}
  
- Per recuperare un user dal suo cognome
  http://localhost:8080/user/findBySurname/{surname}
  
- Per recuperare un user dal suo codice fiscale
  http://localhost:8080/user/findByFiscalCode/{fiscalCode}
  
## METODI DI SCRITTURA
- Metodo Post

    http://localhost:8080/user/add
```
{
    "name":"Sara",
    "surname":"Mottolese",
    "address":"via roma 56",
    "phoneNumber":"1234567890",
    "email":"sara@mottolese.com",
    "fiscalCode":"TGGDOT98K45K506H",
    "dateOfBirth":"1989-08-13",
    "userType":"CONDOMINO",
    "password":"nkfsjfksjldj"
}
```
- Metodo Put

    http://localhost:8080/user/update
```
{
    "id": 9,
    "name": "Giulia",
    "surname": "Rossi"
}
```
- Metodo Delete

    http://localhost:8080/user/delete/9
    
## License
MIT ©
    



