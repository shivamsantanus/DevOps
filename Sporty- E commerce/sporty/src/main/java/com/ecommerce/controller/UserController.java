package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.respository.UserRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/{id}/buy/{productName}")
	@Transactional
	public @ResponseBody String buyProductName(@PathVariable(name="id") long id,@PathVariable(name="productName") String productName) {
		Optional<Product> pr = productService.getProductByName(productName);
		if(pr.isPresent()) {
			Optional<User> us = userService.getById(id);
			if(us.isPresent()) {
				User us1 = us.get();
				us1.addProduct(pr.get());
				Product pr1 = pr.get();
				pr1.addUser(us.get());
				userService.saveWithProduct(us1);
				productService.saveProduct(pr1);
				return "succesfully buy product: "+pr.get().getProductName();
			}
		}
		return "product not found";
		
	}
	
}
