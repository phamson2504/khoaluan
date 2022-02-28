package com.project.khoaluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.TheLoai;
import com.project.khoaluan.service.TheLoaiDetailsServiceImpl;

@Controller
@RequestMapping("/admin")
public class TheLoaiController {
	@Autowired
	TheLoaiDetailsServiceImpl theLoaiDetailsServiceImpl;
	@RequestMapping("/theLoais")
	public String TheLoais(Model model) {
		List<TheLoai> theLoais= theLoaiDetailsServiceImpl.getTheLoais();
		model.addAttribute("tl", theLoais);
		return "TheLoai";
	}
	@PostMapping("/luuTheLoai")
	 public String luuKhuVuc(@ModelAttribute("tl") TheLoai tl) {
		theLoaiDetailsServiceImpl.addTheLoai(tl);
		return "redirect:/admin/theLoais";
	}
	@RequestMapping("/xoaTheLoai")   
    public String xoaPhim(Model model,@RequestParam(value = "idTL") int idTL) {
	 	theLoaiDetailsServiceImpl.deleteTheLoai(idTL);
	 	
	 	return "redirect:/admin/theLoais";
    }
}
