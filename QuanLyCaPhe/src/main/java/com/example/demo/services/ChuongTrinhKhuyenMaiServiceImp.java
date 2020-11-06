package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChuongTrinhKhuyenMai;
import com.example.demo.repository.ChuongTrinhKhuyenMaiRepository;

@Service("chuongTrinhKhuyenMai")
@Transactional
public class ChuongTrinhKhuyenMaiServiceImp implements BaseService<ChuongTrinhKhuyenMai> {

	@Autowired
	ChuongTrinhKhuyenMaiRepository repo;

	@Override
	public Iterable<ChuongTrinhKhuyenMai> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ChuongTrinhKhuyenMai> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(ChuongTrinhKhuyenMai p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
