package com.project.khoaluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.PhimRepository;
import com.project.khoaluan.model.Phim;


@Service
public class PhimDetailsServicelmpl {
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
	
}
