package com.project.khoaluan.model;

import java.time.LocalDate;
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
public class HoaDon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
	
	@ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
	private NguoiDung nguoiDung;
	
	private LocalDate ngayLap;
	
	@OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTHDs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public HoaDon(NguoiDung nguoiDung, LocalDate ngayLap) {
		this.nguoiDung = nguoiDung;
		this.ngayLap = ngayLap;
	}
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HoaDon(int id, NguoiDung nguoiDung, LocalDate ngayLap) {
		super();
		this.id = id;
		this.nguoiDung = nguoiDung;
		this.ngayLap = ngayLap;
	}

	@Override
	public String toString() {
		return "HoaDon [id=" + id + ", nguoiDung=" + nguoiDung + ", ngayLap=" + ngayLap + ", chiTHDs=" + chiTHDs + "]";
	}
}
