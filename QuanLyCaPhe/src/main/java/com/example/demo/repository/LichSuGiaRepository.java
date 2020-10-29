package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.LichSuGia;

@Repository("lichSuGiaRepository")
public interface LichSuGiaRepository extends SupRepository<LichSuGia> {

}
