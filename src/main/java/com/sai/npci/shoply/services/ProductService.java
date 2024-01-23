package com.sai.npci.shoply.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.npci.shoply.models.Product;
import com.sai.npci.shoply.repos.ProductRepo;

@Service
public class ProductService {
	
	private ProductRepo productRepo;
	
	@Autowired
	public ProductService(ProductRepo productRepo) {
		
		this.productRepo=productRepo;
	}
	
	public Product createProduct(Product product) {
		
		return productRepo.save(product);
	}
	
	public List<Product> getAllProducts()
	{
		return productRepo.findAll();
		
	}
	
	public Product getProductById(Long id)
	{
		Optional<Product> prodOptional = productRepo.findById(id);
		if(prodOptional.isPresent())
		{
			return prodOptional.get();
		}
		
		throw new RuntimeException("Exception");
		
	}
	
	public Product getProductByName(String name)
	{
		return productRepo.findProductByName(name);
	}
	
	public Product updateProduct(Product product, Long id)
	{
		Optional<Product> prodOptional=productRepo.findById(id);
		
		if(prodOptional.isPresent())
		{
			Product productToUpdate = prodOptional.get();
			productToUpdate.setName(product.getName());
			productToUpdate.setPrice(product.getPrice());
			productToUpdate.setQuantity(product.getQuantity());
			
			return productRepo.save(productToUpdate);
		}
		
		throw new RuntimeException("Product Not Found");
		
	}
	
	public void deleteProduct(Long id) {
		
		Optional<Product> prodOptional = productRepo.findById(id);
		if(prodOptional.isPresent())
		{
			productRepo.deleteById(id);
		}
		
		else {
			throw new RuntimeException("Exception");
		}
	}
	
}
