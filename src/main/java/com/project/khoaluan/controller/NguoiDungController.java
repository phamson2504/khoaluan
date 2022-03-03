package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import com.project.khoaluan.model.TheLoai;
import com.project.khoaluan.service.KhuVucDetailsServiceImpl;
import com.project.khoaluan.service.PhimDetailsServicelmpl;
import com.project.khoaluan.service.RapDetailsServiceImpl;
import com.project.khoaluan.service.SuatChieuDetailsServiceImpl;
import com.project.khoaluan.service.TheLoaiDetailsServiceImpl;

@Controller
@RequestMapping("/datve")
public class NguoiDungController {
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
	 
	 @GetMapping("/lichPhim")   
	    public String lichPhim(Model model,@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "ngay") String ngay) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<TheLoai> theLoais = new ArrayList<TheLoai>();
		
		 List<KhuVuc> khuVucs = kvDetailsServiceImpl.KhuVucCuaPhim(idPhim, date); 
		 theLoais = tlDetailsServiceImpl.TheLoaiCuaPhim(idPhim, date,khuVucs.get(0).getId());
		 List<Rap> raps = rapDetailsServiceImpl.RapCuaPhim(idPhim, date, khuVucs.get(0).getId(), theLoais.get(0).getId());
		 List<ChiTietSuat> suatChieus = suatChieuDetailsServiceImpl.SuatChieuCuaPhim(idPhim, date, khuVucs.get(0).getId(), theLoais.get(0).getId());
		 Phim phim =  phimDetailsServicelmpl.getPhimId(idPhim);
		 model.addAttribute("p", phim);
		 model.addAttribute("tl",theLoais);
		 model.addAttribute("kv",khuVucs);
		 model.addAttribute("r",raps);
		 model.addAttribute("s",suatChieus);
		 model.addAttribute("tenTl",theLoais.get(0).getTen());
		 model.addAttribute("idPhim",idPhim);
		
		 String formattedString = date.format(formatter);
		 model.addAttribute("n",  formattedString);
		 
	        return "lichPhim";
	    }
	 @GetMapping("/lichPhimTlThayDoi")   
	 @ResponseBody
	    public List<TheLoai> lichPhimTlThayDoi(@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "ngay") String ngay
	    		,@RequestParam(value = "idKv") int idKv) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<TheLoai> theLoais = tlDetailsServiceImpl.TheLoaiCuaPhim(idPhim, date,idKv);
	        return theLoais;
	    }
	 @GetMapping("/lichPhimKV")   
	 @ResponseBody
	    public List<KhuVuc> lichPhimKV(@RequestParam(value = "idPhim") int idPhim,
	    		@RequestParam(value = "ngay") String ngay) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<KhuVuc> khuVucs = kvDetailsServiceImpl.KhuVucCuaPhim(idPhim, date);

		 System.out.println(khuVucs);
	        return khuVucs;
	    }
	 @GetMapping("/lichPhimRapThayDoi")   
	 @ResponseBody
	    public List<Rap> lichPhimRapThayDoi(@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "idTl") int idTl,
	    		@RequestParam(value = "ngay") String ngay,@RequestParam(value = "idKv") int idKv) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<Rap> raps = rapDetailsServiceImpl.RapCuaPhim(idPhim, date, idKv, idTl);
	        return raps;
	    }
	 @GetMapping("/lichPhimSuatThayDoi")   
	 @ResponseBody
	    public List<ChiTietSuat> lichPhimSuatThayDoi(@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "idTl") int idTl,
	    		@RequestParam(value = "ngay") String ngay,@RequestParam(value = "idKv") int idKv) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<ChiTietSuat> suatChieus = suatChieuDetailsServiceImpl.SuatChieuCuaPhim(idPhim, date, idKv, idTl);
	        return suatChieus;
	    }
	
	 
	 
//	 @GetMapping("/lichPhimSauThayDoi")   
//	    public String lichPhimSauThayDoi(Model model,@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "idTl") int idTl,
//	    		@RequestParam(value = "ngay") String ngay,@RequestParam(value = "idKv") int idKv) {
//		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		 LocalDate date = LocalDate.parse(ngay, formatter);
//		 List<TheLoai> theLoais = tlDetailsServiceImpl.TheLoaiCuaPhim(idPhim, date);
//		 List<KhuVuc> khuVucs = kvDetailsServiceImpl.KhuVucCuaPhim(idPhim, date, idTl);
//		 List<Rap> raps = rapDetailsServiceImpl.RapCuaPhim(idPhim, date, idKv, idTl);
//		 List<ChiTietSuat> suatChieus = suatChieuDetailsServiceImpl.SuatChieuCuaPhim(idPhim, date,idKv, idTl);
//		 model.addAttribute("tl",theLoais);
//		 model.addAttribute("kv",khuVucs);
//		 model.addAttribute("n",ngay);
//	        return "lichPhim";
//	    }
}
