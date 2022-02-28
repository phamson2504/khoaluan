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
public class Rap {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
	
	private String tenRap;
	
	private String diaChi;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JoinColumn(name = "rap_id")
	 List<Phong> phongs;
	
	

	public List<Phong> getPhongs() {
		return phongs;
	}

	public void setPhongs(List<Phong> phongs) {
		this.phongs = phongs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenRap() {
		return tenRap;
	}

	public void setTenRap(String tenRap) {
		this.tenRap = tenRap;
	}

	

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Rap(int id, String tenRap, String diaChi, List<Phong> phongs) {
		super();
		this.id = id;
		this.tenRap = tenRap;
		this.diaChi = diaChi;
		this.phongs = phongs;
	}

	public Rap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phong getPhong(int id) {
		if(phongs !=null) {
			for (Phong phong : phongs) {
				if (phong.getId()==id) {
					return phong;
				}
			}
				
		}
		return null;
	}
	public void addPhong(Phong phong){
        if (phongs == null) {
            phongs = new ArrayList<>();
        }
        phongs.add(phong);
    }

	@Override
	public String toString() {
		return "Rap [id=" + id + ", tenRap=" + tenRap + ", diaChi=" + diaChi + ", phongs=" + phongs + "]";
	}

	
	
	
	
	
}
