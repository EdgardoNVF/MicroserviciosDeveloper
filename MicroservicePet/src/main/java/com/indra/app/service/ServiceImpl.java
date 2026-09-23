package com.indra.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.indra.app.dao.IPetDAO;
import com.indra.app.entities.AdoptionStatus;
import com.indra.app.entities.Pet;
import com.indra.app.exception.PetNotFoundException;

@Service
public class ServiceImpl implements IService {
	
	//dependency
	private IPetDAO dao;
	
	//dependency injection
	public ServiceImpl(IPetDAO dao) {
		this.dao=dao;
	}
	
	

	@Override
	public boolean insert(Pet p) {
		if(p.getId()==0) {
			
			return dao.save(p)!=null;
			
		}
		return false;
	}

	@Override
	public List<Pet> findAll() {
		return Optional.of(dao.findAll())
				       .map(t->(List<Pet>)t)
				       .filter(t->!t.isEmpty())
				       .orElseThrow(()->new PetNotFoundException("empty result"));
	}

	@Override
	public boolean update(Pet p) {
		if(dao.existsById(p.getId())) {
			return dao.save(p)!=null;
		}
		
		throw new PetNotFoundException("pet "+p.getId()+" doesn't exists");
	}

	@Override
	public boolean deleteById(long id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		
		throw new PetNotFoundException("pet doesn't exists");
	}

	@Override
	public Pet findById(long id) {
		
		return dao.findById(id)
				.orElseThrow(()->new PetNotFoundException("pet doesn't exists"));
	}

	@Override
	public boolean updateAdoptionStatus(long id, AdoptionStatus status) {
		Pet search=this.findById(id);
		search.setAdoptionStatus(status);
		return dao.save(search)!=null;
	}

	@Override
	public List<Pet> findBySpecie(String specie) {
		return dao.findBySpecie(specie)
				  .filter(t->!t.isEmpty())
				  .orElseThrow(()->new PetNotFoundException("specie doesn't exists!!"));
	}

}
