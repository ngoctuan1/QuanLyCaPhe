package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "hoaDonBanHang")
public class HoaDonBan implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	 Mã Hóa đơn, Mã KH, Mã NV, Ngày Bán Hàng, Điểm tích lũy đã được tăng,Tổng tiền.

	@Id
	@Column(name = "maHD")
	private String maHD;

	@Column(name = "MaKH")
	private String maKH;

	@Column(name = "MaNV")
	private String maNV;

	@Column(name = "ngayBanHang")
	private Date ngayBanHang;

	@Column(name = "diemTichLuy")
	private int diemTichLuy;

	@Column(name = "tongTien")
	private int tongTien;

	@Column(name = "trangThai")
	private int trangThai;

	private static int sId = 0;

	public HoaDonBan(String maHD, String maKH, String maNV, Date ngayBanHang, int diemTichLuy, int tongTien) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayBanHang = ngayBanHang;
		this.diemTichLuy = diemTichLuy;
		this.tongTien = tongTien;
	}

	public HoaDonBan() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaHD() {
		return maHD;
	}

	public static String getStaticMaHD() {
		return Support.returnStringMaObject("BH", sId);
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayBanHang() {
		return ngayBanHang;
	}

	public void setNgayBanHang(Date ngayBanHang) {
		this.ngayBanHang = ngayBanHang;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
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
		return Support.returnStringFormat(maHD, maKH, maNV, Support.convertDateToString(ngayBanHang), diemTichLuy + "",
				tongTien + "");
	}
}
