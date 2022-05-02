package com.project.khoaluan.entity;

public class ThongKeDOT {
	private double gia;
	private String string;
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public ThongKeDOT(double gia, String string) {
		super();
		this.gia = gia;
		this.string = string;
	}
	@Override
	public String toString() {
		return "ThongKeDOT [gia=" + gia + ", string=" + string + "]";
	}
	
	
}
