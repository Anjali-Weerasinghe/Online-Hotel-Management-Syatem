package com.itp.hotel.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Booking_Id")
	private int Booking_Id;
	
	@JoinColumn(name = "user_Id" ,nullable=false)
	@ManyToOne
    private Customer  customer;
	
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL) 
    private List <EvModificationRequest> evModificationRequest;
	
	@OneToOne(cascade =CascadeType.ALL) 
    @JoinColumn(name = "event_id", referencedColumnName = "Event_Id")
    private Event event;

	
	@Column(name = "Date")
	private LocalDate Date;
	
	@Column(name = "Cus_Name", length=80)
	private String Cus_Name;
	
	@Column(name = "Cus_Phone_No", length=25)
	private String Cus_Phone_No;
	
	@Column(name = "Num_Participants")
	private int Num_Participants;
	
	@Column(name = "Booking_Type", length=20)
	private String Booking_Type;
	
	@Column(name = "Booking_Package")
	private char Booking_Package;
	
	@Column(name = "Time_In")
	private LocalTime Time_In;
	
	@Column(name = "Time_Out")
	private LocalTime Time_Out;
	
	
	
	public Booking() {
		super();
	}



	public Booking(int booking_Id, Customer customer, List<EvModificationRequest> evModificationRequest, Event event,
			LocalDate date, String cus_Name, String cus_Phone_No, int num_Participants, String booking_Type,
			char booking_Package, LocalTime time_In, LocalTime time_Out) {
		super();
		Booking_Id = booking_Id;
		this.customer = customer;
		this.evModificationRequest = evModificationRequest;
		this.event = event;
		Date = date;
		Cus_Name = cus_Name;
		Cus_Phone_No = cus_Phone_No;
		Num_Participants = num_Participants;
		Booking_Type = booking_Type;
		Booking_Package = booking_Package;
		Time_In = time_In;
		Time_Out = time_Out;
	}



	public void setBooking_Id(int booking_Id) {
		Booking_Id = booking_Id;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public void setEvModificationRequest(List<EvModificationRequest> evModificationRequest) {
		this.evModificationRequest = evModificationRequest;
	}



	public void setEvent(Event event) {
		this.event = event;
	}



	public void setDate(LocalDate date) {
		Date = date;
	}



	public void setCus_Name(String cus_Name) {
		Cus_Name = cus_Name;
	}



	public void setCus_Phone_No(String cus_Phone_No) {
		Cus_Phone_No = cus_Phone_No;
	}



	public void setNum_Participants(int num_Participants) {
		Num_Participants = num_Participants;
	}



	public void setBooking_Type(String booking_Type) {
		Booking_Type = booking_Type;
	}



	public void setBooking_Package(char booking_Package) {
		Booking_Package = booking_Package;
	}



	public void setTime_In(LocalTime time_In) {
		Time_In = time_In;
	}



	public void setTime_Out(LocalTime time_Out) {
		Time_Out = time_Out;
	}



	public int getBooking_Id() {
		return Booking_Id;
	}



	public Customer getCustomer() {
		return customer;
	}



	public List<EvModificationRequest> getEvModificationRequest() {
		return evModificationRequest;
	}



	public Event getEvent() {
		return event;
	}



	public LocalDate getDate() {
		return Date;
	}



	public String getCus_Name() {
		return Cus_Name;
	}



	public String getCus_Phone_No() {
		return Cus_Phone_No;
	}



	public int getNum_Participants() {
		return Num_Participants;
	}



	public String getBooking_Type() {
		return Booking_Type;
	}



	public char getBooking_Package() {
		return Booking_Package;
	}



	public LocalTime getTime_In() {
		return Time_In;
	}



	public LocalTime getTime_Out() {
		return Time_Out;
	}

	
	
	
	
}
