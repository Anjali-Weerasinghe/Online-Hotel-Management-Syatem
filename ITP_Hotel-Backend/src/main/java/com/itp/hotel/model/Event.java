package com.itp.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Event_Id")
	private int Event_Id;
	
	@Column(name = "Type",length=20)
	private String Type;
	
	@Column(name = "Package")
	private char Package;
	
	@Column(name = "Description",length=254)
	private String Description;
	
	@Column(name = "Price")
	private double Price;
	
	public Event() {
		super();
	}

	public Event(int event_Id, String type, char package1, String description, double price) {
		super();
		Event_Id = event_Id;
		Type = type;
		Package = package1;
		Description = description;
		Price = price;
	}

	public int getEvent_Id() {
		return Event_Id;
	}

	public void setEvent_Id(int event_Id) {
		Event_Id = event_Id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public char getPackage() {
		return Package;
	}

	public void setPackage(char package1) {
		Package = package1;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	
	
	
}