package com.sunbeam.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {

		return productDao.findAll();
	}

	@Override
	public Product addNewProduct(Product product) {
		
		Product	persistentProduct = productDao.save(product);
		return persistentProduct;
	}


	@Override
	public ApiResponse updateProduct(Long productId, Product existingProduct) {
		String msg="Failed to update product...!";
		if(productDao.existsById(productId)) {
			productDao.save(existingProduct);
			msg="Product Details Updated...!";
		}
		return new ApiResponse(msg);
	}

	@Override
	public Product getDetails(Long productId) {
		
		return productDao.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Invalid Product ID!!!!"));
	}

	@Override
	public ApiResponse deleteProduct(Long productId) {
		String msg="Product could not be deleted...!";
		if(productDao.existsById(productId)) {
			productDao.deleteById(productId);
			msg="Product Deleted Successfully...!";
		}
		return new ApiResponse(msg); 
	}

}
