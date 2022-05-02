package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.KhuVucRepository;
import com.project.khoaluan.dao.RapRepository;
import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.Rap;

@Service
public class RapDetailsServiceImpl implements RapDetailsService{
	@Autowired
	RapRepository rapRepository;
	@Autowired
	KhuVucRepository khuVucRepository;
	
	public void addRap(Rap rap,int idKhuVuc) {
		KhuVuc khuVuc = khuVucRepository.findById(idKhuVuc);
		khuVuc.addRap(rap);
		rapRepository.save(rap);
	}
	public void updateRap(Rap rap,int idKhuVuc) {
		KhuVuc khuVuc = khuVucRepository.findById(idKhuVuc);
		Rap tempRap = khuVuc.getRap(rap.getId());
		tempRap.setDiaChi(rap.getDiaChi());
		tempRap.setTenRap(rap.getTenRap());
		rapRepository.save(tempRap);
	}
	public List<Rap> getRaps(){
		return (List<Rap>) rapRepository.findAll();
	}
	public Rap findRap(int id) {
		return rapRepository.findById(id);
	}
	public void XoaRap(int id) {
		rapRepository.deleteById(id);
	}
	@Override
	public List<Rap> rapCuaPhim(int idPhim, LocalDate startDate, int idKV, int idTL) {
		// TODO Auto-generated method stub
		return rapRepository.rapCuaPhim(idPhim, startDate, idKV, idTL);
	}
	@Override
	public List<Rap> rapCuaLichRap(LocalDate startDate, int idKV) {
		// TODO Auto-generated method stub
		return rapRepository.rapCuaLichRap(startDate, idKV);
	}
}
