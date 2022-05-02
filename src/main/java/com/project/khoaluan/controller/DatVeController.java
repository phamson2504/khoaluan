package com.project.khoaluan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.khoaluan.dao.GheNgoiRepository;
import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.entity.GheNgoiDOT;
import com.project.khoaluan.model.GheNgoi;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.service.GheNgoiDetailsServiceImpl;
import com.project.khoaluan.service.PhimDetailsServicelmpl;
import com.project.khoaluan.service.SuatChieuDetailsService;
import com.project.khoaluan.service.SuatChieuDetailsServiceImpl;

@Controller
@RequestMapping("/chonve")
public class DatVeController {
	@Autowired
	GheNgoiDetailsServiceImpl gheNgoiDetailsServiceImpl;
	@Autowired
	SuatChieuDetailsServiceImpl suatChieuDetailsServiceImpl;
	@Autowired
	PhimDetailsServicelmpl phimdetailsServicelmpl;
	 @GetMapping("/suat")
	 	
	    public String datve(Model model,@RequestParam(value = "id") int idSuat) {
		 ArrayList<GheNgoi> gheNgoisdachon = new ArrayList<GheNgoi>();
		 gheNgoisdachon.add(new GheNgoi(26));
		 gheNgoisdachon.add(new GheNgoi(30));
		 gheNgoisdachon.add(new GheNgoi(32));
		 List<GheNgoi> gheNgois= gheNgoiDetailsServiceImpl.gheNgoiCuaSuat(idSuat);
		 List<GheNgoiDOT> gheNgoiDOTs = new ArrayList<GheNgoiDOT>();
		 for (GheNgoi gheNgoi : gheNgois) {
			gheNgoiDOTs.add(new GheNgoiDOT(gheNgoi.getId(), gheNgoi.getViTriHang(), gheNgoi.getViTriCot(), true));
		}
		 for (GheNgoiDOT gheNgoiDOT : gheNgoiDOTs) {
			for (GheNgoi gheDaChon : gheNgoisdachon) {
				if (gheNgoiDOT.getId()==gheDaChon.getId()) {
					gheNgoiDOT.setDaDat(false);
				}
			}
		}
		 
		ChiTietSuat cts = suatChieuDetailsServiceImpl.ChiTietSuatChieu(idSuat);
		Phim phim = phimdetailsServicelmpl.getPhimId(cts.getIdPhim());
		model.addAttribute("anh", phim.getHinhAnh()); 
		model.addAttribute("s", cts);
		model.addAttribute("h", gheNgoiDOTs);
	        return "datve";
	    }
	 @GetMapping("/vitridatve")
	 @ResponseBody
	 public List<GheNgoi> vitridatve(HttpSession session,@RequestParam(value = "vitri") int[] vitri) {
		 List<GheNgoi> gheNgois= gheNgoiDetailsServiceImpl.gheNgoiCuaSuat(14);
		 List<GheNgoi> gheNgoi1 = new ArrayList<GheNgoi>();
		 for (int i = 0; i < gheNgois.size(); i++) {
			 for (int j = 0; j < vitri.length; j++) {
				if (vitri[j]==i) {
					gheNgoi1.add(gheNgois.get(i));
					
				}
				
			}
			
		}
		 session.setAttribute("gheNgoi", gheNgoi1);
		 return gheNgoi1;
	 }
}
