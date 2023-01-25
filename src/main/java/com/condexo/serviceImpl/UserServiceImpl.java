package com.condexo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.condexo.exception.UserException;
import com.condexo.model.User;
import com.condexo.repository.UserRepository;
import com.condexo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	/***************** CRUD *****************/
	
	/*Per la post ho scelto di utilizzare il filtro di ricerca per codice fiscale in quanto
	 * prima di essere registrato non esiste un id, e l'unica variabile che come l'id e' univoca e' 
	 * proprio il codice fiscale
	 */
	@Override
	public User post(User user) {
		Optional<User> findUser= userRepo.findByFiscalCode(user.getFiscalCode());
		if(findUser.isPresent()) {
			throw new UserException("Esiste gia' un utente con questo codice fiscale");
		}else
		return userRepo.save(user);
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User put(User user) {
		Optional<User>findUser= userRepo.findById(user.getId());
		if(findUser.isEmpty()) {
			throw new UserException("Lo user che vuoi modificare non esiste");
		}else {
			User updateUser= findUser.get();
			if(user.getAddress()!=null)
				updateUser.setAddress(user.getAddress());
			if(user.getEmail()!=null)
				updateUser.setEmail(user.getEmail());
			if(user.getName()!=null)
				updateUser.setName(user.getName());
			if(user.getSurname()!=null)
				updateUser.setSurname(user.getSurname());
			if(user.getPhoneNumber()!=null)
				updateUser.setPhoneNumber(user.getPhoneNumber());
			if(user.getFiscalCode()!= null) {
				if(userRepo.findByFiscalCode(user.getFiscalCode()).isPresent())
					throw new UserException("esiste gia' un utente con questo codice fiscale");
				else
				updateUser.setFiscalCode(user.getFiscalCode());
			}
			if(user.getDateOfBirth()!= null)
				updateUser.setDateOfBirth(user.getDateOfBirth());
			return userRepo.save(updateUser);
		}	
	}

	@Override
	public void delete(Long id) {
		Optional<User> user= userRepo.findById(id);
		if(user.isEmpty())
			throw new UserException("Non esiste nessun user con questo id");
		else
			userRepo.deleteById(id);
	}
	/***************** FILTRI RICERCA *****************/
	@Override
	public User findById(Long id) {
		Optional<User> findUser=userRepo.findById(id);
		if(findUser.isEmpty())
			throw new UserException("User non trovato");
		else
			return findUser.get();
	}

	@Override
	public Page<User> findBySurname(Pageable page, String surname) {
		Page<User> findUser= userRepo.findBySurname(page, surname);
		
		if(findUser!=null) 
			return findUser;
		else
			throw new UserException("nessun user con questo cognome");
	}

	@Override
	public User findByFiscalCode(String fiscalCode) {
		Optional<User> findUser=userRepo.findByFiscalCode(fiscalCode);
		if(findUser.isEmpty())
			throw new UserException("User non trovato");
		else
			return findUser.get();
	}

}
