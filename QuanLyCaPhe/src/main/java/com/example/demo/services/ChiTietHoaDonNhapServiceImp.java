package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChiTietHoaDonNhap;
import com.example.demo.repository.ChiTietHoaDonNhapRepository;

@Service("chiTietHoaDonNhapService")
@Transactional
public class ChiTietHoaDonNhapServiceImp implements BaseService<ChiTietHoaDonNhap> {

	@Autowired
	ChiTietHoaDonNhapRepository repo;

	@Override
	public Iterable<ChiTietHoaDonNhap> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ChiTietHoaDonNhap> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(ChiTietHoaDonNhap p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
