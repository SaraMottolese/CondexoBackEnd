package com.condexo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condexo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findById(Long id);
	public Page<User> findBySurname(Pageable page,String surname);
	public Optional<User> findByFiscalCode(String fiscalCode);

}
