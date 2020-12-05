package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CongNo;
import com.example.demo.repository.CongNoRepository;

@Service("congNoService")
@Transactional
public class CongNoServiceImp implements BaseService<CongNo>{

	@Autowired
	CongNoRepository repo;
	
	@Override
	public Iterable<CongNo> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<CongNo> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(CongNo p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
 
	
}
