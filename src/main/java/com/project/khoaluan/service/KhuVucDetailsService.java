package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.KhuVuc;

public interface KhuVucDetailsService {
	public void addKhuVuc(KhuVuc khuVuc);
	public List<KhuVuc> getKhuVucs();
	public KhuVuc findKhuVuc(int id);
	public void deleteKhuVuc(int id);
	List<KhuVuc> KhuVucCuaPhim(int idPhim,LocalDate startDate);
	List<KhuVuc> KhuVucCuaRap(LocalDate startDateL);
}
