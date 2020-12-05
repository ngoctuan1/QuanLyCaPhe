package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.NhanVien;
import com.example.demo.repository.NhanVienRepository;

@Service("nhanVienService")
@Transactional
public class NhanVienServiceImp implements BaseService<NhanVien> {

	@Autowired
	NhanVienRepository repo;

	@Override
	public Iterable<NhanVien> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<NhanVien> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(NhanVien p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
