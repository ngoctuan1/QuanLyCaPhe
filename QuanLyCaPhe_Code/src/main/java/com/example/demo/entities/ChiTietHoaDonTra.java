package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "chiTietHoaDonTra")
public class ChiTietHoaDonTra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maTH")
	private String maTH;

	@Column(name = "maSP")
	private String maSP;

	@Column(name = "tenSP")
	private String tenSP;

	@Column(name = "soLuong")
	private int soLuong;

	@Column(name = "noiDungTra")
	private String noiDungTra;

	@Column(name = "donGia")
	private int donGia;

	public ChiTietHoaDonTra(String maTH, String maSP, String tenSP, int soLuong, String noiDungTra, int donGia) {
		super();
		this.maTH = maTH;
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.noiDungTra = noiDungTra;
		this.donGia = donGia;
	}

	public ChiTietHoaDonTra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaTH() {
		return maTH;
	}

	public void setMaTH(String maTH) {
		this.maTH = maTH;
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

	public String getNoiDungTra() {
		return noiDungTra;
	}

	public void setNoiDungTra(String noiDungTra) {
		this.noiDungTra = noiDungTra;
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
		return Support.returnStringFormat(maTH, maSP, tenSP, soLuong + "", noiDungTra, donGia + "");
	}
}
