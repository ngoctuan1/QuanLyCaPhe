package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;

@Service("taiKhoanService")
@Transactional
public class TaiKhoanServiceImp implements BaseService<TaiKhoan> {

	@Autowired
	TaiKhoanRepository repo;

	@Override
	public Iterable<TaiKhoan> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<TaiKhoan> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(TaiKhoan p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
