package com.itp.hotel.model;

import java.time.LocalDate;


import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ItemCode;
	
	@JoinColumn(name = "sid")
	@ManyToOne
    private Supplier supplier ;
	
	@Column(name = "Item_Name")
	private String Name;
	
	@Column(name = "It_Category")
	private String It_Category;
	
	@Column(name = "Price")
	private String price;
	
	@Column(name= "Date")
	private LocalDate Date;

	@Column(name = "Description")
	private String Description;
	
	
	public Item() {
		
	}

	public Item(int itemCode, Supplier supplier, String name, String it_Category, String price, LocalDate date, String description) {
		ItemCode = itemCode;
		this.supplier = supplier;
		Name = name;
		It_Category = it_Category;
		this.price = price;
		Date = date;
		Description = description;
	}


	public void setItemCode(int itemCode) {
		ItemCode = itemCode;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setIt_Category(String it_Category) {
		It_Category = it_Category;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getItemCode() {
		return ItemCode;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public String getName() {
		return Name;
	}

	public String getIt_Category() {
		return It_Category;
	}

	public String getPrice() {
		return price;
	}

	public LocalDate getDate() {
		return Date;
	}

	public String getDescription() {
		return Description;
	}
}
