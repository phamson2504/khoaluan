package com.project.khoaluan.entity;

import java.time.LocalDate;
import java.util.List;

import com.project.khoaluan.model.Rap;

public class ChiTietSuat {
	private int id;
	private String gioBatDau;
	private LocalDate ngayChieu;
	private double giaVe;
	private int idRap;
	private String tenRap;
	private int idPhong;
	private int idPhim;
	private String tenPhim;
	private String theLoai;
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGioBatDau() {
		return gioBatDau;
	}
	public void setGioBatDau(String gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	
	public LocalDate getNgayChieu() {
		return ngayChieu;
	}
	public void setNgayChieu(LocalDate ngayChieu) {
		this.ngayChieu = ngayChieu;
	}
	public double getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}
	public int getIdRap() {
		return idRap;
	}
	public void setIdRap(int idRap) {
		this.idRap = idRap;
	}
	public String getTenRap() {
		return tenRap;
	}
	public void setTenRap(String tenRap) {
		this.tenRap = tenRap;
	}
	public int getIdPhong() {
		return idPhong;
	}
	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}
	public int getIdPhim() {
		return idPhim;
	}
	public void setIdPhim(int idPhim) {
		this.idPhim = idPhim;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	
	
	public ChiTietSuat(int id, String gioBatDau, LocalDate ngayChieu, double giaVe, int idRap,
			String tenRap, int idPhong, int idPhim, String tenPhim, String theLoai) {
		super();
		this.id = id;
		this.gioBatDau = gioBatDau;
		this.ngayChieu = ngayChieu;
		this.giaVe = giaVe;
		this.idRap = idRap;
		this.tenRap = tenRap;
		this.idPhong = idPhong;
		this.idPhim = idPhim;
		this.tenPhim = tenPhim;
		this.theLoai = theLoai;
	
	}
	public ChiTietSuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTietSuat [id=" + id + ", gioBatDau=" + gioBatDau + ", ngayChieu=" + ngayChieu + ", giaVe=" + giaVe + ", idRap=" + idRap + ", tenRap=" + tenRap + ", idPhong=" + idPhong
				+ ", idPhim=" + idPhim + ", tenPhim=" + tenPhim + ", theLoai=" + theLoai + "]";
	}
	
	

}
