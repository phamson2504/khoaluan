package com.project.khoaluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.HoaDonRepository;
import com.project.khoaluan.dao.KhuVucRepository;
import com.project.khoaluan.entity.LichSuDatVeDOT;
import com.project.khoaluan.model.HoaDon;
import com.project.khoaluan.model.NguoiDung;

@Service
public class HoaDonDetailsServiceImpl implements HoaDonDetailsService{
	@Autowired
	HoaDonRepository hoaDonRepository;
	

	@Override
	public HoaDon findHoaDon(int idHoaDon) {
		// TODO Auto-generated method stub
		return hoaDonRepository.findById(idHoaDon);
	}

	@Override
	public void addHoaDon(HoaDon hoaDon) {
		
		hoaDonRepository.save(hoaDon);
	}

	@Override
	public void deleteById(int id) {
		hoaDonRepository.deleteById(id);
		
	}

}
