package com.nbssoftwares.SpringBootLatestJSBCCRUDApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import com.nbssoftwares.SpringBootLatestJSBCCRUDApplication.entity.ProductEntity;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private JdbcClient jdbcClient;

	@Override
	public List<ProductEntity> getAllProducts() {
		return jdbcClient.sql("SELECT * FROM products").query(ProductEntity.class).list();
	}

	@Override
	public void addProduct(ProductEntity product) {
		jdbcClient.sql("INSERT INTO products (name,price,quantity) VALUES(?,?,?)")
		.params(List.of(product.getName(),product.getPrice(),product.getQuantity()))
		.update();
	}

	@Override
	public void updateProduct(Integer id, ProductEntity product) {
		jdbcClient.sql("UPDATE products SET name=?, price=?, quantity=? WHERE id=?")
		.params(List.of(product.getName(),product.getPrice(),product.getQuantity(),id))
		.update();
	}

	@Override
	public void deleteProduct(Integer id) {
		jdbcClient.sql("DELETE FROM products WHERE id=?")
		.param(id)
		.update();
	}

}
