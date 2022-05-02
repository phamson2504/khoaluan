package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.model.SuatChieu;

public interface SuatChieuDetailsService {
	public void AddSuatChieu(SuatChieu suatChieu,int idTheLoai,int idRoom);
	public List<ChiTietSuat> chiTietSuatTheoPhim(int idPhim);
	public void XoaSuatChieu(int idSc);
	public void UpdateSuatChieu(SuatChieu suatChieu,int idTheLoai,int idRoom);
	List<ChiTietSuat> suatChieuCuaPhim(int idPhim,LocalDate startDate,int idKV,int idTL);
	LocalDate ngayChieuGannhat( LocalDate startDate , int idPhim);
	List<ChiTietSuat> suatChieuCuaRap(int idRap,LocalDate startDate,int idTL);
	ChiTietSuat ChiTietSuatChieu(int id);
	SuatChieu findSuatChieu(int idSuat);
	
}
