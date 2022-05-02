package com.project.khoaluan.entity;

import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.TheLoai;

public class SuatChieuSuaDOT {
	private int id;
	private String gioBatDau;
	private String ngayChieu;
	private double giaVe;
	private int idPhim;
	private int idPhong;
	private int idtheloai;
	public String getGioBatDau() {
		return gioBatDau;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setGioBatDau(String gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	public String getNgayChieu() {
		return ngayChieu;
	}
	public void setNgayChieu(String ngayChieu) {
		this.ngayChieu = ngayChieu;
	}
	
	public double getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}
	
	
	


	public int getIdPhim() {
		return idPhim;
	}


	public void setIdPhim(int idPhim) {
		this.idPhim = idPhim;
	}


	public int getIdPhong() {
		return idPhong;
	}


	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}


	public int getIdtheloai() {
		return idtheloai;
	}


	public void setIdtheloai(int idtheloai) {
		this.idtheloai = idtheloai;
	}


	
	


	public SuatChieuSuaDOT(int id, String gioBatDau, String ngayChieu, double giaVe, int idPhim, int idPhong,
			int idtheloai) {
		super();
		this.id = id;
		this.gioBatDau = gioBatDau;
		this.ngayChieu = ngayChieu;
		this.giaVe = giaVe;
		this.idPhim = idPhim;
		this.idPhong = idPhong;
		this.idtheloai = idtheloai;
	}


	@Override
	public String toString() {
		return "SuatChieuSuaDOT [id=" + id + ", gioBatDau=" + gioBatDau + ", ngayChieu=" + ngayChieu + ", giaVe="
				+ giaVe + ", idPhim=" + idPhim + ", idPhong=" + idPhong + ", idtheloai=" + idtheloai + "]";
	}


	


	


}
