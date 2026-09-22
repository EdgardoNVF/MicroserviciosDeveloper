package com.indra.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=50)
	private String specie;
	
	@Column(length=50)
	private String breed;
	private int age;
	
	@Column(length=50)
	private String size;
	
	@Column(length=20)
	private String sex;
	
	@Column(length=150, name="health_status")
	private String healthStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="adoption_status", length=30, nullable=false)
	private AdoptionStatus adoptionStatus;
	
	@PrePersist
	public void preInsert() {
		if(adoptionStatus==null) {
			adoptionStatus=AdoptionStatus.AVAILABLE;
		}
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public AdoptionStatus getAdoptionStatus() {
		return adoptionStatus;
	}
	public void setAdoptionStatus(AdoptionStatus adoptionStatus) {
		this.adoptionStatus = adoptionStatus;
	}
	
	
	


}
