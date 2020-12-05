package com.example.demo.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class Person {

	final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaKH")
	private String maKH;

	@Column(name = "Ho")
	private String ho;

	@Column(name = "Ten")
	private String ten;

	@Column(name = "ngaySinh")
	private Date ngaySinh;

	@Column(name = "capDo")
	private int capDo;

	@Column(name = "diemTichLuy")
	private int diemTichLuy;

	@Column(name = "diaChi")
	private String diaChi;

	@Column(name = "gioiTinh")
	private int gioiTinh;

	@Column(name = "soDT")
	private String soDT;

	@Column(name = "trangThai")
	private int trangThai;

	private static int Ids = 0;

	public Person(String maKH, String ho, String ten, Date ngaySinh, int capDo, int diemTichLuy, String diaChi,
			int gioiTinh, String soDT, int trangThai) {
		this.maKH = maKH;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.capDo = capDo;
		this.diemTichLuy = diemTichLuy;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.trangThai = trangThai;
//		KhachHang.sId++;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub

		this.ho = "Nguyen";
		this.ten = "Test";
		this.ngaySinh = Calendar.getInstance().getTime();
		this.capDo = 0;
		this.diemTichLuy = 0;
		this.diaChi = "aa";
		this.gioiTinh = 0;
		this.trangThai = 0;
		this.soDT = "021";
		this.maKH = getStaticMaKH();
	}

	public String getMaKH() {
		return maKH;
	}

	public static String getStaticMaKH() {
		return Support.returnStringMaObject("KH", Ids);
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
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

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public String getTrangThaiString() {
		return Support.returnFromIntType(trangThai, 2);
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getCapDo() {
		return capDo;
	}

	public String getCapDoString() {
		return Support.returnFromIntType(capDo, 3);
	}

	public void setCapDo(int capDo) {
		this.capDo = capDo;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public String getGioiTinhString() {
		return Support.returnFromIntType(gioiTinh, 1);
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return Support.returnStringFormat(this.getMaKH(), getHo() + " " + getTen(), getGioiTinhString(), getDiaChi(),
				new SimpleDateFormat("dd/MM/yyyy").format(getNgaySinh()), getCapDoString(), getDiemTichLuy() + "",
				getTrangThaiString());
	}
}
