package com.itp.hotel.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(referencedColumnName="user_Id")
public class Employee extends  User {

	private static final long serialVersionUID = 1L;

	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL) 
    private List <MonthlyAttendance> monthlyAttendance;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL) 
    private List <Payroll> payroll;
	
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL) 
    private List <FoodCount> foodCount;
	
//	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL) 
//    private List <Supplier> supplier;
	
	
//	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL) 
//    private List <PurchasedItemDetail> purchasedItemDetail;
	    
	@Column(name="nic", length=20, nullable=false)
	private String nic;

	@Column(name="fname", length=30, nullable=false)
	private String fName;

	@Column(name="lname", length=30, nullable=false)
	private String lName;
	
	
	@Column(name="address", length=30, nullable=false)
	private String address;
	
	@Column(name="dob", length=15, nullable=false)
	private  LocalDate dateOfBirth;
	
	
	@Column(name="start_date", length=15, nullable=false)
	private  LocalDate startDate;
    

	@Column(name="phone", length=10, nullable=false)
	private  String  phone;


	public Employee() {
		super();
	}


	public Employee(Long userId, String username, String email, String password, String role,
			List<MonthlyAttendance> monthlyAttendance, List<Payroll> payroll, List<FoodCount> foodCount,
			/*List<Supplier> supplier,*//* List<PurchasedItemDetail> purchasedItemDetail,*/ String nic, String fName,
			String lName, String address, LocalDate dateOfBirth, LocalDate startDate, String phone) {
		super(userId, username, email, password, role);
		this.monthlyAttendance = monthlyAttendance;
		this.payroll = payroll;
		this.foodCount = foodCount;
//		this.supplier = supplier;
//		this.purchasedItemDetail = purchasedItemDetail;
		this.nic = nic;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.startDate = startDate;
		this.phone = phone;
	}


	public void setMonthlyAttendance(List<MonthlyAttendance> monthlyAttendance) {
		this.monthlyAttendance = monthlyAttendance;
	}


	public void setPayroll(List<Payroll> payroll) {
		this.payroll = payroll;
	}


	public void setFoodCount(List<FoodCount> foodCount) {
		this.foodCount = foodCount;
	}


//	public void setSupplier(List<Supplier> supplier) {
//		this.supplier = supplier;
//	}


//	public void setPurchasedItemDetail(List<PurchasedItemDetail> purchasedItemDetail) {
//		this.purchasedItemDetail = purchasedItemDetail;
//	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<MonthlyAttendance> getMonthlyAttendance() {
		return monthlyAttendance;
	}


	public List<Payroll> getPayroll() {
		return payroll;
	}


	public List<FoodCount> getFoodCount() {
		return foodCount;
	}

//	public List<Supplier> getSupplier() {
//		return supplier;
//	}


//	public List<PurchasedItemDetail> getPurchasedItemDetail() {
//		return purchasedItemDetail;
//	}


	public String getNic() {
		return nic;
	}


	public String getfName() {
		return fName;
	}


	public String getlName() {
		return lName;
	}


	public String getAddress() {
		return address;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public String getPhone() {
		return phone;
	}


	

	


	


	
}









