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

import com.indra.app.entities.AdoptionStatus;
import com.indra.app.entities.Pet;
import com.indra.app.exception.PetNotFoundException;
import com.indra.app.service.IService;

@RestController //json
@RequestMapping("/pets")// http://ip:port/pets
public class MicroserviceController {
	
	private IService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(MicroserviceController.class);
	
	public MicroserviceController(IService service) {
		this.service=service;
	}
	
	/*Mapping methods
	 * insert -> post
	 * query -> get
	 * update -> put
	 * partial update -> patch
	 * delete -> delete
	 * */
	
	/*insert*/
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Pet p){
		try {
			
			if(service.insert(p)) {
				return new ResponseEntity<>("OK",HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception ex) {
			LOGGER.error("INSERT {}",ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping //http://ip:port/pets
	public ResponseEntity<List<Pet>> findAll(){
		try {
			return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
			
		}catch(PetNotFoundException ex) {
			LOGGER.warn("FINDALL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}catch(Exception ex) {
			LOGGER.error("FINDALL {}",ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/id")//http://ip:port/pets/id?id=2
	public ResponseEntity<Pet> findById(@RequestParam("id") long id){
		
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
			
		}catch(PetNotFoundException ex) {
			LOGGER.warn("FINDBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}catch(Exception ex) {
			LOGGER.error("FINDBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/specie")
	public ResponseEntity<List<Pet>> findBySpecie(@RequestParam("specie")String specie){
		try {
			return new ResponseEntity<>(service.findBySpecie(specie), HttpStatus.OK);
			
		}catch(PetNotFoundException ex) {
			LOGGER.warn("FINDBYSPECIE {}",ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}catch(Exception ex) {
			LOGGER.error("FINDBYSPECIE {}",ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateById(@RequestBody Pet p){
		try {
		       return new ResponseEntity<>(service.update(p), HttpStatus.OK);
			
		}catch(PetNotFoundException ex) {
			LOGGER.warn("UPDATEBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}catch(Exception ex) {
			LOGGER.error("UPDATEBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/status")
	public ResponseEntity<Boolean> updateAdoptionStatus(
			@RequestParam("id") long id,
			@RequestParam("status") AdoptionStatus status
			){
		
		try {
			
			return new ResponseEntity<>(
					service.updateAdoptionStatus(id, status),
					HttpStatus.OK);
			
		}catch(PetNotFoundException ex) {
			LOGGER.warn("UPDATEADOPTIONSTATUS {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}catch(Exception ex) {
			LOGGER.error("UPDATEADOPTIONSTATUS {}",ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteById(@RequestParam("id") long id){
		try {
			
			return new ResponseEntity<>(service.deleteById(id),HttpStatus.OK);
			
		}catch(PetNotFoundException ex) {
			LOGGER.warn("DELETEBYID {}",ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}catch(Exception ex) {
			LOGGER.error("DELETEBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	


}
