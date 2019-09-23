package com.softvision.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonFilter("UserBeanFilter")
public class User {

	private int id;
	
	@Size(min=2, message="Name should have minimum 2 characters.")
	@ApiModelProperty(notes="Name should have minimum 2 characters.")
	private String name;
	
	@Past(message="Date should be past date not valid for future dates.")
	@ApiModelProperty(notes="Date should be past date not valid for future dates.")
	private Date birthDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	public User(int id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	protected User() {
		
	}
	
}
