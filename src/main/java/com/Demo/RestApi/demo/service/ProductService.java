package com.Demo.RestApi.demo.service;

import java.util.List;

import com.Demo.RestApi.demo.entity.Product;
import com.Demo.RestApi.demo.exception.ProductNotFoundException;

public interface ProductService {
	
	Product getProductById(Long id) throws ProductNotFoundException;
	List<Product> allProducts();
	Product saveProduct(Product product);
	void deleteProduct(Long id) throws ProductNotFoundException;

}
