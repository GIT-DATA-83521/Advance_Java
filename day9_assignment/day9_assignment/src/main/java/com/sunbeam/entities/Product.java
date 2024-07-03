package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,product name(unique)
//, price , available quantity
@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private Category category;
	@Column(length = 20,name = "product_Name",unique = true)
	private String productName;
	private double price;
	@Column(name = "available_Quantity")
	private int availableQuantity;
	public Product() {
	}
	public Product(long id, Category category, String productName, double price, int availableQuantity) {
		super();
		this.id = id;
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}

	
	public Product(Category category, String productName, double price, int availableQuantity) {
		super();
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}
	
	
}
