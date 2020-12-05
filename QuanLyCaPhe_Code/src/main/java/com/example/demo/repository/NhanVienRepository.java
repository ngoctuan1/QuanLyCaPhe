package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.NhanVien;

@Repository("nhanVienRepository")
public interface NhanVienRepository extends BaseRepository<NhanVien> {

}
