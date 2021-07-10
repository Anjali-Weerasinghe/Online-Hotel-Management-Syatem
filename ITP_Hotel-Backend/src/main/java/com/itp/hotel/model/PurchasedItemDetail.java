package com.itp.hotel.model;


import java.time.LocalDate;

 

//import javax.persistence.CascadeType;
import javax.persistence.Column;


import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchased_item_detail")

public class PurchasedItemDetail {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int InvoiceNo;
	
	
	@OneToOne
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	private Employee employee ;
	
	
	@Column(name = "S_Id")
	private int Sid;
	
	@Column(name = "Item_Code")
	private int ItemCode;
	
	@Column(name = "Item_Name")
	private String ItemName;
	
	@Column(name = "Description")
	private String description;
	
	
	@Column(name = "Payment")
	private long payment;
	
	@Column(name= "Date")
	private LocalDate Date = LocalDate.now();
	
	@Column(name= "It_Category")
	private String It_Category;
	

	

	public PurchasedItemDetail() {
		super();
	}



	public PurchasedItemDetail(int invoiceNo, Employee employee, int sid, int itemCode,String itemName,String description, long payment, LocalDate date, String it_Category) {
		super();
		InvoiceNo = invoiceNo;
		this.employee = employee;
		Sid = sid;
		ItemCode = itemCode;
		ItemName = itemName;
		this.description = description;
		this.payment = payment;
		Date = date;
		It_Category = it_Category;
	}

	public void setInvoiceNo(int invoiceNo) {
		InvoiceNo = invoiceNo;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public void setItemCode(int itemCode) {
		ItemCode = itemCode;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public void setdescription(String description) {
		this.description= description;
	}

	public void setPayment(long payment) {
		this.payment = payment;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public void setIt_Category(String it_Category) {
		It_Category = it_Category;
	}

	public int getInvoiceNo() {
		return InvoiceNo;
	}

	public Employee getEmployee() {
		return employee;
	}

	public int getSid() {
		return Sid;
	}

	public int getItemCode() {
		return ItemCode;
	}
	public String getItemName() {
		return ItemName;
	}
	public String getdescription() {
		return description;
	}

	public long getPayment() {
		return payment;
	}

	public LocalDate getDate() {
		return Date;
	}

	public String getIt_Category() {
		return It_Category;
	}
	
	
}
