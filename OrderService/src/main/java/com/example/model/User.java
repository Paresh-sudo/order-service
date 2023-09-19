package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "UserTBL")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;

	// Establishing the one-to-many relationship with Product
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user")
	private List<Product> products;

	public User() {

	}

	/*
	 * public User(int id, String name, String email) { super(); this.id = id;
	 * this.name = name; this.email = email; }
	 */

	
	public User(int id, String name, String email, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.products = products;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
