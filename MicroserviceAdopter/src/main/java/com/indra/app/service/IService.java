package com.indra.app.service;

import java.util.List;

import com.indra.app.entities.Adopter;

/*
 * Registrar un adoptante.
Consultar todos los adoptantes.
Buscar adoptante por id.
Buscar adoptante por email.
Buscar adoptantes por apellido.
Actualizar información de un adoptante.
Eliminar un adoptante por id.*/
public interface IService {
	boolean insert(Adopter adopter);
	Adopter findById(long id);
	Adopter findByEmail(String email);
	List<Adopter> findByLastName(String lastName);
	boolean updateById(Adopter adopter);
	boolean deleteById(long id);
	List<Adopter> findAll();
	

}
