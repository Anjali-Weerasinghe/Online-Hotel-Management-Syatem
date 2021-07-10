package com.itp.hotel.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "food_count")
public class FoodCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int count_id;
	
	

	@JoinColumn(name = "user_Id")
	@ManyToOne
    private Employee employee ;
     
	
	@OneToOne(cascade =CascadeType.ALL) 
    @JoinColumn(name = "food_id", referencedColumnName = "food_Id")
    private FoodDetails foodDetails;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Date")
	private  LocalDate Date;
	
	@Column(name = "Quantity")
	private String Quantity;
	
	@Column(name = "Type")
	private String type;
	
	public FoodCount() {
		
	}

	public FoodCount(int count_id, Employee employee, FoodDetails foodDetails, String name, LocalDate date,
			String quantity, String type) {
		super();
		this.count_id = count_id;
		this.employee = employee;
		this.foodDetails = foodDetails;
		Name = name;
		Date = date;
		Quantity = quantity;
		this.type = type;
	}

	public void setCount_id(int count_id) {
		this.count_id = count_id;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setFoodDetails(FoodDetails foodDetails) {
		this.foodDetails = foodDetails;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount_id() {
		return count_id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public FoodDetails getFoodDetails() {
		return foodDetails;
	}

	public String getName() {
		return Name;
	}

	public LocalDate getDate() {
		return Date;
	}

	public String getQuantity() {
		return Quantity;
	}

	public String getType() {
		return type;
	}

	

	
	
	
	
	
}
