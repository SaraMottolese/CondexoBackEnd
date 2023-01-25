package com.condexo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condexo.model.User;
import com.condexo.serviceImpl.UserServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/add")
	@Operation(summary = "aggiungi user", description = "Il metodo permette di aggiungere un nuovo user")
	@ApiResponse(responseCode = "200", description = "user creato con successo")
	public ResponseEntity<User> add(@RequestBody User user) {
		User addUser = userServiceImpl.post(user);
		return new ResponseEntity<User>(addUser, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	@Operation(summary = "lista user", description = "Il metodo ritorna la lista di tutti gli user")
	@ApiResponse(responseCode = "200", description = "lista user ritornata")
	public ResponseEntity<List<User>> getAll() {
		List<User> userList = userServiceImpl.getAll();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@PutMapping("/update")
	@Operation(summary = "update user", description = "Il metodo permette di modificare un user")
	@ApiResponse(responseCode = "200", description = "user modificato")
	public ResponseEntity<User> update(@RequestBody User user) {
		User userUpdate = userServiceImpl.put(user);
		return new ResponseEntity<User>(userUpdate, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "elimina user", description = "Il metodo permette di eliminare un user conoscendo l'id"
			+ "cancellando un cliente vengono elliminate anche le relative fatture")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		userServiceImpl.delete(id);
		return new ResponseEntity<String>("user eliminato correttamente", HttpStatus.OK);
	}

	/***************** FILTRI RICERCA ****************/

	@GetMapping("/findById/{id}")
	@Operation(summary = "trova user da id", description = "Il metodo permette cercare un user conoscendo il suo id")
	@ApiResponse(responseCode = "200", description = "user trovato")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User userFound = userServiceImpl.findById(id);
		return new ResponseEntity<User>(userFound, HttpStatus.OK);
	}
	
	@GetMapping("/findBySurname/{surname}")
	@Operation(summary = "trova user dal cognome", description = "Il metodo permette cercare un user conoscendo il cognome")
	@ApiResponse(responseCode = "200", description = "user trovato")
	public ResponseEntity<Page<User>> findBySurname(@PathVariable String surname, Pageable page) {
		Page<User> userList = userServiceImpl.findBySurname(page, surname);
		return new ResponseEntity<Page<User>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/findByFiscalCode/{fiscalCode}")
	@Operation(summary = "trova user dal codice fiscale", description = "Il metodo permette cercare un user conoscendo il suo codice fiscale")
	@ApiResponse(responseCode = "200", description = "user trovato")
	public ResponseEntity<User> findByFiscalCode(@PathVariable String fiscalCode) {
		User user = userServiceImpl.findByFiscalCode(fiscalCode);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
