package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChiTietHoaDonBan;
import com.example.demo.repository.ChiTietHoaDonBanRepository;

@Service("chiTietHoaDonBanService")
@Transactional
public class ChiTietHoaDonBanServiceImp implements BaseService<ChiTietHoaDonBan> {

	@Autowired
	ChiTietHoaDonBanRepository repo;

	@Override
	public Iterable<ChiTietHoaDonBan> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ChiTietHoaDonBan> find(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void save(ChiTietHoaDonBan p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
