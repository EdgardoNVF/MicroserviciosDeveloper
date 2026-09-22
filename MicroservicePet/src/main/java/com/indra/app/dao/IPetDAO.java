package com.indra.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.indra.app.entities.Pet;

public interface IPetDAO extends CrudRepository<Pet, Long> {
	@Query("SELECT u FROM Pet u WHERE u.specie= :specie")
	Optional<List<Pet>> findBySpecie(@Param("specie") String specie);

}
