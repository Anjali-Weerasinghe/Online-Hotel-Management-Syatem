package com.itp.hotel.model;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="res_order")
public class ResOrder {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_Order_Id")
	private long menu_order_id;
	
	
	

	@Column(name = "date")
	private LocalDateTime date = LocalDateTime.now();
	
	@OneToMany(mappedBy = "rest")
	private List<OrderMenuItem> order_Menu_Item;
	
	@OneToMany(mappedBy = "res")
	private List<ResBill> Res_Bill;

	public ResOrder() {
		super();
	}

	public ResOrder(long menu_order_id, LocalDateTime date, List<OrderMenuItem> order_Menu_Item,
			List<ResBill> res_Bill) {
		super();
		this.menu_order_id = menu_order_id;
		this.date = date;
		this.order_Menu_Item = order_Menu_Item;
		Res_Bill = res_Bill;
	}

	public void setMenu_order_id(long menu_order_id) {
		this.menu_order_id = menu_order_id;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setOrder_Menu_Item(List<OrderMenuItem> order_Menu_Item) {
		this.order_Menu_Item = order_Menu_Item;
	}

	public void setRes_Bill(List<ResBill> res_Bill) {
		Res_Bill = res_Bill;
	}

	public long getMenu_order_id() {
		return menu_order_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public List<OrderMenuItem> getOrder_Menu_Item() {
		return order_Menu_Item;
	}

	public List<ResBill> getRes_Bill() {
		return Res_Bill;
	}

	
	
	

}
