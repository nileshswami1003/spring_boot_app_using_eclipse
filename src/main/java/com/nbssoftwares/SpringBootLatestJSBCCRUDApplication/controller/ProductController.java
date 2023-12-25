package com.nbssoftwares.SpringBootLatestJSBCCRUDApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nbssoftwares.SpringBootLatestJSBCCRUDApplication.entity.ProductEntity;
import com.nbssoftwares.SpringBootLatestJSBCCRUDApplication.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/list")
	List<ProductEntity> getAllProductsList() {
		return productServiceImpl.getAllProducts();
	}
	
	@PostMapping("/add")
	void insertProduct(@RequestBody ProductEntity productEntity) {
		productServiceImpl.addProduct(productEntity);
	}
	
	@PutMapping("/update/{id}")
	void updateProduct(@PathVariable Integer id, @RequestBody ProductEntity productEntity) {
		productServiceImpl.updateProduct(id, productEntity);
	}
	
	@DeleteMapping("/delete/{id}")
	void deleteProduct(@PathVariable Integer id) {
		productServiceImpl.deleteProduct(id);
	}
}
