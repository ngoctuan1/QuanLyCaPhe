package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "LichSuGia")
public class LichSuGia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maHH")
	private String maHH;

	@Column(name = "giaTienCu")
	private int giaTienCu;

	@Column(name = "giaTienMoi")
	private int giaTienMoi;

	@Column(name = "thoiGianThayDoi")
	private Date thoiGianThayDoi;

	public LichSuGia(String maHH, int giaTienCu, int giaTienMoi, Date thoiGianThayDoi) {
		super();
		this.maHH = maHH;
		this.giaTienCu = giaTienCu;
		this.giaTienMoi = giaTienMoi;
		this.thoiGianThayDoi = thoiGianThayDoi;
	}

	public LichSuGia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaHH() {
		return maHH;
	}

	public void setMaHH(String maHH) {
		this.maHH = maHH;
	}

	public int getGiaTienCu() {
		return giaTienCu;
	}

	public void setGiaTienCu(int giaTienCu) {
		this.giaTienCu = giaTienCu;
	}

	public int getGiaTienMoi() {
		return giaTienMoi;
	}

	public void setGiaTienMoi(int giaTienMoi) {
		this.giaTienMoi = giaTienMoi;
	}

	public Date getThoiGianThayDoi() {
		return thoiGianThayDoi;
	}

	public void setThoiGianThayDoi(Date thoiGianThayDoi) {
		this.thoiGianThayDoi = thoiGianThayDoi;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Support.returnStringFormat(maHH, giaTienCu + "", giaTienMoi + "",
				Support.convertDateToString(thoiGianThayDoi));
	}

}
