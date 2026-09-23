package com.indra.app.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.indra.app.dao.IAdoptionRequestDAO;
import com.indra.app.entities.Adopter;
import com.indra.app.entities.AdoptionRequest;
import com.indra.app.entities.AdoptionRequestStatus;
import com.indra.app.entities.AdoptionStatus;
import com.indra.app.entities.Pet;
import com.indra.app.feigns.IAdopterFeign;
import com.indra.app.feigns.IPetFeign;

import feign.FeignException.InternalServerError;
import feign.FeignException.NotFound;

@Service
public class ServiceImpl implements IService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ServiceImpl.class);
	private IAdoptionRequestDAO dao;
	private IAdopterFeign adopterFeign;
	private IPetFeign petFeign;
	
	private ServiceImpl(
			IAdoptionRequestDAO dao,
			IAdopterFeign adopterFeing,
			IPetFeign petFeign
			) {
		this.dao=dao;
		this.adopterFeign=adopterFeing;
		this.petFeign=petFeign;
	}
	
	
	

	@Override
	public boolean insert(long userId, long petId) {
		try {
			Pet pet=this.petFeign.findById(petId);
			LOGGER.info("MICROSERVICE PET RESPONSE {}", pet.toString());
			
			Adopter adopter=this.adopterFeign.findById(userId);
			LOGGER.info("MICROSERVICE ADOPTER RESPONSE {}", adopter.toString());
			
			if(pet.getAdoptionStatus().equals(AdoptionStatus.AVAILABLE)) {
				AdoptionRequest request=new AdoptionRequest();
				request.setAdopterId(userId);
				request.setPetId(petId);
				request.setEmailAdopter(adopter.getEmail());
				request.setStatus(AdoptionRequestStatus.PENDING);
				request.setNamePet(pet.getName());
				
				//modify pet status
				this.petFeign.updateAdoptionStatus(petId, AdoptionStatus.IN_PROCESS);
				
				return this.dao.save(request)!=null;
			}else {
			    
				throw new NoSuchElementException("mascota no disponible");
			}
			
			
		}catch(NotFound ex) {
			LOGGER.warn("FEIGN NOT FOUND {}", ex.getMessage());
			throw new NoSuchElementException("mascota o adopter no existen!!");
			
		}catch(InternalServerError ex) {
			LOGGER.error("FEIGN SERVER ERROR {}", ex.getMessage());
			throw new RuntimeException("error interno!!");
		}
		
	}

	@Override
	public List<AdoptionRequest> findAll() {
		
		return (List<AdoptionRequest>)dao.findAll();
	}

	@Override
	public List<AdoptionRequest> findByEmail(String email) {
		return dao.findByEmailAdopter(email)
				.filter(t->!t.isEmpty())
				.orElseThrow(()->
				new NoSuchElementException("no hay solicitudes del cliente"));
	}

	@Override
	public boolean deleteById(long id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		throw new NoSuchElementException("no existe solicitud!!");
	}

	@Override
	public boolean updateAdoptionRequestStatus(long id, AdoptionRequestStatus status) {
		AdoptionRequest request=dao.findById(id)
				                   .orElseThrow();
		request.setStatus(status);
		return dao.save(request)!=null;
	}

}
