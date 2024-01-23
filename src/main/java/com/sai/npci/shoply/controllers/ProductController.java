package com.sai.npci.shoply.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.npci.shoply.models.Product;
import com.sai.npci.shoply.repos.ProductRepo;
import com.sai.npci.shoply.services.ProductService;

import lombok.Delegate;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	private ProductService productService;
	
	@GetMapping("/")
	public List<Product> getProducts() {
		
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getSingleProduct(@PathVariable(name="id")Long id)
	{
		return productService.getProductById(id);		
	}
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/name/{name}")
	public Product getProductByName(@PathVariable(name="name")String name)
	{
		return productService.getProductByName(name);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable(name="id")Long id,@RequestBody Product product)
	{
		return productService.updateProduct(product, id);
	}

	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		
		Product insertedProduct = productService.createProduct(product);
		return insertedProduct;
		
	}
	
	@DeleteMapping("/{id}")
	public Map<String, String> deleteProduct(@PathVariable(name="id")Long id) {
		productService.deleteProduct(id);
		
		Map<String,String> response = new HashMap<>();
		response.put("Message","Delete Successful");
		return response;
	}

}
