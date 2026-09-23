package com.indra.app.entities;

public class Pet {
	private long id;
	private String name;
	private String breed;
	private String specie;
	private AdoptionStatus adoptionStatus;
	
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
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public AdoptionStatus getAdoptionStatus() {
		return adoptionStatus;
	}
	public void setAdoptionStatus(AdoptionStatus adoptionStatus) {
		this.adoptionStatus = adoptionStatus;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", breed=" + breed + ", specie=" + specie + ", adoptionStatus="
				+ adoptionStatus + "]";
	}
	
	
}
