package com.indra.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.indra.app.entities.AdoptionRequest;

public interface IAdoptionRequestDAO extends CrudRepository<AdoptionRequest, Long>{
	
	Optional<List<AdoptionRequest>> findByEmailAdopter(String emailAdopter);

}
