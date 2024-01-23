package com.sai.npci.shoply.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private User user;
	
	private int quantity;
	
	private int price;
	
	public Long getId() {
		return id;
	}

	


	public Product getProduct() {
		return product;
	}




	public void setProduct(Product product) {
		this.product = product;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public LocalDateTime getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Cart() {
		super();
	}




	public Cart(Product product, User user, int quantity, int price) {
		super();
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.price = price;
	}




	@CreationTimestamp
	private LocalDateTime createdAt;
}
