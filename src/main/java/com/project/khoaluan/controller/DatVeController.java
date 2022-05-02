package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.project.khoaluan.config.PaypalPaymentIntent;
import com.project.khoaluan.config.PaypalPaymentMethod;
import com.project.khoaluan.dao.GheNgoiRepository;
import com.project.khoaluan.dao.NguoiDungRepository;
import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.entity.GheNgoiDOT;
import com.project.khoaluan.model.ChiTietHoaDon;
import com.project.khoaluan.model.GheNgoi;
import com.project.khoaluan.model.HoaDon;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.service.ChiTietHoaDonDetailsServiceImpl;
import com.project.khoaluan.service.GheNgoiDetailsServiceImpl;
import com.project.khoaluan.service.HoaDonDetailsServiceImpl;
import com.project.khoaluan.service.NguoiDungDetailsServiceImpl;
import com.project.khoaluan.service.PaypalService;
import com.project.khoaluan.service.PhimDetailsServicelmpl;
import com.project.khoaluan.service.SuatChieuDetailsService;
import com.project.khoaluan.service.SuatChieuDetailsServiceImpl;
import com.project.khoaluan.utils.Utils;

@Controller
@RequestMapping("/chonve")
public class DatVeController {
	@Autowired
	GheNgoiDetailsServiceImpl gheNgoiDetailsServiceImpl;
	@Autowired
	SuatChieuDetailsServiceImpl suatChieuDetailsServiceImpl;
	@Autowired
	PhimDetailsServicelmpl phimdetailsServicelmpl;
	@Autowired
	ChiTietHoaDonDetailsServiceImpl chiTietHoaDonDetailsServiceImpl;
	@Autowired
	HoaDonDetailsServiceImpl hoaDonDetailsServiceImpl;
	@Autowired
	NguoiDungDetailsServiceImpl nguoiDungDetailsServiceImpl;
	
	 @GetMapping("/suat")
	 	
