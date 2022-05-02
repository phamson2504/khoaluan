package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.khoaluan.dao.ChiTietHoaDonRepository;
import com.project.khoaluan.dao.DanhGiaPhimRepository;
import com.project.khoaluan.dao.GheNgoiRepository;
import com.project.khoaluan.dao.NguoiDungRepository;
import com.project.khoaluan.dao.PhimRepository;
import com.project.khoaluan.dao.RapRepository;
import com.project.khoaluan.dao.SuatChieuRepository;
import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.entity.GheLichSuDvDOT;
import com.project.khoaluan.entity.ThongKeDOT;
import com.project.khoaluan.entity.ThongkeSlDOT;
import com.project.khoaluan.model.ChiTietHoaDon;
import com.project.khoaluan.model.DanhGiaPhim;
import com.project.khoaluan.model.GheNgoi;
import com.project.khoaluan.model.HoaDon;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.Rap;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.service.NguoiDungDetailsServiceImpl;

@RestController
@RequestMapping("/rest")
public class restcontroller {
	
	@Autowired
	PhimRepository phimRepository;
	@Autowired
	DanhGiaPhimRepository danhGiaPhimRepository;
	@Autowired
	RapRepository rapRepository;
	@Autowired
	SuatChieuRepository suatChieuRepository;
	@Autowired
	GheNgoiRepository gheNgoiRepository;
	@Autowired
	NguoiDungDetailsServiceImpl ndDetailsServiceImpl;
	@Autowired
	ChiTietHoaDonRepository ctChiTietHoaDonRepository;
	@Autowired
	com.project.khoaluan.dao.HoaDonRepository HoaDonRepository;
	@RequestMapping("/phims") 
	 public List<SuatChieu> Phims() {
		 DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate ld = LocalDate.now();
		  	String ten="G NGHE";
			return  danhGiaPhimRepository.suatChieu(4, 8);
	    }
	@RequestMapping("/raps") 
	 public List<ChiTietSuat> Raps() {
		 DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate ld = LocalDate.parse("2022-03-03", DATEFORMATTER);
			return  suatChieuRepository.suatChieuCuaRap(4, ld, 2);
	    }
	@RequestMapping("/nd") 
	 public	NguoiDung GheNgoi() {
			return  ndDetailsServiceImpl.findbyid(3);
	    }
	@RequestMapping("/suaHoaDon")   
    public SuatChieu xoaSuat() {
		SuatChieu suatChieu = suatChieuRepository.findById(35);
	 	
        return suatChieu;
    }
}
