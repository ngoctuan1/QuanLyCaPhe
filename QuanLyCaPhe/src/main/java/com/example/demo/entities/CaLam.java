package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity()
@Entity
@Table(name = "CaLam")
public class CaLam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maCaLam")
	private String maCaLam;

	@Column(name = "tenCaLam")
	private String tenCaLam;

	private static int sId = 0;

	public CaLam(String maCaLam, String tenCaLam) {
		super();
		this.maCaLam = maCaLam;
		this.tenCaLam = tenCaLam;
	}

	public CaLam() {
		super();
		// TODO Auto-generated constructor stub
		sId++;
	}

	public String getMaCaLam() {
		return maCaLam;
	}

	public static String getStaticMaCaLam() {
		return Support.returnStringMaObject("CL", sId);
	}

	public void setMaCaLam(String maCaLam) {
		this.maCaLam = maCaLam;
	}

	public String getTenCaLam() {
		return tenCaLam;
	}

	public void setTenCaLam(String tenCaLam) {
		this.tenCaLam = tenCaLam;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Support.returnStringFormat(this.maCaLam, this.tenCaLam);
	}
}
