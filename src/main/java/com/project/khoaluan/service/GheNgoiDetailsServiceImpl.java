package com.project.khoaluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.GheNgoiRepository;
import com.project.khoaluan.dao.PhongRepository;
import com.project.khoaluan.model.GheNgoi;
import com.project.khoaluan.model.Phong;

@Service
public class GheNgoiDetailsServiceImpl implements GheNgoiDetailsService{
	@Autowired
	GheNgoiRepository gheNgoiRepository;
	@Autowired
	PhongRepository phongRepository;
	public void addNgheNgoi(GheNgoi gheNgoi,int idPhong) {
		Phong phong = phongRepository.findById(idPhong);
		phong.addGheNgoi(gheNgoi);
		gheNgoiRepository.save(gheNgoi);
	}
}
