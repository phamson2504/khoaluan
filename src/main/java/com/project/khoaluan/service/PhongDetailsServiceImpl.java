package com.project.khoaluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.PhongRepository;
import com.project.khoaluan.dao.RapRepository;
import com.project.khoaluan.model.Phong;
import com.project.khoaluan.model.Rap;

@Service
public class PhongDetailsServiceImpl {
	@Autowired
	PhongRepository phongRepository;
	@Autowired
	RapRepository rapRepository;
	
	public void addPhong(Phong phong,int idRap) {
		Rap rap = rapRepository.findById(idRap);
		rap.addPhong(phong);;
		phongRepository.save(phong);
	}
	public void updatePhong(Phong phong,int idRap) {
		Rap rap = rapRepository.findById(idRap);
		Phong tempPhong = rap.getPhong(phong.getId());
		tempPhong.setTenPhong(phong.getTenPhong());
		tempPhong.setCot(phong.getCot());
		tempPhong.setHang(phong.getHang());
		phongRepository.save(tempPhong);
	}
	public Phong findPhong(int id) {
		return phongRepository.findById(id);
	}
	public void xoaPhong(int id) {
		phongRepository.deleteById(id);
	}
}
