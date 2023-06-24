package com.ecommerce.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.PurchaseReport;
import com.ecommerce.entity.User;
import com.ecommerce.respository.ProductRepository;
import com.ecommerce.respository.UserRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.PurchaseReportService;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private PurchaseReportService purchaseReportService;

	@GetMapping("/getProduct")
	public ResponseEntity<List<Product>> getproduct(){
		List<Product> pr = productService.getAllProducts();
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(pr,
				HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/getProduct/categorize/{category}")
	public ResponseEntity<List<Product>> getAllProductByCategory(@PathVariable("category")String category){
		List<Product> allProduct = productService.getAllProductBasedOnCatogary(category);
		if(allProduct.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(allProduct,
				HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product temp = productService.saveProduct(product);
		return new ResponseEntity<Product>(temp,HttpStatus.OK);
	}
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") long id){
		Optional<Product> pr = productService.getProductById(id);
		return new ResponseEntity<Product>(pr.get(), HttpStatus.OK);
 	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("productId") long productId){
		productService.deleteProduct(productId);
		System.out.println("product Deleted");
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@GetMapping("/getusers")
	public ResponseEntity<List<User>> getAllSignedUpUsers() {
		List<User> allSignedUpUsers = userService.allUsers();
		if (allSignedUpUsers.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(allSignedUpUsers, HttpStatus.OK);

	}

	@GetMapping("/user/{name}")
	public ResponseEntity<User> getSignedUpUser(@PathVariable String name) {
		Optional<User> signedUpUser = userService.getUserByName(name);
		if (!signedUpUser.isPresent()) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(signedUpUser.get(), HttpStatus.OK);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUsers = userService.allUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);

	}

	@GetMapping("/getuser/{name}")
	public ResponseEntity<User> getUser(@PathVariable String name) {
		Optional<User> signedUpUser = userService.getUserByName(name);
		return new ResponseEntity<User>(signedUpUser.get(), HttpStatus.OK);
	}
	
	@GetMapping("/purchasereport")
	public ResponseEntity<List<PurchaseReport>> getPurchaseReport() {
		List<PurchaseReport> purchaseReport = purchaseReportService.getAllPurchaseReport();
		return new ResponseEntity<List<PurchaseReport>>(purchaseReport, HttpStatus.OK);

	}@GetMapping("/purchasereport/category/{category}")
	public ResponseEntity<List<PurchaseReport>> getReportCategory(@PathVariable String category) {
		List<PurchaseReport> purchaseReportBasedOnCategory = purchaseReportService.getReportCategory(category);
		return new ResponseEntity<List<PurchaseReport>>(purchaseReportBasedOnCategory, HttpStatus.OK);

	}
	
	@GetMapping("/purchasereport/date/{date}")
	public ResponseEntity<List<PurchaseReport>> getReportDate(@PathVariable String date) throws ParseException {
		List<PurchaseReport> purchaseReportBasedOnCategory = purchaseReportService.getReportDate(date);
		return new ResponseEntity<List<PurchaseReport>>(purchaseReportBasedOnCategory, HttpStatus.OK);

	}
	
}

