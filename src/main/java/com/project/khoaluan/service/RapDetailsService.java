package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.Rap;

public interface RapDetailsService {
	public void addRap(Rap rap,int idKhuVuc);
	public void updateRap(Rap rap,int idKhuVuc);
	public List<Rap> getRaps();
	public Rap findRap(int id);
	public void XoaRap(int id);
	List<Rap> rapCuaPhim( int idPhim, LocalDate startDate, int idKV, int idTL);
	List<Rap> rapCuaLichRap(LocalDate startDate,int idKV);
}
