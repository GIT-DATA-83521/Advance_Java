package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;
import com.sunbeam.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	ProductController() {
		System.out.println("in constuctor of " + getClass());
	}

	@GetMapping
	public List<Product> listOfProducts() {
		return productService.getAllProducts();

	}

	@PostMapping
	@Operation(description = "Add new Product...!!!")
	public ResponseEntity<?> addProduct(@RequestBody Product newProduct) {
		try {
			System.out.println("hii" + newProduct);
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addNewProduct(newProduct));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
		return ResponseEntity.ok(productService.updateProduct(productId, product));
	}
	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long productId){
		try {
			return ResponseEntity.ok(productService.getDetails(productId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		
		
	}
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
		return ResponseEntity.ok
				(productService.deleteProduct(productId));		
	}
}
