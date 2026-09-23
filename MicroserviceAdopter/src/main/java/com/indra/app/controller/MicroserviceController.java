package com.indra.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indra.app.entities.Adopter;
import com.indra.app.exception.AdopterNotFoundException;
import com.indra.app.service.IService;

/*
 * Registrar un adoptante.
Consultar todos los adoptantes.
Buscar adoptante por id.
Buscar adoptante por email.
Buscar adoptantes por apellido.
Actualizar información de un adoptante.
Eliminar un adoptante por id.
*/
@RestController
@RequestMapping("/adopters")
public class MicroserviceController {
	private IService service;
	private static final Logger LOGGER=LoggerFactory.getLogger(MicroserviceController.class);
	
	public MicroserviceController(IService service) {
		this.service=service;
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insert(@RequestBody Adopter adopter){
		try {
			return new ResponseEntity<>(this.service.insert(adopter), HttpStatus.CREATED);
			
		}catch(Exception ex) {
			LOGGER.error("INSERT {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/id")
	public ResponseEntity<Adopter> findById(@RequestParam long id){
		try {
			return new ResponseEntity<Adopter>(this.service.findById(id), HttpStatus.OK);
			
		}catch(AdopterNotFoundException ex) {
			LOGGER.warn("FINDBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			LOGGER.error("FINDBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/email")
	public ResponseEntity<Adopter> findByEmail(@RequestParam("email") String email){
		try {
			return new ResponseEntity<Adopter>(this.service.findByEmail(email), HttpStatus.OK);
			
		}catch(AdopterNotFoundException ex) {
			LOGGER.warn("FINDBYEMAIL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			LOGGER.error("FINDBYEMAIL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/lastname")
	public ResponseEntity<List<Adopter>> findByLastName(@RequestParam("lastName") String lastName){
		try {
			return new ResponseEntity<>(this.service.findByLastName(lastName), HttpStatus.OK);
			
		}catch(AdopterNotFoundException ex) {
			LOGGER.warn("FINDBYLASTNAME {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			LOGGER.error("FINDBYLASTNAME {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Boolean> update(@RequestBody Adopter adopter){
		try {
			return new ResponseEntity<>(this.service.updateById(adopter), HttpStatus.OK);
			
		}catch(AdopterNotFoundException ex) {
			LOGGER.warn("UPDATE {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			LOGGER.error("UPDATE {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@DeleteMapping
	public ResponseEntity<Boolean> delete(@RequestParam("id") long id){
		try {
			return new ResponseEntity<>(this.service.deleteById(id), HttpStatus.OK);
			
		}catch(AdopterNotFoundException ex) {
			LOGGER.warn("DELETE {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			LOGGER.error("DELETE {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Adopter>> all(){
		try {
			return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
			
		}catch(AdopterNotFoundException ex) {
			LOGGER.warn("FINDALL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			LOGGER.error("FINDALL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	

}
