package com.project.khoaluan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.khoaluan.entity.LichSuDatVeDOT;
import com.project.khoaluan.model.HoaDon;
import com.project.khoaluan.model.Phim;

public interface HoaDonRepository extends CrudRepository<HoaDon,Integer>{
	HoaDon findById(int id);
	void deleteById(int id); 
		
}
