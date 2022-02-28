package com.project.khoaluan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Phong {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private int id;
	private String tenPhong;
	private int hang;
	private int cot;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "phong_id")
	List<SuatChieu> suats;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "phong_id")
	List<GheNgoi> gheNgois;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHang() {
		return hang;
	}
	public void setHang(int hang) {
		this.hang = hang;
	}
	public int getCot() {
		return cot;
	}
	public void setCot(int cot) {
		this.cot = cot;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	
	public List<SuatChieu> getSuats() {
		return suats;
	}
	public void setSuats(List<SuatChieu> suats) {
		this.suats = suats;
	}
	
	public List<GheNgoi> getGheNgois() {
		return gheNgois;
	}
	public void setGheNgois(List<GheNgoi> gheNgois) {
		this.gheNgois = gheNgois;
	}
	
	
	public Phong(int id, String tenPhong, int hang, int cot, List<SuatChieu> suats, List<GheNgoi> gheNgois) {
		super();
		this.id = id;
		this.tenPhong = tenPhong;
		this.hang = hang;
		this.cot = cot;
		this.suats = suats;
		this.gheNgois = gheNgois;
	}
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuatChieu getSuatChieu(int id) {
		if(suats !=null) {
			for (SuatChieu suat : suats) {
				if (suat.getId()==id) {
					return suat;
				}
			}	
		}
		return null;
	}
	
	public void addSuat(SuatChieu  suatChieu){
        if (suats == null) {
            suats = new ArrayList<>();
        }
        suats.add(suatChieu);
    }
	
	public GheNgoi getGheNgoi(int id) {
		if(gheNgois !=null) {
			for (GheNgoi gheNgoi : gheNgois) {
				if (gheNgoi.getId()==id) {
					return gheNgoi;
				}
			}	
		}
		return null;
	}
	
	
	public void addGheNgoi(GheNgoi ngheNgoi){
        if (gheNgois == null) {
            gheNgois = new ArrayList<>();
        }
        gheNgois.add(ngheNgoi);
    }
	@Override
	public String toString() {
		return "Phong [id=" + id + ", tenPhong=" + tenPhong + ", hang=" + hang + ", cot=" + cot + "]";
	}

	
	
	
	
	
	
}
