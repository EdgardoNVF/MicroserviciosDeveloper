package com.indra.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/*
 * this annotation activates globally
 * the scan feign clients
 * */
@EnableFeignClients
@SpringBootApplication
public class MicroserviceAdoptionRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAdoptionRequestApplication.class, args);
	}

}
