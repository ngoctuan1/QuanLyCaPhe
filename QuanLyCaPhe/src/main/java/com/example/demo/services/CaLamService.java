package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.CaLam;
import com.example.demo.repository.TodoRepository;

public class CaLamService implements BaseService<CaLam> {

	@Autowired
	TodoRepository<CaLam> repo;

	@Override
	public Iterable<CaLam> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}

	@Override
	public Optional<CaLam> find(String id) {
		// TODO Auto-generated method stub
		return repo.find(id);
	}

	@Override
	public void save(CaLam p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.delete(id);
	}

}
