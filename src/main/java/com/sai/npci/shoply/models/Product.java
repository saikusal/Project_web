package com.sai.npci.shoply.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
//@NoArgsConstructor //->For constructor
//@Getter //-> For getter
//@Setter //-> For setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="price",nullable = false)
	private int price;
	
	@Column(name="quantity",nullable = false)
	private int quantity;
	
	

	public Long getId() {
		return id;
	}



	public Product() {
		super();
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Cart> cart = new ArrayList<>();



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}



	public Product(String name, int price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	
}
