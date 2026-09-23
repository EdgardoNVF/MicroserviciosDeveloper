package com.indra.app.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.app.entities.AdoptionStatus;
import com.indra.app.entities.Pet;

@FeignClient(name="microservicepet", url="http://localhost:9091")
public interface IPetFeign {
	
	@GetMapping("/pets/id")
	Pet findById(@RequestParam("id") long id);
	
	@PutMapping("/pets/status")
	boolean updateAdoptionStatus(
			@RequestParam("id") long id,
			@RequestParam("status") AdoptionStatus status
			);
	

}
