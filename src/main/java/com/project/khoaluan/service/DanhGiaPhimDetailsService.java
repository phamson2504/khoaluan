package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.DanhGiaPhim;
import com.project.khoaluan.model.SuatChieu;

public interface DanhGiaPhimDetailsService {
	List<SuatChieu> suatChieu(int idNd,int idPhim);
	DanhGiaPhim timDanhGia(int idNd,int idPhim);
	void saveDanhGia(int idNd,int idPhim,int soSao);
	void updateDanhGia(int id,int idNd, int idPhim, int soSao);
	List<DanhGiaPhim> allDanhGiaPhim( int idPhim);

}
