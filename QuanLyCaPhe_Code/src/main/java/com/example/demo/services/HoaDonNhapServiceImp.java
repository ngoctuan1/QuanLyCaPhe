package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.HoaDonNhap;
import com.example.demo.repository.HoaDonNhapRepository;

@Service("hoaDonNhapService")
@Transactional
public class HoaDonNhapServiceImp implements BaseService<HoaDonNhap> {

	@Autowired
	HoaDonNhapRepository repo;

	@Override
	public Iterable<HoaDonNhap> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<HoaDonNhap> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(HoaDonNhap p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
