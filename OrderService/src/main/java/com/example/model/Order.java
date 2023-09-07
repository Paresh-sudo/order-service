package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="orderTBL")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	public Order() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderName() {
		return name;
	}
	public void setOrderName(String orderName) {
		this.name = orderName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + name + ", price=" + price + "]";
	}
	public Order(int id, String orderName, double price) {
		super();
		this.id = id;
		this.name = orderName;
		this.price = price;
	}
	
	
}	
