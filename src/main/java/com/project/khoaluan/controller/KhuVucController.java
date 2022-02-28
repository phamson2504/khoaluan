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
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.service.KhuVucDetailsServiceImpl;

@Controller
@RequestMapping("/admin")
public class KhuVucController {
	@Autowired
	KhuVucDetailsServiceImpl khuVucDetailsServiceImpl;
	@RequestMapping("/KhuVucs")   
    public String KhuVucs(Model model) {
	 	List<KhuVuc> kv= khuVucDetailsServiceImpl.getKhuVucs();
	 	model.addAttribute("kv",kv);
        return "KhuVuc";
    }
	@PostMapping("/luuKhuVuc")
	 public String luuKhuVuc(@ModelAttribute("khuvuc") KhuVuc khuvuc) {
		khuVucDetailsServiceImpl.addKhuVuc(khuvuc);
		return "redirect:/admin/KhuVucs";
	}
	@RequestMapping("/xoaKhuVuc")   
    public String xoaRap(Model model,@RequestParam(value = "idKV") int idKV) {
		khuVucDetailsServiceImpl.deleteKhuVuc(idKV);
		return "redirect:/admin/KhuVucs";
	}
	 
}
