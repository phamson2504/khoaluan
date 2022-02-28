package com.project.khoaluan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GheNgoi {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
	private String viTriHang;
	private int viTriCot;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getViTriHang() {
		return viTriHang;
	}

	public void setViTriHang(String viTriHang) {
		this.viTriHang = viTriHang;
	}
	
	

	public int getViTriCot() {
		return viTriCot;
	}

	public void setViTriCot(int viTriCot) {
		this.viTriCot = viTriCot;
	}

	
	

	public GheNgoi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GheNgoi(String viTriHang, int viTriCot) {
		super();
		this.viTriHang = viTriHang;
		this.viTriCot = viTriCot;
		
	}

	@Override
	public String toString() {
		return "GheNgoi [id=" + id + ", viTriHang=" + viTriHang + ", viTriCot=" + viTriCot + "]";
	}

}
