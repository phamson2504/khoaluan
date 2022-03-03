package com.project.khoaluan.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class SuatChieu {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
	private String gioBatDau;
	private LocalDate ngayChieu;
	private double giaVe;
	
	@ManyToOne
    @JoinColumn(name = "phim_id")
	private Phim phim;
	
	@ManyToOne
    @JoinColumn(name = "the_loai_id")
	private TheLoai theloai;
	
	
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
	
	public Phim getPhim() {
		return phim;
	}
	public void setPhim(Phim phim) {
		this.phim = phim;
	}
	public SuatChieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TheLoai getTheloai() {
		return theloai;
	}
	public void setTheloai(TheLoai theloai) {
		this.theloai = theloai;
	}
	
	
	
	public SuatChieu(int id, String gioBatDau, LocalDate ngayChieu, double giaVe, Phim phim, TheLoai theloai) {
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
		return "SuatChieu [id=" + id + ", gioBatDau=" + gioBatDau + ", ngayChieu=" + ngayChieu + ", giaVe=" + giaVe
				+ ", phim=" + phim + ", theloai=" + theloai + "]";
	}
	
	
	
	
	
	
	
	
}
