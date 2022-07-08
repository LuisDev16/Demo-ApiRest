package com.Demo.RestApi.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.RestApi.demo.entity.Product;
import com.Demo.RestApi.demo.exception.ProductNotFoundException;
import com.Demo.RestApi.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product getProductById(Long id) throws ProductNotFoundException{
		
		Product product=productRepository.findById(id).orElse(null);
		
		if(product!=null) {
			return product;
		}else {
			throw new ProductNotFoundException("product not found with id:" +id);
		}
		
	}

	@Override
	public List<Product> allProducts() {
		return productRepository.findAll();	
	}

	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id)throws ProductNotFoundException {
		
		Product product=productRepository.findById(id).orElse(null);
		if(product!=null) {
		productRepository.deleteById(id);
		}else {
			throw new ProductNotFoundException("product not found with id:" +id);
		}
		
	}
	
}
