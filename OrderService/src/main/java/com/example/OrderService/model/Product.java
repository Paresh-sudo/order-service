package com.example.OrderService.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ProductTBL")
public class Product implements Serializable{
	
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "PRODUCT_ID", unique = true, updatable = false, nullable = false)
    private String productId;
    
    @Column(name = "PRODUCT_NAME",nullable = false)
    private String name;
    
    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;
    
    @Column(name = "PRICE")
    private double price;
    
    @Column(name = "DELETED")
    private String deleted;
    
    @Column(name = "CATEGORY")
    private String category;
    
    @Column(name = "Quantity")
    private long quantity;
    
    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    private String createdBy;
    
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private Date createdDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;
    
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
    
    @Column(name = "USER_ID", nullable = false)
    private String userId;
    
//    @JsonBackReference
	/* getUserDetails which added product need to map user_id key
	 * while joining column need to add insertable and updatbale false is IMP */
    @ManyToOne()
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false, insertable = false, updatable = false)
    private User user;
    
// // Establishing the many-to-one relationship with User
//    @JsonBackReference
//    @ManyToOne()
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
