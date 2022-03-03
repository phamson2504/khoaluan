package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.Rap;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.model.TheLoai;
import com.project.khoaluan.service.KhuVucDetailsServiceImpl;
import com.project.khoaluan.service.PhimDetailsServicelmpl;
import com.project.khoaluan.service.RapDetailsServiceImpl;
import com.project.khoaluan.service.SuatChieuDetailsServiceImpl;
import com.project.khoaluan.service.TheLoaiDetailsServiceImpl;

@Controller
@RequestMapping("/datve")
public class LichRapController {
	@Autowired
	PhimDetailsServicelmpl phimDetailsServicelmpl;
	@Autowired
	KhuVucDetailsServiceImpl kvDetailsServiceImpl;
	@Autowired
	RapDetailsServiceImpl rapDetailsServiceImpl;
	@Autowired
	SuatChieuDetailsServiceImpl suatChieuDetailsServiceImpl;
	@Autowired
	TheLoaiDetailsServiceImpl tlDetailsServiceImpl;
	 @GetMapping("/lichrap")   
	    public String lichRap(Model model) {
		LocalDate date = LocalDate.now();
		List<KhuVuc> khuVucs = kvDetailsServiceImpl.KhuVucCuaRap(date);
		List<Rap> raps = rapDetailsServiceImpl.RapCuaLichRap(date, khuVucs.get(0).getId());
		List<TheLoai> theLoais = tlDetailsServiceImpl.TheLoaiCuaRap(date, raps.get(0).getId());
		List<ChiTietSuat> suatChieus= suatChieuDetailsServiceImpl.SuatChieuCuaRap(raps.get(0).getId(), date, theLoais.get(0).getId());
		List<Phim> phims = phimDetailsServicelmpl.PhimsCuaRap(date, raps.get(0).getId(), theLoais.get(0).getId());
		 model.addAttribute("tl",theLoais);
		 model.addAttribute("kv",khuVucs);
		 model.addAttribute("r",raps);
		 model.addAttribute("s",suatChieus);
		 model.addAttribute("p",phims);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 String formattedString = date.format(formatter);
		 model.addAttribute("n",  formattedString);
		 	
	        return "lichRap";
	    }
}
