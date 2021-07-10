package com.itp.hotel.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name="beverage_item_category")



public class BeverageItemCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "bev_type",unique = true,nullable = false,length=32)
	private String BevType;
	
	
	public BeverageItemCategory() {
		
		super();
	}




	public BeverageItemCategory(long id, String bevType) {
		super();
		this.id = id;
		BevType = bevType;
	}




	public void setId(long id) {
		this.id = id;
	}




	public void setBevType(String bevType) {
		BevType = bevType;
	}




	public long getId() {
		return id;
	}




	public String getBevType() {
		return BevType;
	}
	
	
	

}