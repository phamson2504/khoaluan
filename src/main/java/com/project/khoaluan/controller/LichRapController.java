package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@GetMapping("/thanhtoan")   
    public String lichRap1(Model model) {
		return "ThanhToan";
	}
	 @GetMapping("/lichrap")   
	    public String lichRap(Model model) {
		LocalDate date = LocalDate.now();
		List<KhuVuc> khuVucs = kvDetailsServiceImpl.khuVucCuaRap(date);
		if (khuVucs.size()!=0) {
			List<Rap> raps = rapDetailsServiceImpl.rapCuaLichRap(date, khuVucs.get(0).getId());
			List<TheLoai> theLoais = tlDetailsServiceImpl.theLoaiCuaRap(date, raps.get(0).getId());
			List<ChiTietSuat> suatChieus= suatChieuDetailsServiceImpl.suatChieuCuaRap(raps.get(0).getId(), date, theLoais.get(0).getId());
			List<Phim> phims = phimDetailsServicelmpl.phimsCuaRap(date, raps.get(0).getId(), theLoais.get(0).getId());
			
			 model.addAttribute("tl",theLoais);
			 model.addAttribute("kv",khuVucs);
			 model.addAttribute("r",raps);
			 model.addAttribute("s",suatChieus);
			 model.addAttribute("p",phims);
			 model.addAttribute("kvChon", khuVucs.get(0).getId());
			 model.addAttribute("rapChon",raps.get(0).getId());
			 model.addAttribute("tlChon",theLoais.get(0).getId());
		}
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 String formattedString = date.format(formatter);
		 model.addAttribute("n",  formattedString);
		 	
	        return "lichRap";
	    }
	 @GetMapping("/ngayLichRap")
	    public String kvLichRap(Model model,@RequestParam(value = "ngay") String ngay) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		List<KhuVuc> khuVucs = kvDetailsServiceImpl.khuVucCuaRap(date);
		if (date.isAfter(LocalDate.now())||date.isEqual(LocalDate.now())) {
			if (khuVucs.size()!=0) {
				List<Rap> raps = rapDetailsServiceImpl.rapCuaLichRap(date, khuVucs.get(0).getId());
				List<TheLoai> theLoais = tlDetailsServiceImpl.theLoaiCuaRap(date, raps.get(0).getId());
				List<ChiTietSuat> suatChieus= suatChieuDetailsServiceImpl.suatChieuCuaRap(raps.get(0).getId(), date, theLoais.get(0).getId());
				List<Phim> phims = phimDetailsServicelmpl.phimsCuaRap(date, raps.get(0).getId(), theLoais.get(0).getId());
				
					 model.addAttribute("tl",theLoais);
					 model.addAttribute("kv",khuVucs);
					 model.addAttribute("r",raps);
					 model.addAttribute("s",suatChieus);
					 model.addAttribute("p",phims);
					 model.addAttribute("kvChon",khuVucs.get(0).getId());
					 model.addAttribute("rapChon",raps.get(0).getId());
					 model.addAttribute("tlChon",theLoais.get(0).getId());
			}
		}
		String formattedString = date.format(formatter);
		model.addAttribute("n",  formattedString);
		return "lichRap";
	 }
	 @GetMapping("/kvLichRap")   
	    public String rapLichRap(Model model,@RequestParam(value = "ngay") String ngay,@RequestParam(value = "idKv") int idKv) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<KhuVuc> khuVucs = kvDetailsServiceImpl.khuVucCuaRap(date);
		 List<Rap> raps = rapDetailsServiceImpl.rapCuaLichRap(date, idKv);
		 List<TheLoai> theLoais = tlDetailsServiceImpl.theLoaiCuaRap(date, raps.get(0).getId());
		 List<ChiTietSuat> suatChieus= suatChieuDetailsServiceImpl.suatChieuCuaRap(raps.get(0).getId(), date, theLoais.get(0).getId());
		 List<Phim> phims = phimDetailsServicelmpl.phimsCuaRap(date, raps.get(0).getId(), theLoais.get(0).getId());
		 model.addAttribute("tl",theLoais);
		 model.addAttribute("kv",khuVucs);
		 model.addAttribute("r",raps);
		 model.addAttribute("s",suatChieus);
		 model.addAttribute("p",phims);
		 model.addAttribute("kvChon",idKv);
		 model.addAttribute("rapChon",raps.get(0).getId());
		 model.addAttribute("tlChon",theLoais.get(0).getId());
		 String formattedString = date.format(formatter);
		 model.addAttribute("n",  formattedString);
		 return "lichRap";
	 }
	 @GetMapping("/rapLichRap")   
	    public String tlLichRap(Model model,@RequestParam(value = "ngay") String ngay,@RequestParam(value = "idRap") int idRap,@RequestParam(value = "idKv") int idKv) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<TheLoai> theLoais = tlDetailsServiceImpl.theLoaiCuaRap(date, idRap);
		 List<KhuVuc> khuVucs = kvDetailsServiceImpl.khuVucCuaRap(date);
		 List<Rap> raps = rapDetailsServiceImpl.rapCuaLichRap(date, idKv);
		 List<ChiTietSuat> suatChieus= suatChieuDetailsServiceImpl.suatChieuCuaRap(idRap, date, theLoais.get(0).getId());
		 List<Phim> phims = phimDetailsServicelmpl.phimsCuaRap(date, idRap, theLoais.get(0).getId());
		 model.addAttribute("tl",theLoais);
		 model.addAttribute("kv",khuVucs);
		 model.addAttribute("r",raps);
		 model.addAttribute("s",suatChieus);
		 model.addAttribute("p",phims);
		 model.addAttribute("kvChon",idKv);
		 model.addAttribute("rapChon",idRap);
		 model.addAttribute("tlChon",theLoais.get(0).getId());
		 String formattedString = date.format(formatter);
		 model.addAttribute("n",  formattedString);
		 return "lichRap";
	 }
	 @GetMapping("/tlLichRap")   
	    public String pLichRap(Model model,@RequestParam(value = "ngay") String ngay,@RequestParam(value = "idRap") int idRap,
	    		@RequestParam(value = "idTl") int idTl,@RequestParam(value = "idKv") int idKv) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<TheLoai> theLoais = tlDetailsServiceImpl.theLoaiCuaRap(date, idRap);
		 List<KhuVuc> khuVucs = kvDetailsServiceImpl.khuVucCuaRap(date);
		 List<Rap> raps = rapDetailsServiceImpl.rapCuaLichRap(date, idKv);
		 List<ChiTietSuat> suatChieus= suatChieuDetailsServiceImpl.suatChieuCuaRap(idRap, date, idTl);
		 List<Phim> phims = phimDetailsServicelmpl.phimsCuaRap(date, idRap, idTl);
		 model.addAttribute("tl",theLoais);
		 model.addAttribute("kv",khuVucs);
		 model.addAttribute("r",raps);
		 model.addAttribute("s",suatChieus);
		 model.addAttribute("p",phims);
		 model.addAttribute("kvChon",idKv);
		 model.addAttribute("rapChon",idRap);
		 model.addAttribute("tlChon",idTl);
		 String formattedString = date.format(formatter);
		 model.addAttribute("n",  formattedString);
		 return "lichRap";
	 }
}
