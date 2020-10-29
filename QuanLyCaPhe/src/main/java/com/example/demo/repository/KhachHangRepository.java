package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.KhachHang;

public interface KhachHangRepository extends CrudRepository<KhachHang, String> {

}
