package com.example.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;

@Entity(name="ProductTBL")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
 // Establishing the many-to-one relationship with User
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public Product() {
    	
    }

	/*
	 * public Product(int id, String name, double price) { super(); this.id = id;
	 * this.name = name; this.price = price; }
	 */
	public Product(int id, String name, double price, User user) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", user=" + user + "]";
	}
    
}
