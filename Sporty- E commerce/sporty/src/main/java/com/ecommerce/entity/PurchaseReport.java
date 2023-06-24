package com.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="purchase_report")
public class PurchaseReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	@Column(name="category_product")
	private  String category_product;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="price_product")
	private int price_product;
	
	@Column(name="user_email")
	private String user_email;
	
	@Column(name="user_name")
	private String user_name;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_product")
	private Date date_product;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory_product() {
		return category_product;
	}

	public void setCategory_product(String category_product) {
		this.category_product = category_product;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice_product() {
		return price_product;
	}

	public void setPrice_product(int price_product) {
		this.price_product = price_product;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Date getDate_product() {
		return date_product;
	}

	public void setDate_product(Date date_product) {
		this.date_product = date_product;
	}
	
	
	

	@Override
	public String toString() {
		return "PurchaseReport [id=" + id + ", category_product=" + category_product + ", product_name=" + product_name
				+ ", price_product=" + price_product + ", user_email=" + user_email + ", user_name=" + user_name
				+ ", date_product=" + date_product + "]";
	}
	
}
