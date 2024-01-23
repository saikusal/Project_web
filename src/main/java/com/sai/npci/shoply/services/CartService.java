package com.sai.npci.shoply.services;

import java.util.Map;
import java.util.Optional;

import org.apache.catalina.User;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.npci.shoply.models.Cart;
import com.sai.npci.shoply.models.Product;
import com.sai.npci.shoply.repos.CartRepo;
import com.sai.npci.shoply.repos.ProductRepo;
import com.sai.npci.shoply.repos.UserRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public String addToCart(Map<String, Long>item) {
		
		
		Optional<Product> product = productRepo.findById(item.get("product")); 
		
		Optional<com.sai.npci.shoply.models.User> user = userRepo.findById(item.get("user"));
		
		Cart cart = new Cart();
		cart.setProduct(product.get());
		cart.setUser(user.get());
		cart.setQuantity((item.get("quantity").intValue()));
		cart.setPrice((item.get("price").intValue()));
		return "added to cart";
	}

}
