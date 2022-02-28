package com.project.khoaluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.khoaluan.dao.GheNgoiRepository;
import com.project.khoaluan.model.GheNgoi;
import com.project.khoaluan.model.Phong;
import com.project.khoaluan.model.Rap;
import com.project.khoaluan.service.GheNgoiDetailsServiceImpl;
import com.project.khoaluan.service.PhongDetailsServiceImpl;
import com.project.khoaluan.service.RapDetailsServiceImpl;

@Controller
@RequestMapping("/admin")
public class PhongController {
	@Autowired
	RapDetailsServiceImpl rapDetailsServiceImpl;
	@Autowired
	PhongDetailsServiceImpl phongDetailsServiceImpl;
	
	@Autowired
	GheNgoiDetailsServiceImpl gheNgoiDetailsServiceImpl;
	
	@RequestMapping("/phongs")  
	 public String Raps(Model model,@RequestParam("idRap") int idRap,@RequestParam("idKhuVuc") int idKhuVuc) {
		Rap rap = rapDetailsServiceImpl.findRap(idRap);
		List<Phong> phongs = rap.getPhongs();
		model.addAttribute("phong",phongs);
		model.addAttribute("idRap",idRap);
		model.addAttribute("idKhuVuc",idKhuVuc);
	 	return "phong";
	}
	@PostMapping("/luuPhong")   
    public String luuRap(@ModelAttribute("phong") Phong phong,@RequestParam("idRap") int idRap,@RequestParam("idKhuVuc") int idKhuVuc) {
		phongDetailsServiceImpl.addPhong(phong, idRap);
		for (int i = 0; i < phong.getHang(); i++) {
			for (int j = 0; j < phong.getCot(); j++) {
				
				if (i==0) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("A",j) , phong.getId());
				}
				else if (i==1) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("B",j) , phong.getId());
				}
				else if (i==2) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("C",j) , phong.getId());
				}
				else if (i==3) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("D",j) , phong.getId());
				}
				else if (i==4) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("F",j) , phong.getId());
				}
				else if (i==5) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("G",j) , phong.getId());
				}
				else if (i==6) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("H",j) , phong.getId());
				}
				else if (i==7) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("I",j) , phong.getId());
				}
				else if (i==8) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("J",j) , phong.getId());
				}
				else if (i==9) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("K",j) , phong.getId());
				}
				else if (i==10) {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi("L",j) , phong.getId());
				}else {
					gheNgoiDetailsServiceImpl.addNgheNgoi(new GheNgoi(i+"", j), phong.getId());
				}
				
			}
			
		}
        return "redirect:/admin/phongs?idRap="+idRap+"&idKhuVuc="+idKhuVuc+"";
    }
	
	@PostMapping("/UpdatePhong")   
    public String UpdateRap(@ModelAttribute("phong") Phong phong,@RequestParam("idRap") int idRap,@RequestParam("idKhuVuc") int idKhuVuc) {
		phongDetailsServiceImpl.updatePhong(phong, idRap);
		
		return "redirect:/admin/phongs?idRap="+idRap+"&idKhuVuc="+idKhuVuc+"";
    }
	@RequestMapping("/xoaPhong")   
    public String xoaRap(@RequestParam(value = "idPhong") int idPhong,@RequestParam(value = "idRap") int idRap,@RequestParam("idKhuVuc") int idKhuVuc) {
		phongDetailsServiceImpl.xoaPhong(idPhong);
		return "redirect:/admin/phongs?idRap="+idRap+"&idKhuVuc="+idKhuVuc+"";
	}
	@Autowired
	GheNgoiRepository gheNgoiRepository;
	@RequestMapping("/ghe")
	public String Ghe(Model model) {
		List<GheNgoi> gheNgois= gheNgoiRepository.gheNgoiCuaPhong();
		model.addAttribute("h", gheNgois);
		return "gheNgoi";
	}
}
