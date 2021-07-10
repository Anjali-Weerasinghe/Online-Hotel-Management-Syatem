package com.itp.hotel.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "barroom_Order")

public class BarroomOrder {
	
	/*@EmbeddedId
	
	private Barroom_Order_comp id;*/
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long bar_ID;
	
	@Column(name="unit_price")
	private double unit_price;
	
	@Column(name="bev_name")
	private String bev_name;
	
	@Column(name="bev_type")
	private String bev_type;
	
	@Column(name="quantity")
	private double quantity;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="date")
	private LocalDateTime date = LocalDateTime.now();
	
	
	@JoinColumn(name = "bev_Order_Id" ,nullable=false)
	@ManyToOne
	private BevOrder bevo;
	
	
	@JoinColumn(name = "bev_ID" ,nullable=false)
	@ManyToOne
	private Beverage best;
	



	public BarroomOrder() {
		
		
		
	}
	
	
	




	public BarroomOrder(double unit_price, String bev_name, String bev_type, double quantity, LocalDateTime date,
			BevOrder bevo, Beverage best) {
		super();
		this.unit_price = unit_price;
		this.bev_name = bev_name;
		this.bev_type = bev_type;
		this.quantity = quantity;
		this.date = date;
		this.bevo = bevo;
		this.best = best;
	}







	public long getBar_ID() {
		return bar_ID;
	}




	public void setBar_ID(long bar_ID) {
		this.bar_ID = bar_ID;
	}




	public double getUnit_price() {
		return unit_price;
	}




	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}




	public String getBev_name() {
		return bev_name;
	}




	public void setBev_name(String bev_name) {
		this.bev_name = bev_name;
	}




	public String getBev_type() {
		return bev_type;
	}




	public void setBev_type(String bev_type) {
		this.bev_type = bev_type;
	}




	public double getQuantity() {
		return quantity;
	}




	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}




	public LocalDateTime getDate() {
		return date;
	}




	public void setDate(LocalDateTime date) {
		this.date = date;
	}




	public BevOrder getBevo() {
		return bevo;
	}




	public void setBevo(BevOrder bevo) {
		this.bevo = bevo;
	}




	public Beverage getBest() {
		return best;
	}




	public void setBest(Beverage best) {
		this.best = best;
	}
	
	
	

}