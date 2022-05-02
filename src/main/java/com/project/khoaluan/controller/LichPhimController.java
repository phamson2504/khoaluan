package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.project.khoaluan.dao.NguoiDungRepository;
import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.entity.DanhGiaPhimDOT;
import com.project.khoaluan.entity.GheNgoiDOT;
import com.project.khoaluan.model.DanhGiaPhim;
import com.project.khoaluan.model.GheNgoi;
import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.Rap;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.model.TheLoai;
import com.project.khoaluan.service.DanhGiaPhimDetailsService;
import com.project.khoaluan.service.DanhGiaPhimDetailsServicelmpl;
import com.project.khoaluan.service.KhuVucDetailsServiceImpl;
import com.project.khoaluan.service.NguoiDungDetailsServiceImpl;
import com.project.khoaluan.service.PhimDetailsServicelmpl;
import com.project.khoaluan.service.RapDetailsServiceImpl;
import com.project.khoaluan.service.SuatChieuDetailsServiceImpl;
import com.project.khoaluan.service.TheLoaiDetailsServiceImpl;

@Controller
@RequestMapping("/datve")
public class LichPhimController {
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
	
	@Autowired
	NguoiDungDetailsServiceImpl nguoiDungDetailsServiceImpl;
	@Autowired
	DanhGiaPhimDetailsServicelmpl danhGiaPhimDetailsServicelmpl;
//	 @GetMapping("/suat")
//	 	
//	    public String datve(Model model) {
//		 ArrayList<GheNgoi> gheNgoisdachon = new ArrayList<GheNgoi>();
//		 gheNgoisdachon.add(new GheNgoi(26));
//		 gheNgoisdachon.add(new GheNgoi(30));
//		 gheNgoisdachon.add(new GheNgoi(32));
//		 List<GheNgoi> gheNgois= gheNgoiRepository.gheNgoiCuaSuat(14);
//		 List<GheNgoiDOT> gheNgoiDOTs = new ArrayList<GheNgoiDOT>();
//		 for (GheNgoi gheNgoi : gheNgois) {
//			gheNgoiDOTs.add(new GheNgoiDOT(gheNgoi.getId(), gheNgoi.getViTriHang(), gheNgoi.getViTriCot(), true));
//		}
//		 for (GheNgoiDOT gheNgoiDOT : gheNgoiDOTs) {
//			for (GheNgoi gheDaChon : gheNgoisdachon) {
//				if (gheNgoiDOT.getId()==gheDaChon.getId()) {
//					gheNgoiDOT.setDaDat(false);
//				}
//			}
//		}
//		 System.out.println(gheNgoiDOTs);
//		
//			model.addAttribute("h", gheNgoiDOTs);
//	        return "datve";
//	    }
	
