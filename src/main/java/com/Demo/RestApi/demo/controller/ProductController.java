package com.Demo.RestApi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.RestApi.demo.entity.Product;
import com.Demo.RestApi.demo.exception.ProductNotFoundException;
import com.Demo.RestApi.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
    @GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) throws ProductNotFoundException{
   
        return ResponseEntity.ok(productService.getProductById(id));
	}
    
    @GetMapping("/listProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
    	return ResponseEntity.ok(productService.allProducts());
    }
    
    @PostMapping("/create")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
    	return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws ProductNotFoundException{
    	productService.deleteProduct(id);
    }
}
