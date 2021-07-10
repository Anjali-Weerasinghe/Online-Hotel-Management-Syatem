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
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private int PId;
	
	
	@JoinColumn(name = "user_id" ,nullable=false)
	@ManyToOne
    private Customer customers;
	
	
	@Column(name = "p_date")
	private LocalDate P_Date;
	
	@Column(name = "pay_for",length=254)
	private String Pay_For;
	
	@Column(name = "amount")
	private double Amount;
	
	@Column(name = "method",length=50)
	private String Method;
	
	public Payment() {
		
	}

	

	public Payment(int pId, Customer customers, LocalDate p_Date, String pay_For, double amount, String method) {
		super();
		PId = pId;
		this.customers = customers;
		P_Date = p_Date;
		Pay_For = pay_For;
		Amount = amount;
		Method = method;
	}



	public void setPId(int pId) {
		PId = pId;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public void setP_Date(LocalDate p_Date) {
		P_Date = p_Date;
	}

	public void setPay_For(String pay_For) {
		Pay_For = pay_For;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public void setMethod(String method) {
		Method = method;
	}

	public int getPId() {
		return PId;
	}

	public Customer getCustomers() {
		return customers;
	}

	public LocalDate getP_Date() {
		return P_Date;
	}

	public String getPay_For() {
		return Pay_For;
	}

	public double getAmount() {
		return Amount;
	}

	public String getMethod() {
		return Method;
	}
	
	
	
	
	
	
}