	@GetMapping("/kTraDG")   
	@ResponseBody
    public int kTraDG(HttpSession session,@RequestParam(value = "idPhim") int idPhim) {
		 NguoiDung nguoiDung =  (NguoiDung) session.getAttribute("nguoidung");
		 List<SuatChieu> suatChieus = danhGiaPhimDetailsServicelmpl.suatChieu(nguoiDung.getId(), idPhim);
		 if (suatChieus.size()==0) {
			return 0;
		}
		 return 1;
	}
	@GetMapping("/saveDGP")   
	@ResponseBody
    public DanhGiaPhimDOT saveDGP(HttpSession session,@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "soSao") int soSao) {
		 NguoiDung nguoiDung =  (NguoiDung) session.getAttribute("nguoidung");
		 DanhGiaPhim danhGiaPhim = danhGiaPhimDetailsServicelmpl.timDanhGia(nguoiDung.getId(), idPhim);
		 if (danhGiaPhim!=null) {
			danhGiaPhimDetailsServicelmpl.updateDanhGia(danhGiaPhim.getId(), nguoiDung.getId(), idPhim, soSao);
		}else {
			danhGiaPhimDetailsServicelmpl.saveDanhGia(nguoiDung.getId(), idPhim, soSao);
		}
		List<DanhGiaPhim> danhGiaPhims = danhGiaPhimDetailsServicelmpl.allDanhGiaPhim(idPhim);
		int tongSoSao=0;
		for (int i = 0; i < danhGiaPhims.size(); i++) {
			tongSoSao+=danhGiaPhims.get(i).getSoSao();
		}
		double tb = (double)tongSoSao/danhGiaPhims.size();
		DanhGiaPhimDOT danhGiaPhimDOT = new  DanhGiaPhimDOT(danhGiaPhims.size(),(double) Math.round(tb * 10) / 10);
		 return danhGiaPhimDOT;
	}
	 @GetMapping("/lichPhim")   
	    public String lichPhim(Model model,@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "ngay") String ngay) {
		 Phim phim =  phimDetailsServicelmpl.getPhimId(idPhim);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 if (ngay.equalsIgnoreCase("null")==false) {
			 LocalDate date = LocalDate.parse(ngay, formatter);
			 if (date.isAfter(LocalDate.now())||date.isEqual(LocalDate.now())) {
				
			
			 List<TheLoai> theLoais = new ArrayList<TheLoai>();
				
			 List<KhuVuc> khuVucs = kvDetailsServiceImpl.khuVucCuaPhim(idPhim, date);
			 if (khuVucs.size()!=0) {
				 theLoais = tlDetailsServiceImpl.theLoaiCuaPhim(idPhim, date,khuVucs.get(0).getId());
				 List<Rap> raps = rapDetailsServiceImpl.rapCuaPhim(idPhim, date, khuVucs.get(0).getId(), theLoais.get(0).getId());
				 List<ChiTietSuat> suatChieus = suatChieuDetailsServiceImpl.suatChieuCuaPhim(idPhim, date, khuVucs.get(0).getId(), theLoais.get(0).getId());
				
				 model.addAttribute("p", phim);
				 model.addAttribute("tl",theLoais);
				 model.addAttribute("kv",khuVucs);
				 model.addAttribute("r",raps);
				 model.addAttribute("s",suatChieus);
				 model.addAttribute("tenTl",theLoais.get(0).getTen());
				
				
				 String formattedString = date.format(formatter);
				 model.addAttribute("n",  formattedString);
				 model.addAttribute("idKv", khuVucs.get(0).getId());
				 model.addAttribute("idTl", theLoais.get(0).getId());
				 
			}
			 
		 }
			 List<DanhGiaPhim> danhGiaPhims = danhGiaPhimDetailsServicelmpl.allDanhGiaPhim(idPhim);
				int tongSoSao=0;
				for (int i = 0; i < danhGiaPhims.size(); i++) {
					tongSoSao+=danhGiaPhims.get(i).getSoSao();
				}
			 double tb = (double)tongSoSao/danhGiaPhims.size();
			 DanhGiaPhimDOT danhGiaPhimDOT = new  DanhGiaPhimDOT(danhGiaPhims.size(),(double) Math.round(tb * 10) / 10);
			 model.addAttribute("sao",danhGiaPhimDOT);
			 String formattedString = date.format(formatter);
			 model.addAttribute("n",  formattedString);
			
			 
		}else {
		}
		 model.addAttribute("idPhim",idPhim);
		 model.addAttribute("p", phim);
		
	        return "lichPhim";
	    }
	 @GetMapping("/lichPhimTlThayDoi")   
	    public String lichPhimTlThayDoi(Model model,@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "idTl") int idTl,
	    		@RequestParam(value = "ngay") String ngay,@RequestParam(value = "idKv") int idKv) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<TheLoai> theLoais = tlDetailsServiceImpl.theLoaiCuaPhim(idPhim, date,idKv);
		 List<KhuVuc> khuVucs = kvDetailsServiceImpl.khuVucCuaPhim(idPhim, date); 
		 
		 theLoais = tlDetailsServiceImpl.theLoaiCuaPhim(idPhim, date,idKv);
		 List<Rap> raps = rapDetailsServiceImpl.rapCuaPhim(idPhim, date, idKv, idTl);
		 List<ChiTietSuat> suatChieus = suatChieuDetailsServiceImpl.suatChieuCuaPhim(idPhim, date, idKv, idTl);
		 Phim phim =  phimDetailsServicelmpl.getPhimId(idPhim);
		 String tenTl = tlDetailsServiceImpl.findTheLoai(idTl).getTen();
		 List<DanhGiaPhim> danhGiaPhims = danhGiaPhimDetailsServicelmpl.allDanhGiaPhim(idPhim);
			int tongSoSao=0;
			for (int i = 0; i < danhGiaPhims.size(); i++) {
				tongSoSao+=danhGiaPhims.get(i).getSoSao();
			}
		 double tb = (double)tongSoSao/danhGiaPhims.size();
		 DanhGiaPhimDOT danhGiaPhimDOT = new  DanhGiaPhimDOT(danhGiaPhims.size(),(double) Math.round(tb * 10) / 10);
		 model.addAttribute("sao",danhGiaPhimDOT);
		 model.addAttribute("p", phim);
		 model.addAttribute("tl",theLoais);
		 model.addAttribute("kv",khuVucs);
		 model.addAttribute("r",raps);
		 model.addAttribute("s",suatChieus);
		 model.addAttribute("tenTl",tenTl);
		 model.addAttribute("idPhim",idPhim);
		
		 String formattedString = date.format(formatter);
		 model.addAttribute("n",  formattedString);
		 model.addAttribute("p", phim);
		 model.addAttribute("idKv", idKv);
		 model.addAttribute("idTl", idTl);
		
		 return "lichPhim";
	    }

	 @GetMapping("/lichPhimKvThayDoi")   
	    public String lichPhimTlThayDoi(Model model,@RequestParam(value = "idPhim") int idPhim,@RequestParam(value = "ngay") String ngay
	    		,@RequestParam(value = "idKv") int idKv) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate date = LocalDate.parse(ngay, formatter);
		 List<TheLoai> theLoais = tlDetailsServiceImpl.theLoaiCuaPhim(idPhim, date,idKv);
		 List<KhuVuc> khuVucs = kvDetailsServiceImpl.khuVucCuaPhim(idPhim, date); 
		 
		 theLoais = tlDetailsServiceImpl.theLoaiCuaPhim(idPhim, date,idKv);
		 List<Rap> raps = rapDetailsServiceImpl.rapCuaPhim(idPhim, date, idKv, theLoais.get(0).getId());
		 List<ChiTietSuat> suatChieus = suatChieuDetailsServiceImpl.suatChieuCuaPhim(idPhim, date, idKv, theLoais.get(0).getId());
		 Phim phim =  phimDetailsServicelmpl.getPhimId(idPhim);
		 List<DanhGiaPhim> danhGiaPhims = danhGiaPhimDetailsServicelmpl.allDanhGiaPhim(idPhim);
			int tongSoSao=0;
			for (int i = 0; i < danhGiaPhims.size(); i++) {
				tongSoSao+=danhGiaPhims.get(i).getSoSao();
			}
		 double tb = (double)tongSoSao/danhGiaPhims.size();
		 DanhGiaPhimDOT danhGiaPhimDOT = new  DanhGiaPhimDOT(danhGiaPhims.size(),(double) Math.round(tb * 10) / 10);
		 model.addAttribute("sao",danhGiaPhimDOT);
		 model.addAttribute("p", phim);
		 model.addAttribute("tl",theLoais);
		 model.addAttribute("kv",khuVucs);
		 model.addAttribute("r",raps);
		 model.addAttribute("s",suatChieus);
		 model.addAttribute("tenTl",theLoais.get(0).getTen());
		 model.addAttribute("idPhim",idPhim);
		
		 String formattedString = date.format(formatter);
		 model.addAttribute("n",  formattedString);
		 model.addAttribute("p", phim);
		 model.addAttribute("idKv", idKv);
		 model.addAttribute("idTl", theLoais.get(0).getId());
		 return "lichPhim";
	 
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
