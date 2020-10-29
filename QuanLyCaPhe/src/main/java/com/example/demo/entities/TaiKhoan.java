package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "taiKhoan")
public class TaiKhoan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maTK")
	private String maTk;

	@Column(name = "MaNV")
	private String tenDN;

	@Column(name = "matKhau")
	private String matKhau;

	@Column(name = "quyen")
	private int quyen;

	@Column(name = "trangThai")
	private int trangThai;

	private static int sId = 0;

	public TaiKhoan(String maTk, String tenDN, String matKhau, int quyen) {
		super();
		this.maTk = maTk;
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaTk() {
		return maTk;
	}

	public static String getStaticMaTk() {
		return Support.returnStringMaObject("TK", sId);
	}

	public void setMaTk(String maTk) {
		this.maTk = maTk;
	}

	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getQuyen() {
		return quyen;
	}

	public String getQuyenString() {
		return Support.returnFromIntType(quyen, 4);
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
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
		return Support.returnStringFormat(maTk, tenDN, matKhau, getQuyenString(), getTrangThaiString());
	}

}
