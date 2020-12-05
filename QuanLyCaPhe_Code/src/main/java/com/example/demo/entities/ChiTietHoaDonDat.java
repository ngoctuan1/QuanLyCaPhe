package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "chiTietHoaDonDat")
public class ChiTietHoaDonDat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maDH")
	private String maDH;

	@Column(name = "maSP")
	private String maSP;

	@Column(name = "tenSP")
	private String tenSP;

	@Column(name = "soLuong")
	private int soLuong;

	@Column(name = "donGia")
	private int donGia;

	public ChiTietHoaDonDat(String maDH, String maSP, String tenSP, int soLuong, int donGia) {
		super();
		this.maDH = maDH;
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public ChiTietHoaDonDat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Support.returnStringFormat(maDH, maSP, tenSP, soLuong + "", donGia + "");
	}
}
