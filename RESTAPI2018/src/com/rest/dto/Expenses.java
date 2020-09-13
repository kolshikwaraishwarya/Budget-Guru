package com.rest.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class Expenses {
	@EmbeddedId
	private User user;
	
	public double personal;
	public double education;
	public double shelter;
	public double health;
	public double transportation;
	public double household;
	public double clothing;
	public double food;
	public double miscellaneous;
	
	
	
	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public double getPersonal() {
		return personal;
	}
	public void setPersonal(double personal) {
		this.personal = personal;
	}
	public double getEducation() {
		return education;
	}
	public void setEducation(double education) {
		this.education = education;
	}
	public double getShelter() {
		return shelter;
	}
	public void setShelter(double shelter) {
		this.shelter = shelter;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getTransportation() {
		return transportation;
	}
	public void setTransportation(double transportation) {
		this.transportation = transportation;
	}
	public double getHousehold() {
		return household;
	}
	public void setHousehold(double household) {
		this.household = household;
	}
	public double getClothing() {
		return clothing;
	}
	public void setClothing(double clothing) {
		this.clothing = clothing;
	}
	public double getFood() {
		return food;
	}
	public void setFood(double food) {
		this.food = food;
	}
	public double getMiscellaneous() {
		return miscellaneous;
	}
	public void setMiscellaneous(double miscellaneous) {
		this.miscellaneous = miscellaneous;
	}
	

}
