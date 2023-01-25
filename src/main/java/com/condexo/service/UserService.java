package com.condexo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.condexo.model.User;

public interface UserService {
	
	/***************** CRUD *****************/
	public User post(User user);
	
	public List<User> getAll();
	
	public User put (User user);
	
	public void delete (Long Id);
	
	/***************** FILTRI RICERCA *****************/
	
	public User findById(Long id);
	
	public Page<User> findBySurname(Pageable page,String surname);
	
	public User findByFiscalCode (String fiscalCode);
	

}
