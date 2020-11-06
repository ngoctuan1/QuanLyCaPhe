package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.HoaDonTra;
import com.example.demo.repository.HoaDonTraRepository;

@Service("hoaDonTraService")
@Transactional
public class HoaDonTraServiceImp implements BaseService<HoaDonTra> {

	@Autowired
	HoaDonTraRepository repo;

	@Override
	public Iterable<HoaDonTra> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<HoaDonTra> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(HoaDonTra p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
