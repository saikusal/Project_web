package com.sai.npci.shoply.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.npci.shoply.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
	Product findProductByName(String name);

}
