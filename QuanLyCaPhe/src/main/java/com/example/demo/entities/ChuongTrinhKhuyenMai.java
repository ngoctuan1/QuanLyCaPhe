package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "chuongTrinhKhuyenMai")
public class ChuongTrinhKhuyenMai implements Serializable{
	
	@Id
	@Column(name = "maKM")
	private String maKM;
	
	private String noiDung;
	
}
