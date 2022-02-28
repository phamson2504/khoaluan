package com.project.khoaluan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.khoaluan.dao.GheNgoiRepository;
import com.project.khoaluan.dao.PhimRepository;
import com.project.khoaluan.dao.SuatChieuRepository;
import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.model.GheNgoi;
import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.Rap;
import com.project.khoaluan.service.KhuVucDetailsServiceImpl;
import com.project.khoaluan.service.RapDetailsServiceImpl;

@RestController
@RequestMapping("/rest")
public class restcontroller {
	
	@Autowired
	GheNgoiRepository phimRepository;
	@RequestMapping("/raps") 
	 public List<GheNgoi> Raps() {
			return  phimRepository.gheNgoiCuaPhong();
	    }
	@RequestMapping("/xoaSuat")   
    public String xoaSuat() {
		phimRepository.deleteById(17);
	 	
        return "thanh cong";
    }
}
