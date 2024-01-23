package com.sai.npci.shoply.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.npci.shoply.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/")
	public String addToCart(@RequestBody Map<String,Long> item) {
		
		cartService.addToCart(item);
		return "Controller Cart Working";
		
	}
}
