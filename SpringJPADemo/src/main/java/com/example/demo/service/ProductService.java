package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.example.demo.entities.Product;

public interface ProductService {
	public Iterable<Product> findAll();

	public Iterable<Product> findAll(Sort sort);

	public Optional<Product> find(String id);
	
//	public Product findOne(String id);

	public void save(Product p);

//	public void delete(Integer id);

	public void delete(String id);

	public void edit(String id, String name, BigDecimal price, int quantity);
}
