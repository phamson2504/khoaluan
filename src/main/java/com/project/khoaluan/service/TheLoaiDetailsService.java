package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.TheLoai;

public interface TheLoaiDetailsService {
	public void addTheLoai(TheLoai theLoai);
	public void deleteTheLoai(int idTheLoai);
	public TheLoai findTheLoai(int id);
	public List<TheLoai> getTheLoais();
	List<TheLoai> TheLoaiCuaPhim(int idPhim,LocalDate startDate,int idKv);
	List<TheLoai> TheLoaiCuaRap(@Param("startDate") LocalDate startDate,@Param("idRap") int idRap);
}
