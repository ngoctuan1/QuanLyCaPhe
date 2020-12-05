package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "hoaDonDatHang")
public class HoaDonDat implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	 Mã Đặt hàng, Mã NCC, Danh sách sản phẩm( Mã SP, Tên SP, Số lượng, Đơn giá)
	@Id
	@Column(name = "maDH")
	private String maDH;

	@Column(name = "maNV")
	private String maNV;

	@Column(name = "maNCC")
	private String maNCC;

	@Column(name = "ngayDatHang")
	private Date ngayDatHang;

	@Column(name = "trangThai")
	private int trangThai;

	private static int sId = 0;

	public HoaDonDat(String maDH, String maNV, String maNCC, Date ngayDatHang, int trangThai) {
		super();
		this.maDH = maDH;
		this.maNV = maNV;
		this.maNCC = maNCC;
		this.ngayDatHang = ngayDatHang;
		this.trangThai = trangThai;
	}

	public HoaDonDat() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaDH() {
		return maDH;
	}

	public static String getStaticMaDH() {
		return Support.returnStringMaObject("DH", sId);
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
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
		return Support.returnStringFormat(maDH, maNV, maNCC, Support.convertDateToString(ngayDatHang),
				getTrangThaiString());
	}
}
