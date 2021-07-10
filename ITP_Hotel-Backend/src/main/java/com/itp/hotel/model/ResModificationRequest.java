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
@Table(name = "res_modification_requests")
public class ResModificationRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserve_M_Id")
	private int Reserve_M_Id;
	
	
	
	@OneToOne(cascade =CascadeType.ALL) 
    @JoinColumn(name = "user_id", referencedColumnName = "user_Id")
    private Customer customer;

	
	
	@JoinColumn(name = "res_Id" ,nullable=false)
	@ManyToOne
    private Reservation reservations;
	
	
	
	@Column(name = "rm_type",length=30)
	private String Rm_Type;
	
	@Column(name = "r_reason",length=250)
	private String R_Reason;

	@Column(name = "r_message",length=254)
	private String R_Message;
	
	@Column(name = "rm_req_date")
	private LocalDate Rm_Req_Date;

	public ResModificationRequest() {
		
		
	}

	public ResModificationRequest(int reserve_M_Id, Customer customer, Reservation reservations, String rm_Type,
			String r_Reason, String r_Message, LocalDate rm_Req_Date) {
		super();
		Reserve_M_Id = reserve_M_Id;
		this.customer = customer;
		this.reservations = reservations;
		Rm_Type = rm_Type;
		R_Reason = r_Reason;
		R_Message = r_Message;
		Rm_Req_Date = rm_Req_Date;
	}

	public void setReserve_M_Id(int reserve_M_Id) {
		Reserve_M_Id = reserve_M_Id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setReservations(Reservation reservations) {
		this.reservations = reservations;
	}

	public void setRm_Type(String rm_Type) {
		Rm_Type = rm_Type;
	}

	public void setR_Reason(String r_Reason) {
		R_Reason = r_Reason;
	}

	public void setR_Message(String r_Message) {
		R_Message = r_Message;
	}

	public void setRm_Req_Date(LocalDate rm_Req_Date) {
		Rm_Req_Date = rm_Req_Date;
	}

	public int getReserve_M_Id() {
		return Reserve_M_Id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Reservation getReservations() {
		return reservations;
	}

	public String getRm_Type() {
		return Rm_Type;
	}

	public String getR_Reason() {
		return R_Reason;
	}

	public String getR_Message() {
		return R_Message;
	}

	public LocalDate getRm_Req_Date() {
		return Rm_Req_Date;
	}
   
	
	
	
}

