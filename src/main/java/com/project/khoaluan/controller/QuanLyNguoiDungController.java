package com.project.khoaluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.khoaluan.entity.GheLichSuDvDOT;
import com.project.khoaluan.entity.LichSuDatVeDOT;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.Phong;
import com.project.khoaluan.model.Rap;
import com.project.khoaluan.service.ChiTietHoaDonDetailsServiceImpl;
import com.project.khoaluan.service.HoaDonDetailsServiceImpl;
import com.project.khoaluan.service.NguoiDungDetailsServiceImpl;

@Controller
@RequestMapping("/admin")
public class QuanLyNguoiDungController {
	@Autowired
	NguoiDungDetailsServiceImpl ndDetailsServiceImpl;
	@Autowired
	ChiTietHoaDonDetailsServiceImpl	chiTietHoaDonDetailsServiceImpl;
	@Autowired
	HoaDonDetailsServiceImpl hoaDonDetailsServiceImpl;
	
	@RequestMapping("/nguoidung")  
	 public String nguoiDung(Model model) {
		List<NguoiDung> list= ndDetailsServiceImpl.allNguoiDung();
		model.addAttribute("nd", list);
	
	 	return "QlNguoiDung";
	}
	@RequestMapping("/xoaND")  
	 public String xoaND(@RequestParam("idNd") int idNd) {
		
		ndDetailsServiceImpl.XoaNguoiDung(idNd);
	 	return "redirect:/admin/nguoidung";
	}
	@RequestMapping("/showformSuaND")  
	 public String suaND(Model model,@RequestParam("idNd") int idNd) {
		NguoiDung nguoiDung = ndDetailsServiceImpl.findbyid(idNd);
		model.addAttribute("nd", nguoiDung);
	 	return "SuaNguoiDung";
	}
	@RequestMapping("/updateND")  
	 public String updateND(@ModelAttribute("nd") NguoiDung nd) {
		NguoiDung nguoiDung = ndDetailsServiceImpl.findbyid(nd.getId());
		if (nd.getMatKhau().equalsIgnoreCase(nguoiDung.getMatKhau())==true) {
			ndDetailsServiceImpl.SuaNguoiDungkhongcapnhatMK(nd);
		}else {
			ndDetailsServiceImpl.SuaNguoiDung(nd);
		}
		
	 	return "redirect:/admin/nguoidung";
	}
	@RequestMapping("/quanLyDatVe")  
	 public String quanLyDatVe(Model model,@RequestParam("idNd") int idNd) {
		List<LichSuDatVeDOT> list  = chiTietHoaDonDetailsServiceImpl.lichSuDatVe(idNd);
		List<GheLichSuDvDOT> list2 = chiTietHoaDonDetailsServiceImpl.lichSuCtDatVe(idNd);
    	model.addAttribute("ls", list);
    	model.addAttribute("g", list2);
    	model.addAttribute("idNd", idNd);
	 	return "QuanLyDatVe";
	}
	@RequestMapping("/huyVe")  
	 public String huyVe(@RequestParam("idNd") int idNd,@RequestParam("idHD") int idHD) {
		hoaDonDetailsServiceImpl.deleteById(idHD);
	 	return "redirect:/admin/quanLyDatVe?idNd="+idNd+"";
	}
	
}
