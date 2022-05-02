package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.entity.SuatChieuDOT;
import com.project.khoaluan.entity.SuatChieuSuaDOT;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.model.TheLoai;
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
		 	
		 return "redirect:/admin/phim";
	    }
		@RequestMapping("/suatTheoPhim") 
		public String suatTheoPhim (Model model,@RequestParam("idPhim") int idPhim) {
			List<ChiTietSuat> list =  suatChieuDetailsServiceImpl.chiTietSuatTheoPhim(idPhim);
			List<TheLoai> theLoais = theLoaiDetailsServiceImpl.getTheLoais();
			List<Integer> listId=new ArrayList<Integer>();
			for (ChiTietSuat ct : list) {
				listId.add(ct.getId());
			}
			model.addAttribute("id", listId);
			model.addAttribute("sc", list);
			model.addAttribute("idPhim", idPhim);
			model.addAttribute("tl", theLoais);
			return "SuatChieuCuaPhim";
		}
		@RequestMapping("/xoaSC") 
		public String xoaSC (@RequestParam("idSc") int idSc,@RequestParam("idPhim") int idPhim) {
			suatChieuDetailsServiceImpl.XoaSuatChieu(idSc);
			return "redirect:/admin/suatTheoPhim?idPhim="+idPhim+"";
		}
		@RequestMapping("/showformSuaSC") 
		public String showformSuaSC (Model model,@RequestParam("idSc") int idSc,@RequestParam("idPhim") int idPhim,@RequestParam("idPhong") int idPhong){
			SuatChieu chieu = suatChieuDetailsServiceImpl.findSuatChieu(idSc);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			List<TheLoai> theLoais = theLoaiDetailsServiceImpl.getTheLoais();
			SuatChieuSuaDOT chieuSuaDOT = new SuatChieuSuaDOT(chieu.getId(), chieu.getGioBatDau(), chieu.getNgayChieu().format(formatter) , chieu.getGiaVe(), chieu.getPhim().getId(),idPhong,chieu.getTheloai().getId());
			model.addAttribute("sc", chieuSuaDOT);
			model.addAttribute("tl", theLoais);
			return "SuaSuatChieu";
		}
		@RequestMapping("/SuaSC") 
		public String suaSC (@ModelAttribute("sc") SuatChieuSuaDOT sc){
			System.out.println(sc);;
		 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 	Phim phim = detailsServicelmpl.getPhimId(sc.getIdPhim());
		 	TheLoai theLoai = theLoaiDetailsServiceImpl.findTheLoai(sc.getIdtheloai());
		 	SuatChieu suatChieu = new SuatChieu(sc.getId(), sc.getGioBatDau(), LocalDate.parse(sc.getNgayChieu(), formatter), sc.getGiaVe(), phim, theLoai);
		 	suatChieuDetailsServiceImpl.UpdateSuatChieu(suatChieu, sc.getIdtheloai(), sc.getIdPhong());
			return "redirect:/admin/suatTheoPhim?idPhim="+sc.getIdPhim()+"";
		}
		

}
