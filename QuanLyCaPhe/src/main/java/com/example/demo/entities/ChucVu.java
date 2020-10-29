package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "ChucVu")
public class ChucVu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maCV")
	private String maChucVu;

	@Column(name = "tenCV")
	private String tenChucVu;

	private static int sId = 0;

	public ChucVu(String maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}

	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaChucVu() {
		return maChucVu;
	}

	public static String getStaticMaChucVu() {
		return Support.returnStringMaObject("CV", sId);
	}

	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Support.returnStringFormat(maChucVu, tenChucVu);
	}
}
