package com.example.demo.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "tblnhanvien")
public class NhanVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaNV")
	private String maNV;

	@Column(name = "Ho")
	private String ho;

	@Column(name = "Ten")
	private String ten;

	@Column(name = "ngaySinh")
	private Date ngaySinh;

	@Column(name = "maCL")
	private String maCaLam;

	@Column(name = "maCV")
	private String maChucVu;

	@Column(name = "diaChi")
	private String diaChi;

	@Column(name = "gioiTinh")
	private int gioiTinh;

	@Column(name = "soDT")
	private String soDT;

	@Column(name = "trangThai")
	private int trangThai;

	private static int sId = 0;

	public NhanVien(String maKH, String ho, String ten, Date ngaySinh, int capDo, int diemTichLuy, String diaChi,
			int gioiTinh, String soDT, int trangThai) {
		super();
		this.maNV = maKH;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.trangThai = trangThai;
//		NhanVien.sId++;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
		NhanVien.sId++;
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

	public String getMaNV() {
		return maNV;
	}
	public static String getStaticMaNV() {
		return Support.returnStringMaObject("NV", sId);
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaCaLam() {
		return maCaLam;
	}

	public void setMaCaLam(String maCaLam) {
		this.maCaLam = maCaLam;
	}

	public String getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return Support.returnStringFormat(this.getMaNV(), getHo() + " " + getTen(), getGioiTinhString(), getDiaChi(),
				new SimpleDateFormat("dd/MM/yyyy").format(getNgaySinh()), getTrangThaiString());
	}

}
