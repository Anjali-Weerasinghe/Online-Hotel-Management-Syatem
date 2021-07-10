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
@Table(name="res_bill")

public class ResBill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bill_id ;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name= "total_amount")
	private double total_Amount ;
	
	
	@Column(name = "date")
	private LocalDateTime date = LocalDateTime.now();
	
	
	@JoinColumn(name = "menu_Order_Id" ,nullable=false)
	@ManyToOne
	private ResOrder res;



	public ResBill() {
		super();
	}



	public ResBill(long bill_id, int discount, double total_Amount, LocalDateTime date, ResOrder res) {
		super();
		this.bill_id = bill_id;
		this.discount = discount;
		this.total_Amount = total_Amount;
		this.date = date;
		this.res = res;
	}



	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}



	public void setDiscount(int discount) {
		this.discount = discount;
	}



	public void setTotal_Amount(double total_Amount) {
		this.total_Amount = total_Amount;
	}



	public void setDate(LocalDateTime date) {
		this.date = date;
	}



	public void setRes(ResOrder res) {
		this.res = res;
	}



	public long getBill_id() {
		return bill_id;
	}



	public int getDiscount() {
		return discount;
	}



	public double getTotal_Amount() {
		return total_Amount;
	}



	public LocalDateTime getDate() {
		return date;
	}



	public ResOrder getRes() {
		return res;
	}




}
