package com.indra.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indra.app.dao.IPetDAO;
import com.indra.app.entities.AdoptionStatus;
import com.indra.app.entities.Pet;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Pet p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pet findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAdoptionStatus(long id, AdoptionStatus status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pet> findBySpecie(String specie) {
		// TODO Auto-generated method stub
		return null;
	}

}
