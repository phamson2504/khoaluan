package com.project.khoaluan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.khoaluan.dao.RapRepository;
import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.Rap;
import com.project.khoaluan.service.KhuVucDetailsServiceImpl;
import com.project.khoaluan.service.RapDetailsServiceImpl;

@Controller
@RequestMapping("/admin")
public class RapController {
	@Autowired
	RapDetailsServiceImpl rapDetailsServiceImpl;
	@Autowired
	KhuVucDetailsServiceImpl khuVucDetailsServiceImpl;
	
	@RequestMapping("/raps") 
	
    public String raps(Model model,@RequestParam("idKhuVuc") int idKhuVuc) {
		KhuVuc khuVuc = khuVucDetailsServiceImpl.findKhuVuc(idKhuVuc);
	 	List<Rap> raps= khuVuc.getRaps();
	 	model.addAttribute("rap",raps);
	 	model.addAttribute("idKhuVuc",idKhuVuc);
        return "rap";
    }
	@PostMapping("/luuRap")   
    public String luuRap(@ModelAttribute("rap") Rap rap,@RequestParam("idKhuVuc") int idKhuVuc) {
	 	rapDetailsServiceImpl.addRap(rap, idKhuVuc);
        return "redirect:/admin/raps?idKhuVuc="+idKhuVuc+"";
    }
	@PostMapping("/UpdateRap")   
    public String updateRap(@ModelAttribute("rap") Rap rap,@RequestParam("idKhuVuc") int idKhuVuc) {
	 	rapDetailsServiceImpl.updateRap(rap, idKhuVuc);
        return "redirect:/admin/raps?idKhuVuc="+idKhuVuc+"";
    }
	@RequestMapping("/xoaRap")   
    public String xoaRap(Model model,@RequestParam(value = "idRap") int idRap,@RequestParam("idKhuVuc") int idKhuVuc) {
		rapDetailsServiceImpl.XoaRap(idRap);
		return "redirect:/admin/raps?idKhuVuc="+idKhuVuc+"";
	}
	
}
