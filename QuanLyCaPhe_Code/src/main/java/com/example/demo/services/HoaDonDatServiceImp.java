package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.HoaDonDat;
import com.example.demo.repository.HoaDonDatRepository;

@Service("hoaDonDatService")
@Transactional
public class HoaDonDatServiceImp implements BaseService<HoaDonDat> {

	@Autowired
	HoaDonDatRepository repo;

	@Override
	public Iterable<HoaDonDat> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<HoaDonDat> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(HoaDonDat p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
