package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.respository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public List<Product> getAllProductBasedOnCatogary(String category) {
		return productRepo.findAllByCategory(category);
	}
	public Optional<Product> getProductByName(String productName) {
		Optional<Product> proOptional = productRepo.findByName(productName);
		return proOptional;
	}
	
	public Optional<Product> getProductById(long id) {
		return productRepo.findById(id);
	}
	
	public void  deleteProduct(long productId) {
		  productRepo.deleteById(productId);
	}
}
