package com.project.khoaluan.entity;

public class DanhGiaPhimDOT {
	private int soLuong;
	private double saoTB;
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public double getSaoTB() {
		return saoTB;
	}
	public void setSaoTB(double saoTB) {
		this.saoTB = saoTB;
	}
	
	public DanhGiaPhimDOT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DanhGiaPhimDOT(int soLuong, double saoTB) {
		super();
		this.soLuong = soLuong;
		this.saoTB = saoTB;
	}
	@Override
	public String toString() {
		return "DanhGiaPhimDOT [soLuong=" + soLuong + ", saoTB=" + saoTB + "]";
	}

}
