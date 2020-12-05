package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.HoaDonBan;
import com.example.demo.repository.HoaDonBanRepository;

@Service("hoaDonBanService")
@Transactional
public class HoaDonBanServiceImp implements BaseService<HoaDonBan> {

	@Autowired
	HoaDonBanRepository repo;

	@Override
	public Iterable<HoaDonBan> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<HoaDonBan> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(HoaDonBan p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
