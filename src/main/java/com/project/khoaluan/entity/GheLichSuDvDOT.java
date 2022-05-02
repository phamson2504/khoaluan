package com.project.khoaluan.entity;

public class GheLichSuDvDOT {
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
	public GheLichSuDvDOT(int id, String viTriHang, int viTriCot) {
		super();
		this.id = id;
		this.viTriHang = viTriHang;
		this.viTriCot = viTriCot;
	}
	@Override
	public String toString() {
		return "GheLichSuDvDOT [id=" + id + ", viTriHang=" + viTriHang + ", viTriCot=" + viTriCot + "]";
	}
	
	
}
