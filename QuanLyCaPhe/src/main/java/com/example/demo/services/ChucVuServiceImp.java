package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChucVu;
import com.example.demo.repository.ChucVuRepository;

@Service("chucVuService")
@Transactional
public class ChucVuServiceImp implements BaseService<ChucVu> {

	@Autowired
	ChucVuRepository repo;

	@Override
	public Iterable<ChucVu> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ChucVu> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(ChucVu p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
