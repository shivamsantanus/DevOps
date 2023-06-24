package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="products")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "users" })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	private long productId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productPrice")
	private String productPrice;
	
	@Column(name="category")
	private String category;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "products")
	private List<User> users = new ArrayList<User>();
	public void addUser(User user) {
		this.users.add(user);
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Custom ToString -> Product";
	}
	
}
