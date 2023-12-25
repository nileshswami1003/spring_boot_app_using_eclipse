package com.nbssoftwares.SpringBootLatestJSBCCRUDApplication.service;

import java.util.List;

import com.nbssoftwares.SpringBootLatestJSBCCRUDApplication.entity.ProductEntity;

public interface ProductService {

	List<ProductEntity> getAllProducts();
	
	void addProduct(ProductEntity product);
	
	void updateProduct(Integer id, ProductEntity product);
	
	void deleteProduct(Integer id);
}
