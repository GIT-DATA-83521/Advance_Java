package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

public interface ProductService {
//	1.1 Get all products
//	1.2 Add new product
//	1.3 Update existing product
//	1.4 Get product details by given id
//	1.5 Delete product details
	List<Product> getAllProducts();
	Product addNewProduct(Product product);
	ApiResponse updateProduct(Long productId, Product existingProduct);
	public Product getDetails(Long productId);
	ApiResponse deleteProduct(Long productId);
}
