package com.itp.hotel.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "bev_order")

public class BevOrder {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bev_Order_Id")
	private long bev_order_id;
	
	@Column(name = "date")
	private LocalDateTime dateTime=LocalDateTime.now();
	
	
	@OneToMany(mappedBy = "bev")
	private List<BarroomBill> Barroom_Bill;
	
	
	@OneToMany(mappedBy = "bevo")
	private List<BarroomOrder> baroom_order;
	
	
	
	
	
	
	public BevOrder() {
		
		
	}






	public BevOrder(long bev_order_id, LocalDateTime dateTime, List<BarroomBill> barroom_Bill,
			List<BarroomOrder> baroom_order) {
		super();
		this.bev_order_id = bev_order_id;
		this.dateTime = dateTime;
		Barroom_Bill = barroom_Bill;
		this.baroom_order = baroom_order;
	}






	public void setBev_order_id(long bev_order_id) {
		this.bev_order_id = bev_order_id;
	}






	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}






	public void setBarroom_Bill(List<BarroomBill> barroom_Bill) {
		Barroom_Bill = barroom_Bill;
	}






	public void setBaroom_order(List<BarroomOrder> baroom_order) {
		this.baroom_order = baroom_order;
	}






	public long getBev_order_id() {
		return bev_order_id;
	}






	public LocalDateTime getDateTime() {
		return dateTime;
	}






	public List<BarroomBill> getBarroom_Bill() {
		return Barroom_Bill;
	}






	public List<BarroomOrder> getBaroom_order() {
		return baroom_order;
	}
	
	





	
	
	

}