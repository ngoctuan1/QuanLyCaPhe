package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.CongNo;

@Repository("congNoRepository")
public interface CongNoRepository extends BaseRepository<CongNo> {

}
