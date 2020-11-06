package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.HoaDonBan;

@Repository("hoaDonBanRepository")
public interface HoaDonBanRepository extends BaseRepository<HoaDonBan> {

}
