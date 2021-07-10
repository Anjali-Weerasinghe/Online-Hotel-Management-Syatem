package com.itp.hotel.model;

import java.time.Month;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="payroll")
public class Payroll {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long payId;
	
	
	@JoinColumn(name = "user_Id")
	@ManyToOne
    private Employee employee ;
   
	
	
	@Column(name="Total_Salary",nullable=false)
	private double totalSalary;
	
	@Column(name="Month")
	private Month month;
	
	public Payroll() {
		super();
	}

	public Payroll(long payId, Employee employee, double totalSalary, Month month) {
		super();
		this.payId = payId;
		this.employee = employee;
		this.totalSalary = totalSalary;
		this.month = month;
	}

	public void setPayId(long payId) {
		this.payId = payId;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public long getPayId() {
		return payId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public Month getMonth() {
		return month;
	}
	
	
}
