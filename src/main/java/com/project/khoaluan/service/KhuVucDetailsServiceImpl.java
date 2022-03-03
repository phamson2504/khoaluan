package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.KhuVucRepository;
import com.project.khoaluan.model.KhuVuc;

@Service
public class KhuVucDetailsServiceImpl implements KhuVucDetailsService{
	@Autowired
	KhuVucRepository khuVucRepository;
	
	public void addKhuVuc(KhuVuc khuVuc) {
		khuVucRepository.save(khuVuc);
	}
	public List<KhuVuc> getKhuVucs(){
		return (List<KhuVuc>) khuVucRepository.findAll();
	}
	public KhuVuc findKhuVuc(int id) {
		return khuVucRepository.findById(id);
	}
	public void deleteKhuVuc(int id) {
		khuVucRepository.deleteById(id);;
	}
	@Override
	public List<KhuVuc> KhuVucCuaPhim(int idPhim, LocalDate startDate) {
		// TODO Auto-generated method stub
		return khuVucRepository.KhuVucCuaPhim(idPhim, startDate);
	}
	@Override
	public List<KhuVuc> KhuVucCuaRap(LocalDate startDateL) {
		// TODO Auto-generated method stub
		return khuVucRepository.KhuVucCuaRap(startDateL);
	}
}
