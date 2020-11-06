package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CaLam;
import com.example.demo.repository.CaLamRepository;

@Service("caLamService")
@Transactional
public class CaLamServiceImp implements BaseService<CaLam> {

	@Autowired
	CaLamRepository repo;

	@Override
	public Iterable<CaLam> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}

	@Override
	public Optional<CaLam> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(CaLam p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
