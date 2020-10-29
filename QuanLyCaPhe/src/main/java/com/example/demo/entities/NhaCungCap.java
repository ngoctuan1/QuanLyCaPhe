package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "NhaCungCap")
public class NhaCungCap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maNCC")
	private String maNCC;

	@Column(name = "tenNCC")
	private String tenNCC;

	@Column(name = "email")
	private String email;

	@Column(name = "diaChi")
	private String diaChi;

	private static int sId = 0;

	public NhaCungCap(String maNCC, String tenNCC, String email, String diaChi) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.email = email;
		this.diaChi = diaChi;

	}

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public static String getStaticMaNCC() {
		return Support.returnStringMaObject("NCC", sId);
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Support.returnStringFormat(maNCC, tenNCC, diaChi, email);
	}
}
