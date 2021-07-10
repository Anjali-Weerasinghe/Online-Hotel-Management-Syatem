package com.itp.hotel.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="res_menu_item")

public class ResMenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_Item_Id")
	private long menu_item_id;
	
	@Column(name = "menu_item_type")
	private String menuItemType;
	
	@Column(name= "menu_item_name",unique=true , nullable= false,length = 32)
	private String menuItemName;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name= "description")
	private String description;
	
	@Column(name = "discount")
	private int discount;
	

	

	@OneToMany(mappedBy = "res")
	private List<OrderMenuItem> order_Menu_Item;

	public ResMenuItem () {
		super();
	}

	public ResMenuItem(long menu_item_id, String menuItemType, String menuItemName, double unitPrice,
			String description, int discount, List<OrderMenuItem> order_Menu_Item) {
		super();
		this.menu_item_id = menu_item_id;
		this.menuItemType = menuItemType;
		this.menuItemName = menuItemName;
		this.unitPrice = unitPrice;
		this.description = description;
		this.discount = discount;
		this.order_Menu_Item = order_Menu_Item;
	}

	public void setMenu_item_id(long menu_item_id) {
		this.menu_item_id = menu_item_id;
	}

	public void setMenuItemType(String menuItemType) {
		this.menuItemType = menuItemType;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}



	public void setOrder_Menu_Item(List<OrderMenuItem> order_Menu_Item) {
		this.order_Menu_Item = order_Menu_Item;
	}

	public long getMenu_item_id() {
		return menu_item_id;
	}

	public String getMenuItemType() {
		return menuItemType;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public int getDiscount() {
		return discount;
	}



	public List<OrderMenuItem> getOrder_Menu_Item() {
		return order_Menu_Item;
	}

	
	
	
	
	
	

}
