package com.rest.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class Income {
	@EmbeddedId
	private User user;
	private double salary;
	private double grants;
	private double refunds;
	private double others;
	
	public Income() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getGrants() {
		return grants;
	}
	
	public void setGrants(double grants) {
		this.grants = grants;
	}
	
	public double getRefunds() {
		return refunds;
	}
	
	public void setRefunds(double refunds) {
		this.refunds = refunds;
	}
	
	public double getOthers() {
		return others;
	}
	
	public void setOthers(double others) {
		this.others = others;
	}
	

}
