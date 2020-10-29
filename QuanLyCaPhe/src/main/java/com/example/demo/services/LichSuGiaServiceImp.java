package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LichSuGia;
import com.example.demo.repository.LichSuGiaRepository;

@Service("lichSuGiaService")
@Transactional
public class LichSuGiaServiceImp implements BaseService<LichSuGia> {

	@Autowired
	LichSuGiaRepository repo;

	@Override
	public Iterable<LichSuGia> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<LichSuGia> find(String id) {
		// TODO Auto-generated method stub
		return repo.find(id);
	}

	@Override
	public void save(LichSuGia p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.delete(id);
	}

}
