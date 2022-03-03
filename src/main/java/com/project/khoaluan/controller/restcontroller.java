package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.khoaluan.dao.PhimRepository;
import com.project.khoaluan.dao.RapRepository;
import com.project.khoaluan.dao.SuatChieuRepository;
import com.project.khoaluan.entity.ChiTietSuat;
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
	RapRepository rapRepository;
	@Autowired
	SuatChieuRepository suatChieuRepository;
	@Autowired
	NguoiDungDetailsServiceImpl ndDetailsServiceImpl;
	@RequestMapping("/phims") 
	 public LocalDate Phims() {
		 DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate ld = LocalDate.now();
			return  (LocalDate) suatChieuRepository.ngayChieuGannhat(ld,5);
	    }
	@RequestMapping("/raps") 
	 public List<ChiTietSuat> Raps() {
		 DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate ld = LocalDate.parse("2022-03-03", DATEFORMATTER);
			return  suatChieuRepository.SuatChieuCuaRap(4, ld, 2);
	    }
	@RequestMapping("/xoaSuat")   
    public String xoaSuat() {
		ndDetailsServiceImpl.XoaNguoiDung();
	 	
        return "thanh cong";
    }
}
