package com.indra.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.indra.app.dao.IAdopterDAO;
import com.indra.app.entities.Adopter;
import com.indra.app.exception.AdopterNotFoundException;

@Service
public class ServiceImpl implements IService{
	
	private IAdopterDAO dao;
	
	public ServiceImpl(IAdopterDAO dao) {
		this.dao=dao;
	}
	

	@Override
	public boolean insert(Adopter adopter) {
		if(adopter.getId()==0) {
			 return dao.save(adopter)!=null;
		}
		
		return false;
	}

	@Override
	public Adopter findById(long id) {
		
		return this.dao.findById(id)
				.orElseThrow(()->new AdopterNotFoundException("adopter does'n exist"));
	}

	@Override
	public Adopter findByEmail(String email) {
	
		return this.dao.findByEmail(email)
				.orElseThrow(()-> new AdopterNotFoundException("adopter doesn't exists"));
	}

	@Override
	public List<Adopter> findByLastName(String lastName) {
		return this.dao.findByLastName(lastName)
				.filter(t->!t.isEmpty())
				.orElseThrow(()->new AdopterNotFoundException("empty list"));
	}

	@Override
	public boolean updateById(Adopter adopter) {
		if(dao.existsById(adopter.getId())) {
			return dao.save(adopter)!=null;
		}
		throw new AdopterNotFoundException("adopter doesn't exists");
	}

	@Override
	public boolean deleteById(long id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		
		throw new AdopterNotFoundException("adopter doesn't exists");
	}


	@Override
	public List<Adopter> findAll() {
		return Optional.of(this.dao.findAll())
				.map(t-> (List<Adopter>)t)
				.filter(t->!t.isEmpty())
				.orElseThrow(()->new AdopterNotFoundException("empty"));
				
				
	}

}
