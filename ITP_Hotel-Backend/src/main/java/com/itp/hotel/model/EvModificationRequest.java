package com.itp.hotel.model;

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
@Table(name = "ev_modification_request")
public class EvModificationRequest {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int Ev_M_ID;
		
		
		@OneToOne(cascade =CascadeType.ALL) 
	    @JoinColumn(name = "user_id", referencedColumnName = "user_Id")
	    private Customer customer;

		
		
		@JoinColumn(name = "Booking_Id" ,nullable=false)
		@ManyToOne
	    private Booking booking;
		
		
		
		@Column(name = "Reason",length=254)
		private String Reason;
		
		@Column(name = "Message",length=250)
		private String Message;
		
		@Column(name = "Email",length=30)
		private String Email;
		
		@Column(name = "Days_Remain_Booking")
		private int Days_Remain_Booking;
		
		
		
		public EvModificationRequest() {
			super();
		}



		public EvModificationRequest(int ev_M_ID, Customer customer, Booking booking, String reason, String message,
				String email, int days_Remain_Booking) {
			super();
			Ev_M_ID = ev_M_ID;
			this.customer = customer;
			this.booking = booking;
			Reason = reason;
			Message = message;
			Email = email;
			Days_Remain_Booking = days_Remain_Booking;
		}



		public void setEv_M_ID(int ev_M_ID) {
			Ev_M_ID = ev_M_ID;
		}



		public void setCustomer(Customer customer) {
			this.customer = customer;
		}



		public void setBooking(Booking booking) {
			this.booking = booking;
		}



		public void setReason(String reason) {
			Reason = reason;
		}



		public void setMessage(String message) {
			Message = message;
		}



		public void setEmail(String email) {
			Email = email;
		}



		public void setDays_Remain_Booking(int days_Remain_Booking) {
			Days_Remain_Booking = days_Remain_Booking;
		}



		public int getEv_M_ID() {
			return Ev_M_ID;
		}



		public Customer getCustomer() {
			return customer;
		}



		public Booking getBooking() {
			return booking;
		}



		public String getReason() {
			return Reason;
		}



		public String getMessage() {
			return Message;
		}



		public String getEmail() {
			return Email;
		}



		public int getDays_Remain_Booking() {
			return Days_Remain_Booking;
		}

	
		
		
}
