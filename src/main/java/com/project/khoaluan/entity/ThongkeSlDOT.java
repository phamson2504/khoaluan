package com.project.khoaluan.entity;

public class ThongkeSlDOT {
	private long soLuong;
	private String string;
	public long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public ThongkeSlDOT(long soLuong, String string) {
		super();
		this.soLuong = soLuong;
		this.string = string;
	}
	@Override
	public String toString() {
		return "ThongkeSlDOT [soLuong=" + soLuong + ", string=" + string + "]";
	}
	
	
	
}
