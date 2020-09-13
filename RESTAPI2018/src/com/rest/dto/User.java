package com.rest.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class User implements Serializable {
	
	public String uId;
	public String month;
	public int year;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	
	
}
