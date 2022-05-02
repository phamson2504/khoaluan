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
import org.springframework.web.multipart.MultipartFile;

import  com.project.khoaluan.service.AWSS3Service;
import com.project.khoaluan.dao.SuatChieuRepository;
import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.Rap;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.model.TheLoai;
import com.project.khoaluan.service.PhimDetailsServicelmpl;
import com.project.khoaluan.service.SuatChieuDetailsServiceImpl;
import com.project.khoaluan.service.TheLoaiDetailsServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AWSS3Service awsS3Service;
	@Autowired
	PhimDetailsServicelmpl detailsServicelmpl;
	@Autowired
	SuatChieuDetailsServiceImpl suatChieuDetailsServiceImpl;
	@Autowired
	TheLoaiDetailsServiceImpl theLoaiDetailsServiceImpl;
	 @RequestMapping("/phim")   
	    public String admin(Model model) {
		 	List<Phim> list = detailsServicelmpl.getPhims();
		 	List<Integer> integers = new ArrayList<Integer>();
		 	for (Phim phim : list) {
				integers.add(phim.getId());
			}
		 	List<TheLoai> theLoais = theLoaiDetailsServiceImpl.getTheLoais();
		 
		 	model.addAttribute("i", integers);
		 	 model.addAttribute("phim", list);
		 	model.addAttribute("tl", theLoais);
	        return "admin";
	    }
	 @RequestMapping("/showThemPhim")   
	    public String showThemPhim(Model model) {
		 	Phim phim = new Phim();
		 	model.addAttribute("phim",phim);
	        return "ThemPhim";
	    }
	 @RequestMapping("/showSuaPhim")   
	    public String showSuaPhim(Model model,@RequestParam(value = "idPhim") int id) {
		 	Phim phim = detailsServicelmpl.getPhimId(id);
		 	model.addAttribute("phim",phim);
		 	System.out.println(phim);
	        return "ThemPhim";
	    }
	 @PostMapping("/phim/luuphim")
	 public String luuPhim(@ModelAttribute("phim") Phim phim,@RequestParam("file") MultipartFile file) {
	
		Phim phim2 = detailsServicelmpl.getPhimId(phim.getId());
		if (file.getOriginalFilename().equalsIgnoreCase("")&&phim2!=null) {
			phim.setHinhAnh(phim2.getHinhAnh());
		}else {
			String publicURL = awsS3Service.uploadFile(file);
			phim.setHinhAnh(publicURL);
		}
		 String[] Trailer = phim.getTrailer().split("v=");
		 String[] Trailer1 = phim.getTrailer().split("/watch");
		 if (Trailer.length!=1&&Trailer1.length!=1) {
			 phim.setTrailer(Trailer1[0]+"/embed/"+Trailer[1]);
			 System.out.println(phim.getTrailer());
		}
		detailsServicelmpl.LuuPhim(phim);
		return "redirect:/admin/phim";
	 }
	 @RequestMapping("/xoaPhim")   
	    public String xoaPhim(Model model,@RequestParam(value = "idPhim") int id) {
		 	detailsServicelmpl.xoaPhim(id);
		 	
	        return "redirect:/admin/phim";
	    }
	 

	 
}
