package com.project.khoaluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.TheLoaiRepository;
import com.project.khoaluan.model.TheLoai;

@Service
public class TheLoaiDetailsServiceImpl {
	@Autowired
	TheLoaiRepository theLoaiRepository;
	public void addTheLoai(TheLoai theLoai) {
		theLoaiRepository.save(theLoai);
	}
	public void deleteTheLoai(int idTheLoai) {
		theLoaiRepository.deleteById(idTheLoai);
	}
	public TheLoai findTheLoai(int id) {
		return theLoaiRepository.findById(id);
	}
	public List<TheLoai> getTheLoais(){
		return (List<TheLoai>) theLoaiRepository.findAll();
	}
}
