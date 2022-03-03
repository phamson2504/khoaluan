package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.entity.SuatChieuDOT;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.service.PhimDetailsServicelmpl;
import com.project.khoaluan.service.SuatChieuDetailsServiceImpl;
import com.project.khoaluan.service.TheLoaiDetailsServiceImpl;

@Controller
@RequestMapping("/admin")
public class SuatChieuController {
	@Autowired
	PhimDetailsServicelmpl detailsServicelmpl;
	@Autowired
	SuatChieuDetailsServiceImpl suatChieuDetailsServiceImpl;
	@Autowired
	TheLoaiDetailsServiceImpl theLoaiDetailsServiceImpl;
	 @PostMapping("/luuSuatChieu")   
	    public String luuSuatChieu(@RequestBody SuatChieuDOT suatDOT,@RequestParam("idTheLoai") int idTheLoai,
	    	@RequestParam("idRoom") int idRoom,@RequestParam("idPhim") int idPhim) {
		 	suatDOT.setPhim(detailsServicelmpl.getPhimId(idPhim));
		 	suatDOT.setTheloai(theLoaiDetailsServiceImpl.findTheLoai(idTheLoai));

		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 	SuatChieu suatChieu = new SuatChieu(suatDOT.getId(), suatDOT.getGioBatDau(), LocalDate.parse(suatDOT.getNgayChieu(), formatter), suatDOT.getGiaVe(), suatDOT.getPhim(), suatDOT.getTheloai());
		 	suatChieuDetailsServiceImpl.AddSuatChieu(suatChieu, idTheLoai, idRoom);
		 	System.out.println("dsdadsdasdsdsdsdsdsd"+suatChieu);
		 	
		 return "redirect:/admin/phim";
	    }
		@RequestMapping("/suatTheoPhim") 
		public String suatTheoPhim (Model model,@RequestParam("idPhim") int idPhim) {
			List<ChiTietSuat> list =  suatChieuDetailsServiceImpl.chiTietSuatTheoPhim(idPhim);
			model.addAttribute("sc", list);
			model.addAttribute("idPhim", idPhim);
			return "SuatChieuCuaPhim";
		}
		@RequestMapping("/xoaSC") 
		public String xoaSC (@RequestParam("idSc") int idSc,@RequestParam("idPhim") int idPhim) {
			suatChieuDetailsServiceImpl.XoaSuatChieu(idSc);
			return "redirect:/admin/suatTheoPhim?idPhim="+idPhim+"";
		}
		

}
