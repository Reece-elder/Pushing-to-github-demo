package com.qa.mockitoDemo;

public class Drink {
	
	private String type;
	private String size;
	private String customer;
	private boolean extras;
	private boolean whippedCream;
	public Drink(String type, String size, String customer, boolean extras, boolean whippedCream) {
		super();
		this.type = type;
		this.size = size;
		this.customer = customer;
		this.extras = extras;
		this.whippedCream = whippedCream;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public boolean isExtras() {
		return extras;
	}
	public void setExtras(boolean extras) {
		this.extras = extras;
	}
	public boolean isWhippedCream() {
		return whippedCream;
	}
	public void setWhippedCream(boolean whippedCream) {
		this.whippedCream = whippedCream;
	}
	@Override
	public String toString() {
		return "Drink [type=" + type + ", size=" + size + ", customer=" + customer + ", extras=" + extras
				+ ", whippedCream=" + whippedCream + "]";
	}
	
	


}
