package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "CongNo")
public class CongNo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maCN")
	private String maCN;

	@Column(name = "maNCC")
	private String maNCC;

	@Column(name = "ngayGhiNo")
	private Date ngayGhiNo;

	@Column(name = "noiDung")
	private String noiDung;

	@Column(name = "trangThai")
	private int trangThai;

	private static int sId = 0;

	public CongNo(String maCN, String maNCC, Date ngayGhiNo, String noiDung, int trangThai) {
		super();
		this.maCN = maCN;
		this.maNCC = maNCC;
		this.ngayGhiNo = ngayGhiNo;
		this.noiDung = noiDung;
		this.trangThai = trangThai;
	}

	public CongNo() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaCN() {
		return maCN;
	}

	public static String getStaticMaCN() {
		return Support.returnStringMaObject("CN", sId);
	}

	public void setMaCN(String maCN) {
		this.maCN = maCN;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public Date getNgayGhiNo() {
		return ngayGhiNo;
	}

	public void setNgayGhiNo(Date ngayGhiNo) {
		this.ngayGhiNo = ngayGhiNo;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public String getTrangThaiString() {
		return Support.returnFromIntType(trangThai, 2 );
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Support.returnStringFormat(maCN, maNCC, Support.convertDateToString(ngayGhiNo), noiDung,getTrangThaiString());
	}

}
