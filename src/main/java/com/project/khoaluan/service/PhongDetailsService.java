package com.project.khoaluan.service;

import com.project.khoaluan.model.Phong;

public interface PhongDetailsService {
	public void addPhong(Phong phong,int idRap);
	public void updatePhong(Phong phong,int idRap);
	public Phong findPhong(int id);
	public void xoaPhong(int id);
}
