package com.itp.hotel.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_menu_item")
public class OrderMenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_item_id;
	
	@Column(name = "menu_item_name")
	private String menuItemName;
	
	@Column(name = "menu_item_type")
	private String menuItemType;
	
	@Column(name = "Quantity")
	private int qty;
	
	@Column(name = "unit_price")
	private double unitPrice ;
	
	@JoinColumn(name = "menu_Order_Id" ,nullable=false)
	@ManyToOne
	private ResOrder rest;
	@JoinColumn(name = "menu_Item_Id" ,nullable=false)
	@ManyToOne
	private ResMenuItem res;

	public OrderMenuItem() {
		super();
	}

	public OrderMenuItem(long order_item_id, String menuItemName, String menuItemType, int qty, double unitPrice,
			ResOrder rest, ResMenuItem res) {
		super();
		this.order_item_id = order_item_id;
		this.menuItemName = menuItemName;
		this.menuItemType = menuItemType;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.rest = rest;
		this.res = res;
	}

	public void setOrder_item_id(long order_item_id) {
		this.order_item_id = order_item_id;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public void setMenuItemType(String menuItemType) {
		this.menuItemType = menuItemType;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setRest(ResOrder rest) {
		this.rest = rest;
	}

	public void setRes(ResMenuItem res) {
		this.res = res;
	}

	public long getOrder_item_id() {
		return order_item_id;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public String getMenuItemType() {
		return menuItemType;
	}

	public int getQty() {
		return qty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public ResOrder getRest() {
		return rest;
	}

	public ResMenuItem getRes() {
		return res;
	}

	
	
	

}