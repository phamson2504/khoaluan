package com.project.khoaluan.entity;

import java.time.LocalDate;

public class LichSuDatVeDOT {
	private int id;
	private String tenPhim;
	private String tenRap;
	private String tenPhong;
	private String ngayDatVe;
	private String ngayChieu;
	private String gioChieu;
	private double giaVe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public String getTenRap() {
		return tenRap;
	}
	public void setTenRap(String tenRap) {
		this.tenRap = tenRap;
	}
	
	public String getNgayDatVe() {
		return ngayDatVe;
	}
	public void setNgayDatVe(String ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}
	public double getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}
	
	public String getGioChieu() {
		return gioChieu;
	}
	public void setGioChieu(String gioChieu) {
		this.gioChieu = gioChieu;
	}
	
	public String getNgayChieu() {
		return ngayChieu;
	}
	public void setNgayChieu(String ngayChieu) {
		this.ngayChieu = ngayChieu;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public LichSuDatVeDOT(int id, String tenPhim, String tenRap, String tenPhong, String ngayDatVe, String ngayChieu,
			String gioChieu, double giaVe) {
		super();
		this.id = id;
		this.tenPhim = tenPhim;
		this.tenRap = tenRap;
		this.tenPhong = tenPhong;
		this.ngayDatVe = ngayDatVe;
		this.ngayChieu = ngayChieu;
		this.gioChieu = gioChieu;
		this.giaVe = giaVe;
	}
	@Override
	public String toString() {
		return "LichSuDatVeDOT [id=" + id + ", tenPhim=" + tenPhim + ", tenRap=" + tenRap + ", tenPhong=" + tenPhong
				+ ", ngayDatVe=" + ngayDatVe + ", ngayChieu=" + ngayChieu + ", gioChieu=" + gioChieu + ", giaVe="
				+ giaVe + "]";
	}
	
	
	
	
}
