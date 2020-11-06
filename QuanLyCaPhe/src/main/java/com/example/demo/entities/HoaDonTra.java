package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "hoaDonTraHang")
public class HoaDonTra implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

//	Mã Phiếu Trả, Mã NCC, Mã NV, Ngày Trả, Danh Sách Sản phẩm lỗi( Mã SP, Tên SP, Số Lượng, Đơn giá, Nội dung trả)
	@Id
	@Column(name = "maTH")
	private String maTH;

	@Column(name = "MaNH")
	private String maNH;

	@Column(name = "maNV")
	private String maNV;

	@Column(name = "maNCC")
	private String maNCC;

	@Column(name = "ngayTra")
	private Date ngayTra;

	@Column(name = "trangThai")
	private int trangThai;

	private static int sId = 0;

	public HoaDonTra(String maTH, String maNH, String maNV, String maNCC, Date ngayTra, int trangThai) {
		super();
		this.maTH = maTH;
		this.maNH = maNH;
		this.maNV = maNV;
		this.maNCC = maNCC;
		this.ngayTra = ngayTra;
		this.trangThai = trangThai;
	}

	public HoaDonTra() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaTH() {
		return maTH;
	}

	public static String getStaticMaTH() {
		return Support.returnStringMaObject("TH", sId);
	}

	public void setMaTH(String maTH) {
		this.maTH = maTH;
	}

	public String getMaNH() {
		return maNH;
	}

	public void setMaNH(String maNH) {
		this.maNH = maNH;
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

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
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
		return Support.returnStringFormat(maTH, maNH, maNV, maNCC, Support.convertDateToString(ngayTra),
				getTrangThaiString());
	}
}
