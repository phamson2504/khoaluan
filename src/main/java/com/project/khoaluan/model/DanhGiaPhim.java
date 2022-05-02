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
public class DanhGiaPhim {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
	
	private int soSao;
	
	@ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
	private NguoiDung nguoiDung;
	
	@ManyToOne
    @JoinColumn(name = "phim_id")
	private Phim phim;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoSao() {
		return soSao;
	}

	public void setSoSao(int soSao) {
		this.soSao = soSao;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

	public DanhGiaPhim(int id, int soSao, NguoiDung nguoiDung, Phim phim) {
		super();
		this.id = id;
		this.soSao = soSao;
		this.nguoiDung = nguoiDung;
		this.phim = phim;
	}
	public DanhGiaPhim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DanhGiaPhim(int soSao, NguoiDung nguoiDung, Phim phim) {
		this.soSao = soSao;
		this.nguoiDung = nguoiDung;
		this.phim = phim;
	}

	@Override
	public String toString() {
		return "DanhGiaPhim [id=" + id + ", soSao=" + soSao + ", nguoiDung=" + nguoiDung + ", phim=" + phim + "]";
	}
	
	
}
