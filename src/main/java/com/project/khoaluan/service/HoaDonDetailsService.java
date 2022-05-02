package com.project.khoaluan.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.entity.LichSuDatVeDOT;
import com.project.khoaluan.model.HoaDon;
import com.project.khoaluan.model.NguoiDung;

public interface HoaDonDetailsService {
	public void addHoaDon(HoaDon hoaDon);
	public HoaDon findHoaDon(int idHoaDon);
	public void deleteById(int id);
	
}
