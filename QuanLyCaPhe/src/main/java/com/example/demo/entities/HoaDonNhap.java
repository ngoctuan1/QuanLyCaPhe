package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "hoaDonNhapHang")
public class HoaDonNhap implements Serializable {
//	 Mã Hóa Đơn, Mã NCC, Tên NCC, Tên NV, Thời Gian Nhập Hàng, Danh sách sản phẩm (Tên SP, Số Lượng, Đơn Giá(1 sp), Tổng Tiền(1sp x s.lượng)), Tổng Tiền HĐ

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maHD")
	private String maHD;

	@Column(name = "MaNCC")
	private String maNCC;

	@Column(name = "MaNV")
	private String maNV;

	@Column(name = "ngayNhapHang")
	private Date ngayNhapHang;

	@Column(name = "tongTien")
	private int tongTien;

	@Column(name = "trangThai")
	private int trangThai;

	private static int sId = 0;

	public HoaDonNhap(String maHD, String maNCC, String maNV, Date ngayBanHang, int tongTien, int trangThai) {
		super();
		this.maHD = maHD;
		this.maNCC = maNCC;
		this.maNV = maNV;
		this.ngayNhapHang = ngayBanHang;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}

	public HoaDonNhap() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaHD() {
		return maHD;
	}

	public static String getStaticMaHD() {
		return Support.returnStringMaObject("NH", sId);
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayBanHang() {
		return ngayNhapHang;
	}

	public void setNgayBanHang(Date ngayBanHang) {
		this.ngayNhapHang = ngayBanHang;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
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
		return Support.returnStringFormat(maHD, maNCC, maNV, Support.convertDateToString(ngayNhapHang), tongTien + "");
	}
}
