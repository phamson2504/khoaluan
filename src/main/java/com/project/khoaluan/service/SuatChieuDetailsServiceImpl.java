package com.project.khoaluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.PhimRepository;
import com.project.khoaluan.dao.PhongRepository;
import com.project.khoaluan.dao.SuatChieuRepository;
import com.project.khoaluan.dao.TheLoaiRepository;
import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.Phong;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.model.TheLoai;

@Service
public class SuatChieuDetailsServiceImpl {
	@Autowired
	SuatChieuRepository suatChieuRepository;
	@Autowired
	TheLoaiRepository theLoaiRepository;
	@Autowired
	PhongRepository phongRepository;
	@Autowired
	PhimRepository phimRepository;
	
	public void AddSuatChieu(SuatChieu suatChieu,int idTheLoai,int idRoom) {
		TheLoai theLoai = theLoaiRepository.findById(idTheLoai);
	
		Phong phong = phongRepository.findById(idRoom);

		phong.addSuat(suatChieu);
		suatChieuRepository.save(suatChieu);
	}
	public List<ChiTietSuat> chiTietSuatTheoPhim(int idPhim) {
		return  suatChieuRepository.findChiTiet(idPhim);
	}
	public void XoaSuatChieu(int idSc) {
		suatChieuRepository.deleteById(idSc);
	}

}