	    public String datVe(HttpSession session,Model model,@RequestParam(value = "id") int idSuat) {
		 org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String username = auth.getName();
		 if (username.equals("anonymousUser")) {
				username=null;
		}
		 session.setAttribute("username", username);
		 session.setAttribute("nguoidung", nguoiDungDetailsServiceImpl.findByEmail(username));
		 session.setAttribute("gheNgoi","");
		 session.setAttribute("idSuat","");
		 int gio = LocalTime.now().getHour();
		 int phut = LocalTime.now().getMinute();
		 ChiTietSuat cts = suatChieuDetailsServiceImpl.ChiTietSuatChieu(idSuat);
		 
		 String[] ctsGio = cts.getGioBatDau().split(":");
		 LocalDate date = LocalDate.now();
		 if (date.isEqual(cts.getNgayChieu())) {
			 if (Integer.parseInt(ctsGio[0])< gio) {
				model.addAttribute("hetTG", true);
			}else if(Integer.parseInt(ctsGio[0])==gio&&Integer.parseInt(ctsGio[1]) <phut) {
				model.addAttribute("hetTG", true);
			}
			 else {
				model.addAttribute("hetTG", false);
			}
		}else if(date.isAfter(cts.getNgayChieu())) {
			model.addAttribute("hetTG", true);
		}else {
			model.addAttribute("hetTG", false);
		}
		 ArrayList<GheNgoi> gheNgoisdachon =(ArrayList<GheNgoi>) gheNgoiDetailsServiceImpl.gheDaChon(idSuat);
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
		 
		
		Phim phim = phimdetailsServicelmpl.getPhimId(cts.getIdPhim());
		session.setAttribute("idSuat",idSuat);
		model.addAttribute("anh", phim.getHinhAnh()); 
		model.addAttribute("s", cts);
		model.addAttribute("h", gheNgoiDOTs);
		 
		 
	        return "datve";
	    }
	 @GetMapping("/vitridatve")
	 @ResponseBody
	 public List<GheNgoi> viTriDatVe(HttpSession session,@RequestParam(value = "vitri") int[] vitri,@RequestParam(value = "idSuat") int idSuat) {
		 List<GheNgoi> gheNgois= gheNgoiDetailsServiceImpl.gheNgoiCuaSuat(idSuat);
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
	 
	 @GetMapping("/thanhToan")
	    public String thanhToan(HttpSession session,Model model) {
		 List<GheNgoi> gheNgois = new ArrayList<GheNgoi>();
		 if(session.getAttribute("gheNgoi")!="") {
			 gheNgois = (List<GheNgoi>) session.getAttribute("gheNgoi");
			 int idSuat =  (int) session.getAttribute("idSuat");
			 String email = (String) session.getAttribute("username");
			 NguoiDung nguoiDung = nguoiDungDetailsServiceImpl.findByEmail(email);
			 if (nguoiDung!=null) {
				 HoaDon hoaDon = new HoaDon(nguoiDung, LocalDate.now());
				 SuatChieu suatChieu = suatChieuDetailsServiceImpl.findSuatChieu(idSuat);
				 hoaDonDetailsServiceImpl.addHoaDon(hoaDon);
				 for (GheNgoi gn : gheNgois) {
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(suatChieu.getGiaVe(), suatChieu, gn, hoaDon);
					chiTietHoaDonDetailsServiceImpl.addCTHD(chiTietHoaDon);
				}
			}
			
		 }

		 
		 return "ThanhToan";
	 }
	 	public static final String URL_PAYPAL_SUCCESS = "chonve/pay/success";
		public static final String URL_PAYPAL_CANCEL = "chonve/pay/cancel";
		private Logger log = LoggerFactory.getLogger(getClass());
		@Autowired
		private PaypalService paypalService;
		@GetMapping("/ShowFormThanhToan")
		public String showFormThanhToan(HttpSession session,Model model){
			 double gia = 0;
			 List<GheNgoi> gheNgois = new ArrayList<GheNgoi>();
			 if(session.getAttribute("gheNgoi")!="") {
				 gheNgois = (List<GheNgoi>) session.getAttribute("gheNgoi");
				 int idSuat =  (int) session.getAttribute("idSuat");
				 String email = (String) session.getAttribute("username");
				 NguoiDung nguoiDung = nguoiDungDetailsServiceImpl.findByEmail(email);
				 if (nguoiDung!=null) {
					 HoaDon hoaDon = new HoaDon(nguoiDung, LocalDate.now());
					 SuatChieu suatChieu = suatChieuDetailsServiceImpl.findSuatChieu(idSuat);
					 for (int i = 0; i < gheNgois.size(); i++) {
						gia=gia+(suatChieu.getGiaVe()); 
						
					}
					 System.out.println(gheNgois);
					 model.addAttribute("nd", nguoiDung);
					 model.addAttribute("g", gheNgois);
					 model.addAttribute("idSuat", idSuat);
				}
				 
			 }
			
			model.addAttribute("gia", gia+"");
			System.out.println(gia);
			return "FormThanhToan";
		}	 
		@PostMapping("/pay")
		public String pay(HttpSession session,HttpServletRequest request,@RequestParam("price") double price ){
			String cancelUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
			String successUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
			session.setAttribute("gia", price);
			price = (double) Math.floor((price/23000) * 10) / 10;
			
			try {
				Payment payment = paypalService.createPayment(
						price,
						"USD",
						PaypalPaymentMethod.paypal,
						PaypalPaymentIntent.sale,
						"payment description",
						cancelUrl,
						successUrl);
				for(Links links : payment.getLinks()){
					if(links.getRel().equals("approval_url")){
						return "redirect:" + links.getHref();
					}
				}
			} catch (PayPalRESTException e) {
				log.error(e.getMessage());
			}
			return "redirect:/";
		}
		@GetMapping("/pay/cancel")
		public String cancelPay(){
			return "cancel";
		}
		@GetMapping("/pay/success")
		public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
			try {
				Payment payment = paypalService.executePayment(paymentId, payerId);
				if(payment.getState().equals("approved")){
					return "redirect:/chonve/thanhToan";
				}
			} catch (PayPalRESTException e) {
				log.error(e.getMessage());
			}
			return "redirect:/";
		}

	 
}
