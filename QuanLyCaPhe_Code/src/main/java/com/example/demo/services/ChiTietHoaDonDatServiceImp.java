package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChiTietHoaDonDat;
import com.example.demo.repository.ChiTietHoaDonDatRepository;

@Service("chiTietHoaDonDatService")
@Transactional
public class ChiTietHoaDonDatServiceImp implements BaseService<ChiTietHoaDonDat> {

	@Autowired
	ChiTietHoaDonDatRepository repo;

	@Override
	public Iterable<ChiTietHoaDonDat> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ChiTietHoaDonDat> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(ChiTietHoaDonDat p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
