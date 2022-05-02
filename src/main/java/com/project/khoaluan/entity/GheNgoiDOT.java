package com.project.khoaluan.entity;

public class GheNgoiDOT {
	private int id;
	private String viTriHang;
	private int viTriCot;
	private boolean daDat;
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
	public boolean isDaDat() {
		return daDat;
	}
	public void setDaDat(boolean daDat) {
		this.daDat = daDat;
	}
	public GheNgoiDOT(int id, String viTriHang, int viTriCot, boolean daDat) {
		super();
		this.id = id;
		this.viTriHang = viTriHang;
		this.viTriCot = viTriCot;
		this.daDat = daDat;
	}
	public GheNgoiDOT() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GheNgoiDOT [id=" + id + ", viTriHang=" + viTriHang + ", viTriCot=" + viTriCot + ", daDat=" + daDat
				+ "]";
	}
	
	
}
