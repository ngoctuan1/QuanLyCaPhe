package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Optional;

//import org.springframework.transaction.annotation.Transactional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.TodoRepository;

@Service("productService")
@Transactional
public class ProductServiceImp implements ProductService {

	@Autowired
	private TodoRepository repo;

	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Iterable<Product> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return repo.findAll(sort);
	}

	@Override
	public void save(Product p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

//	@Override
//	public void delete(Integer id) {
//		// TODO Auto-generated method stub
//		repo.delete(id);
//
//	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.delete(id);

	}

	@Override
	public void edit(String id, String name, BigDecimal price, int quantity) {
		// TODO Auto-generated method stub
//		repo.edit(id, name, price, quantity);
	}

	@Override
	public Optional<Product> find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
