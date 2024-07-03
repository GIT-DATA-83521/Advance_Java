package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Products")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 25)
	private String productName;
	private double price;
	@Column(name = "available_Quantity")
	private int availableQuantity;
	
	public Product(long id, String productName, double price, int availableQuantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
}
