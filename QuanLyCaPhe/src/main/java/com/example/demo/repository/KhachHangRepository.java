package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.KhachHang;

@Repository("khachHangRepository")
public interface KhachHangRepository extends BaseRepository<KhachHang> {

}
