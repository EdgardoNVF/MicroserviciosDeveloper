package com.indra.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="adoption_requests")
public class AdoptionRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false, name="pet_id")
	private long petId;
	
	@Column(nullable=false, name="adopter_id")
	private long adopterId;
	
	@Column(nullable=false, name="name_pet", length=50)
	private String namePet;
	
	@Column(name="email_adopter", length=100)
	private String emailAdopter;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=30)
	private AdoptionRequestStatus status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	public long getAdopterId() {
		return adopterId;
	}
	public void setAdopterId(long adopterId) {
		this.adopterId = adopterId;
	}
	public String getNamePet() {
		return namePet;
	}
	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}
	public String getEmailAdopter() {
		return emailAdopter;
	}
	public void setEmailAdopter(String emailAdopter) {
		this.emailAdopter = emailAdopter;
	}
	public AdoptionRequestStatus getStatus() {
		return status;
	}
	public void setStatus(AdoptionRequestStatus status) {
		this.status = status;
	}
	
	

}
