package com.indra.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indra.app.entities.AdoptionRequest;
import com.indra.app.services.IService;

@RestController
@RequestMapping("/adoptions")
public class MicroserviceController {
	private static final Logger LOGGER=LoggerFactory.getLogger(MicroserviceController.class);
	
	private IService service;
	
	public MicroserviceController(IService service) {
		this.service=service;
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insert(
			@RequestParam("idPet") long idPet,
			@RequestParam("idAdopter") long idAdopter
			){
		
		try {
			
			return new ResponseEntity<>(service.insert(idAdopter, idPet), HttpStatus.OK);
			
		}catch(NoSuchElementException ex) {
			LOGGER.warn("INSERT {}",ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}catch(Exception ex) {
			LOGGER.error("INSERT {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	 @GetMapping
	 public ResponseEntity<List<AdoptionRequest>> findAll(){
		 try {
			 return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
			 
		 }catch(Exception ex) {
			 LOGGER.error("FINDALL {}", ex.getMessage());
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
	 }
	 
	 @GetMapping("/email")
	 public ResponseEntity<List<AdoptionRequest>> findByEmail(
			 @RequestParam("email") String email){
		 try {
			 
			 return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
			 
		 }catch(NoSuchElementException ex) {
			 LOGGER.warn("FINDBYEMAIL {}",ex.getMessage());
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
		 }catch(Exception ex) {
			 LOGGER.error("FINDBYEMAIL {}", ex.getMessage());
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
	 }
	
	 @DeleteMapping
	 public ResponseEntity<Boolean> deleteById(@RequestParam("id") long id){
		 try {
			 
			 return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
			 
		 }catch(NoSuchElementException ex) {
			 LOGGER.warn("DELETEBYID {}",ex.getMessage());
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
		 }catch(Exception ex) {
			 LOGGER.error("DELETEBYID {}", ex.getMessage());
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
	 }
	
	
	
	
	

}
