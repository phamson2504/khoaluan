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
	public List<KhuVuc> khuVucCuaPhim(int idPhim, LocalDate startDate) {
		// TODO Auto-generated method stub
		return khuVucRepository.khuVucCuaPhim(idPhim, startDate);
	}
	@Override
	public List<KhuVuc> khuVucCuaRap(LocalDate startDateL) {
		// TODO Auto-generated method stub
		return khuVucRepository.khuVucCuaRap(startDateL);
	}
	@Override
	public void suaKhuVuc(KhuVuc khuVuc) {
		KhuVuc	khuVuc1 = khuVucRepository.findById(khuVuc.getId());
	 	khuVuc1.setTenKhuVuc(khuVuc.getTenKhuVuc());
	 	khuVucRepository.save(khuVuc1);
	}
}
