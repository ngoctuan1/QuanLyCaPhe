package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "chuongTrinhKhuyenMai")
public class ChuongTrinhKhuyenMai implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maKM")
	private String maKM;

	@Column(name = "noiDung")
	private String noiDung;

	@Column(name = "thoiGianBatDau")
	private Date thoiGianBatDau;

	@Column(name = "thoiGianKetThuc")
	private Date thoiGianKetThuc;

	private static int sId = 0;

	public ChuongTrinhKhuyenMai(String maKM, String noiDung, Date thoiGianBatDau, Date thoiGianKetThuc) {
		super();
		this.maKM = maKM;
		this.noiDung = noiDung;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public ChuongTrinhKhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaKM() {
		return maKM;
	}

	public static String getStaticMaKM() {
		return Support.returnStringMaObject("KM", sId);
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Support.returnStringFormat(maKM, noiDung,Support.convertDateToString(thoiGianBatDau),Support.convertDateToString(thoiGianKetThuc));
	}

}
