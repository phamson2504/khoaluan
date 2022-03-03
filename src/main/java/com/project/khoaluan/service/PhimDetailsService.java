package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.SuatChieu;

public interface PhimDetailsService {
	public void LuuPhim(Phim phim);
	public List<Phim> getPhims();
	public Phim getPhimId(int id);
	public void xoaPhim(int id);
	public List<Phim> loadPhim(LocalDate startDate);
	public List<Phim> phimSapChieu(LocalDate startDate);
	List<Phim> PhimsCuaRap(LocalDate startDate,int idRap,int idTl);
}
