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
	public List<Phim> phimsCuaRap(LocalDate startDate, int idRap, int idTl) {
		// TODO Auto-generated method stub
		return phimRepository.phimsCuaRap(startDate, idRap, idTl);
	}

	@Override
	public List<Phim> phimDaChieu(LocalDate startDate,LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return phimRepository.phimDaChieu(startDate,ngayKetThuc);
	}

	@Override
	public List<Phim> timPhim(String tenPhim) {
		// TODO Auto-generated method stub
		return phimRepository.timPhim(tenPhim);
	}
	
}
