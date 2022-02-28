package com.project.khoaluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.KhuVucRepository;
import com.project.khoaluan.model.KhuVuc;

@Service
public class KhuVucDetailsServiceImpl {
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
}
