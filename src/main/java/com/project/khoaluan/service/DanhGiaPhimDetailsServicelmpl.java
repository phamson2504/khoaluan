package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.ChiTietHoaDonRepository;
import com.project.khoaluan.dao.DanhGiaPhimRepository;
import com.project.khoaluan.dao.NguoiDungRepository;
import com.project.khoaluan.dao.PhimRepository;
import com.project.khoaluan.model.DanhGiaPhim;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.SuatChieu;
@Service
public class DanhGiaPhimDetailsServicelmpl implements DanhGiaPhimDetailsService{
	@Autowired
	DanhGiaPhimRepository danhGiaPhimRepository;
	@Autowired
	NguoiDungRepository ndRepository;
	@Autowired
	PhimRepository phimRepository;
	@Override
	public List<SuatChieu> suatChieu(int idNd, int idPhim) {
		// TODO Auto-generated method stub
		return danhGiaPhimRepository.suatChieu(idNd, idPhim);
	}
	@Override
	public DanhGiaPhim timDanhGia(int idNd, int idPhim) {
		// TODO Auto-generated method stub
		return danhGiaPhimRepository.timDanhGia(idNd, idPhim);
	}
	@Override
	public void saveDanhGia(int idNd, int idPhim, int soSao) {
		Phim phim = phimRepository.findById(idPhim);
		NguoiDung nguoiDung = ndRepository.findById(idNd);
		DanhGiaPhim danhGiaPhim = new DanhGiaPhim(soSao, nguoiDung, phim);
		danhGiaPhimRepository.save(danhGiaPhim);
		
	}
	@Override
	public void updateDanhGia(int id,int idNd, int idPhim, int soSao) {
		Phim phim = phimRepository.findById(idPhim);
		NguoiDung nguoiDung = ndRepository.findById(idNd);
		DanhGiaPhim danhGiaPhim = new DanhGiaPhim(id,soSao,nguoiDung,phim);
		danhGiaPhimRepository.save(danhGiaPhim);
		
	}
	@Override
	public List<DanhGiaPhim> allDanhGiaPhim(int idPhim) {
		// TODO Auto-generated method stub
		return danhGiaPhimRepository.allDanhGiaPhim(idPhim);
	}
	

}
