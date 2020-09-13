package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Savings {
	@EmbeddedId
	public User user;
	public double investments;
	public double emergencyFunds;
	public double others;
	
	public Savings() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public double getInvestments() {
		return investments;
	}



	public void setInvestments(double investments) {
		this.investments = investments;
	}



	public double getEmergencyFunds() {
		return emergencyFunds;
	}



	public void setEmergencyFunds(double emergencyFunds) {
		this.emergencyFunds = emergencyFunds;
	}



	public double getOthers() {
		return others;
	}



	public void setOthers(double others) {
		this.others = others;
	}
	
	



	
}