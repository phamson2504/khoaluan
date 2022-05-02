package com.project.khoaluan.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.GheNgoi;

public interface GheNgoiDetailsService {
	public void addNgheNgoi(GheNgoi gheNgoi,int idPhong);
	List<GheNgoi> gheNgoiCuaSuat( int idSuat);
	List<GheNgoi> gheDaChon(int idSuat);
}
