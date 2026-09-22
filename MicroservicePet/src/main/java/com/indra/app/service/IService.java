package com.indra.app.service;

import java.util.List;

import com.indra.app.entities.AdoptionStatus;
import com.indra.app.entities.Pet;

public interface IService {
	
	boolean insert(Pet p);
	List<Pet> findAll();
	boolean update(Pet p);
	boolean deleteById(long id);
	Pet findById(long id);
	boolean updateAdoptionStatus(long id, AdoptionStatus status);
	List<Pet> findBySpecie(String specie);

}
