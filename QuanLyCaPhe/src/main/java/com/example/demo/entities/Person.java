package com.example.demo.entities;

import java.util.Date;

public class Person {
	private String ma;
	private String ho;
	private String ten;
	private String diaChi;
	private String soDT;

	private Date ngaySinh;
	private int gioiTinh, trangThai;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
		ma = "";
		ho = "Nguyen";
		ten = "A";
		diaChi = "VN";
		soDT = "0123456789";

		ngaySinh = new Date(2020, 1, 1);
		gioiTinh = 0;
		trangThai = 1;
	}

	public Person(String ma, String ho, String ten, String diaChi, String soDT, Date ngaySinh, int gioiTinh,
			int trangThai) {
		super();
		this.ma = ma;
		this.ho = ho;
		this.ten = ten;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.trangThai = trangThai;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getGioiTinhInt() {
		return gioiTinh;
	}

	public String getGioiTinhString() {
		return (this.gioiTinh == 0) ? "Nữ" : "Nam";
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getTrangThaiInt() {
		return trangThai;
	}

	public String getTrangThaiString() {
		return (this.trangThai == 0) ? "Khóa" : "Kích hoạt";
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getHoTen() {
		return this.ho + " " + this.ten;
	}
}
