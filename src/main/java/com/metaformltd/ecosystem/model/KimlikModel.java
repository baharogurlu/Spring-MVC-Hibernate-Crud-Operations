package com.metaformltd.ecosystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Kimlik")
public class KimlikModel {
	
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String description;
	@Column
	private String communication;
	@Column
	private String birthday;

	

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}


}
