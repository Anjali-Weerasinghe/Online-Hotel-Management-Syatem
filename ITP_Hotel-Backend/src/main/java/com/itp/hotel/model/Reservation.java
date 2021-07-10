package com.itp.hotel.model;

import java.time.LocalDate;
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
import javax.persistence.Table;



@Entity
@Table(name = "reservations")

public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "res_Id")
	private int Res_Id;
	
	
	@OneToMany(mappedBy = "reservation",cascade = CascadeType.ALL) 
    private List <Room> room;
	
	@OneToMany(mappedBy = "reservations",cascade = CascadeType.ALL) 
    private List <ResModificationRequest> resModificationRequest;
	

	@JoinColumn(name = "user_id" ,nullable=false)
	@ManyToOne
    private Customer customer;
	
	
	
	
	@Column(name = "cus_name",length=80)
	private String Cus_Name;
	
	@Column(name = "cus_phone",length=15)
	private int Cus_Phone;
	
	@Column(name = "check_in")
	private LocalDate Check_In;
	
	@Column(name = "check_out")
	private LocalDate Check_Out;
	
	@Column(name = "no_of_ac_rooms")
	private int No_Of_Ac_Rooms;
	
	@Column(name = "no_of_non_ac_rooms")
	private int No_Of_Non_Ac_Rooms;
	
	@Column(name = "no_of_child")
	private int No_Of_Child;
	
	@Column(name = "no_of_adult")
	private int No_Of_Adult;
	
	
	
	public Reservation() {
		
	}



	public Reservation(int res_Id, List<Room> room, List<ResModificationRequest> resModificationRequest,
			Customer customer, String cus_Name, int cus_Phone, LocalDate check_In, LocalDate check_Out,
			int no_Of_Ac_Rooms, int no_Of_Non_Ac_Rooms, int no_Of_Child, int no_Of_Adult) {
		super();
		Res_Id = res_Id;
		this.room = room;
		this.resModificationRequest = resModificationRequest;
		this.customer = customer;
		Cus_Name = cus_Name;
		Cus_Phone = cus_Phone;
		Check_In = check_In;
		Check_Out = check_Out;
		No_Of_Ac_Rooms = no_Of_Ac_Rooms;
		No_Of_Non_Ac_Rooms = no_Of_Non_Ac_Rooms;
		No_Of_Child = no_Of_Child;
		No_Of_Adult = no_Of_Adult;
	}



	public void setRes_Id(int res_Id) {
		Res_Id = res_Id;
	}



	public void setRoom(List<Room> room) {
		this.room = room;
	}



	public void setResModificationRequest(List<ResModificationRequest> resModificationRequest) {
		this.resModificationRequest = resModificationRequest;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public void setCus_Name(String cus_Name) {
		Cus_Name = cus_Name;
	}



	public void setCus_Phone(int cus_Phone) {
		Cus_Phone = cus_Phone;
	}



	public void setCheck_In(LocalDate check_In) {
		Check_In = check_In;
	}



	public void setCheck_Out(LocalDate check_Out) {
		Check_Out = check_Out;
	}



	public void setNo_Of_Ac_Rooms(int no_Of_Ac_Rooms) {
		No_Of_Ac_Rooms = no_Of_Ac_Rooms;
	}



	public void setNo_Of_Non_Ac_Rooms(int no_Of_Non_Ac_Rooms) {
		No_Of_Non_Ac_Rooms = no_Of_Non_Ac_Rooms;
	}



	public void setNo_Of_Child(int no_Of_Child) {
		No_Of_Child = no_Of_Child;
	}



	public void setNo_Of_Adult(int no_Of_Adult) {
		No_Of_Adult = no_Of_Adult;
	}



	public int getRes_Id() {
		return Res_Id;
	}



	public List<Room> getRoom() {
		return room;
	}



	public List<ResModificationRequest> getResModificationRequest() {
		return resModificationRequest;
	}



	public Customer getCustomer() {
		return customer;
	}



	public String getCus_Name() {
		return Cus_Name;
	}



	public int getCus_Phone() {
		return Cus_Phone;
	}



	public LocalDate getCheck_In() {
		return Check_In;
	}



	public LocalDate getCheck_Out() {
		return Check_Out;
	}



	public int getNo_Of_Ac_Rooms() {
		return No_Of_Ac_Rooms;
	}



	public int getNo_Of_Non_Ac_Rooms() {
		return No_Of_Non_Ac_Rooms;
	}



	public int getNo_Of_Child() {
		return No_Of_Child;
	}



	public int getNo_Of_Adult() {
		return No_Of_Adult;
	}



	
	
	
}
