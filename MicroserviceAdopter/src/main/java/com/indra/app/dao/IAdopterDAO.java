package com.indra.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.indra.app.entities.Adopter;

public interface IAdopterDAO extends CrudRepository<Adopter, Long>{
	
	Optional<Adopter> findByEmail(String email);
	
	Optional<List<Adopter>> findByLastName(String lastName);
	
}
