package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChiTietHoaDonTra;
import com.example.demo.repository.ChiTietHoaDonTraRepository;

@Service("chiTietHoaDonTraService")
@Transactional
public class ChiTietHoaDonTraServiceImp implements BaseService<ChiTietHoaDonTra> {

	@Autowired
	ChiTietHoaDonTraRepository repo;

	@Override
	public Iterable<ChiTietHoaDonTra> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ChiTietHoaDonTra> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(ChiTietHoaDonTra p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
