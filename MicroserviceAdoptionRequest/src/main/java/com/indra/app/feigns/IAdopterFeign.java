package com.indra.app.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.app.entities.Adopter;

//without eureka
//@FeignClient(name="microserviceadopter", url="http://localhost:9092")

//with eureka
@FeignClient(name="microserviceadopter")
public interface IAdopterFeign {
	
	@GetMapping("/adopters/id")
	Adopter findById(@RequestParam("id") long id);
	
	@GetMapping("/adopters/email")
	Adopter findByEmail(@RequestParam("email") String email);
	

}
