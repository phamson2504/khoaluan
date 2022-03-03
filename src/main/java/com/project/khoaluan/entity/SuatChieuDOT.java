package com.project.khoaluan.entity;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.TheLoai;

public class SuatChieuDOT {
	private int id;
	private String gioBatDau;
	private String ngayChieu;
	private double giaVe;
	private Phim phim;
	private TheLoai theloai;
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
	public Phim getPhim() {
		return phim;
	}
	public void setPhim(Phim phim) {
		this.phim = phim;
	}
	public TheLoai getTheloai() {
		return theloai;
	}
	public void setTheloai(TheLoai theloai) {
		this.theloai = theloai;
	}
	


	public SuatChieuDOT(int id, String gioBatDau, String ngayChieu, double giaVe, Phim phim, TheLoai theloai) {
		super();
		this.id = id;
		this.gioBatDau = gioBatDau;
		this.ngayChieu = ngayChieu;
		this.giaVe = giaVe;
		this.phim = phim;
		this.theloai = theloai;
	}


	@Override
	public String toString() {
		return "SuatChieuDOT [id=" + id + ", gioBatDau=" + gioBatDau + ", ngayChieu=" + ngayChieu + ", giaVe=" + giaVe
				+ ", phim=" + phim + ", theloai=" + theloai + "]";
	}


	
	
	
}
