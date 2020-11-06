package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.TaiKhoan;

@Repository("taiKhoanRepository")
public interface TaiKhoanRepository extends BaseRepository<TaiKhoan> {

}
