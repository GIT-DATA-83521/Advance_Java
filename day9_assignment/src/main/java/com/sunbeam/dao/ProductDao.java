package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
String addProduct(Product product);
Product getProductDetailsById(Long productId);
List<Product> getProductInSpecificRange(Double Min,Double Max,Category productCategory);
String applyDiscount(Category category,double discount);
String deleteByProductName(String productName);
String purchaseProduct(Long id , Integer n);
}
