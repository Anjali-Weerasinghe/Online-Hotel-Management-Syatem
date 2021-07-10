package com.itp.hotel.model;


//import java.util.List;





//import javax.persistence.CascadeType;
import javax.persistence.Column;


import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")

public class Supplier {
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Sid;
	
	@OneToOne
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	private Employee employee ;
	
	//@OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL) 
   // private List <Item> item;
	
	@Column(name = "S_Name",length=80)
	private String Name;
	
	@Column(name = "Category",length=30)
	private String Category;
	
	@Column(name = "Email",length=30)
	private String Email;
	
	@Column(name= "Phone")
	private String Phone;
	
	@Column(name= "NIC",length=15)
	private String Nic;
	
	@Column(name= "Password",length=15)
	private String Password;

	
	public Supplier() {
		
	}



	public Supplier(int sid, Employee employee, /*List<Item> item,*/ String name, String category, String email,
			String phone, String nic,String password) {
		super();
		Sid = sid;
		this.employee = employee;
		//this.item = item;
		Name = name;
		Category = category;
		Email = email;
		Phone = phone;
		Nic = nic;
		Password = password;
		
	}



	public void setSid(int sid) {
		Sid = sid;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



//	public void setItem(List<Item> item) {
//		this.item = item;
//	}



	public void setName(String name) {
		Name = name;
	}



	public void setCategory(String category) {
		Category = category;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public void setPhone(String phone) {
		Phone = phone;
	}



	public void setNic(String nic) {
		Nic = nic;
	}
	public void setPassword(String password) {
		Password = password;
	}



	public int getSid() {
		return Sid;
	}



	public Employee getEmployee() {
		return employee;
	}



//	public List<Item> getItem() {
//		return item;
//	}



	public String getName() {
		return Name;
	}



	public String getCategory() {
		return Category;
	}



	public String getEmail() {
		return Email;
	}



	public String getPhone() {
		return Phone;
	}



	public String getNic() {
		return Nic;
	}
	
	public String getPassword() {
		return Password;
	}
	



}
