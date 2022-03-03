package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.PhimRepository;
import com.project.khoaluan.model.Phim;


@Service
public class PhimDetailsServicelmpl implements PhimDetailsService{
	@Autowired
	PhimRepository phimRepository;
	
	public void LuuPhim(Phim phim) {
		phimRepository.save(phim);
	}
	
	public List<Phim> getPhims() {
        return (List<Phim>) phimRepository.findAll();
    }
	public Phim getPhimId(int id) {
		return phimRepository.findById(id);
	}
	public void xoaPhim(int id) {
		phimRepository.deleteById(id);
	}

	@Override
	public List<Phim> loadPhim(LocalDate startDate) {
		return phimRepository.loadPhim(startDate);
	}

	@Override
	public List<Phim> phimSapChieu(LocalDate startDate) {
		return phimRepository.phimSapChieu(startDate);
	}

	@Override
	public List<Phim> PhimsCuaRap(LocalDate startDate, int idRap, int idTl) {
		// TODO Auto-generated method stub
		return phimRepository.PhimsCuaRap(startDate, idRap, idTl);
	}
	
}
