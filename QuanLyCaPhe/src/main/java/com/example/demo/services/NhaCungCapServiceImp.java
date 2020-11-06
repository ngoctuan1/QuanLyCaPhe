package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.NhaCungCap;
import com.example.demo.repository.NhaCungCapRepository;

@Service("nhaCungCapService")
@Transactional
public class NhaCungCapServiceImp implements BaseService<NhaCungCap>{

	@Autowired
	NhaCungCapRepository repo;
	
	@Override
	public Iterable<NhaCungCap> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<NhaCungCap> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(NhaCungCap p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
}
