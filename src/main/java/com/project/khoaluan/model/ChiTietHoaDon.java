package com.project.khoaluan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ChiTietHoaDon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
	
	private double gia;
	
	@ManyToOne
    @JoinColumn(name = "suat_chieu_id")
	private SuatChieu suatChieu;
	
	@ManyToOne
    @JoinColumn(name = "ghe_ngoi_id")
	private GheNgoi gheNgoi;
	
	@ManyToOne
    @JoinColumn(name = "hoa_don_id")
	private HoaDon hoaDon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public SuatChieu getSuatChieu() {
		return suatChieu;
	}

	public void setSuatChieu(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
	}

	public GheNgoi getGheNgoi() {
		return gheNgoi;
	}

	public void setGheNgoi(GheNgoi gheNgoi) {
		this.gheNgoi = gheNgoi;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public ChiTietHoaDon(double gia, SuatChieu suatChieu, GheNgoi gheNgoi, HoaDon hoaDon) {
		super();
		this.gia = gia;
		this.suatChieu = suatChieu;
		this.gheNgoi = gheNgoi;
		this.hoaDon = hoaDon;
	}
	
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [id=" + id + ", gia=" + gia + ", suatChieu=" + suatChieu + ", gheNgoi=" + gheNgoi
				+ ", hoaDon=" + hoaDon + "]";
	}
		
}
