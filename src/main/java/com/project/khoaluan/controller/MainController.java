package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.khoaluan.entity.GheLichSuDvDOT;
import com.project.khoaluan.entity.LichSuDatVeDOT;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.service.ChiTietHoaDonDetailsServiceImpl;
import com.project.khoaluan.service.KhuVucDetailsServiceImpl;
import com.project.khoaluan.service.NguoiDungDetailsServiceImpl;
import com.project.khoaluan.service.PhimDetailsServicelmpl;
import com.project.khoaluan.service.SuatChieuDetailsServiceImpl;
import com.project.khoaluan.service.TheLoaiDetailsServiceImpl;

@Controller  
public class MainController {
	
	@Autowired
	NguoiDungDetailsServiceImpl ndDetailsServiceImpl;
	@Autowired
	PhimDetailsServicelmpl phimDetailsServicelmpl;
	@Autowired
	KhuVucDetailsServiceImpl kvDetailsServiceImpl;
	@Autowired
	TheLoaiDetailsServiceImpl tlDetailsServiceImpl;
	@Autowired
	SuatChieuDetailsServiceImpl suatChieuDetailsServiceImpl;
	@Autowired
	ChiTietHoaDonDetailsServiceImpl	chiTietHoaDonDetailsServiceImpl;
	@Autowired
	public JavaMailSender emailSender;
	
	@RequestMapping("/")
    public String index(HttpSession session,Model model) {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if (username.equals("anonymousUser")) {
			username=null;
		}
		session.setAttribute("username", username);
		session.setAttribute("role", authorities.size());
		session.setAttribute("nguoidung", ndDetailsServiceImpl.findByEmail(username));
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedString = date.format(formatter);
		System.out.println(username);
		LocalDate ngayketthuc= date.plusDays(7);
		List<Phim> phimdachieu = phimDetailsServicelmpl.phimDaChieu(date,ngayketthuc);
		List<Phim> phims = new ArrayList<Phim>();
		if (phimdachieu.size()!=0) {
			for (int i = 0; i < phimdachieu.size(); i++) {
				if (phims.contains(phimdachieu.get(i))==false) {
					phims.add(phimdachieu.get(i));
					
				}
				
			}
			model.addAttribute("pdc",phims);
		}
		model.addAttribute("date",formattedString);
        return "index";
    }
	@GetMapping("/timPhim")
	 public String timPhim (Model model,@RequestParam("tenPhim") String tenPhim) {
		if (tenPhim=="") {
			return "redirect:/";
		}
		List<Phim> list = phimDetailsServicelmpl.timPhim(tenPhim.toLowerCase().trim());
		model.addAttribute("p",list);
		return "TimPhim";
	}
	@RequestMapping("/thongtinNd")
	
	 public String thongtinNd (HttpSession session,Model model) {
		String email = (String) session.getAttribute("username");
		NguoiDung nguoiDung = ndDetailsServiceImpl.findByEmail(email);
		model.addAttribute("nd", nguoiDung);


		return "TTnd";
	}
	@PostMapping("/suaThongTin")
	
	 public String suaThongTin (@ModelAttribute("nd") NguoiDung nd) {
		ndDetailsServiceImpl.SuaNguoiDungkhongcapnhatMK(nd);
		
		return "redirect:/thongtinNd";
	}
	@PostMapping("/doiMatKhau")  
    public String doiMatKhau(@ModelAttribute("nd") NguoiDung theUser) {
	 	NguoiDung nguoiDung=ndDetailsServiceImpl.TimNguoiDung(theUser.getEmail());
	 	nguoiDung.setMatKhau(theUser.getMatKhau());
	 	ndDetailsServiceImpl.saveQMK(nguoiDung);
		System.out.println(theUser);
        return "redirect:/logout";
    }

	@RequestMapping("/phimsapchieu")
	
	 public String phimSapChieu (Model model) {
		LocalDate date = LocalDate.now();
		List<Phim> phims = phimDetailsServicelmpl.phimSapChieu(date);
		model.addAttribute("phim",phims);
		return "phimSapChieu";
	}
	@RequestMapping("/kiemtrasuat")
	
	 public String kiemTraSuat (@RequestParam("idPhim") int idPhim) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ngayChieuGanNhat = suatChieuDetailsServiceImpl.ngayChieuGannhat(date, idPhim);
		String ngaychieu;
		if (ngayChieuGanNhat!=null) {
			ngaychieu = ngayChieuGanNhat.format(formatter);
		}else {
			ngaychieu = "null";
		}
	
		
		return "redirect:/datve/lichPhim?idPhim="+idPhim+"&ngay="+ngaychieu+"";
		
	}
	 @RequestMapping("/login")   
	    public String getLogin() {
	        return "login";
	    }
	
	 @GetMapping("/showdangki")  
	    public String create(Model model) {
	    	NguoiDung user = new NguoiDung();
	    	model.addAttribute("user",user);
	        return "dangki";
	    }
	 @GetMapping("/showqmk")  
	    public String showFormQuenMatkhau(Model model) {
	    	NguoiDung user = new NguoiDung();
	    	model.addAttribute("user",user);
	        return "quenmatkhau";
	    }
	
	 @GetMapping("/showdoiqmkNoti")  
	    public String showFormDoiQMKNoti(Model model,@RequestParam(value = "inform") String inform) {
	    	NguoiDung user = new NguoiDung();
	    	model.addAttribute("user",user);
	    	if(inform.equalsIgnoreCase("thanhcong")) {
	    		model.addAttribute("inform","check email để thực hiện lấy lại mật khẩu");
	    		return "quenmatkhau";
	    	}else {
	    		model.addAttribute("inform","email không tồn tại");
	    		return "quenmatkhau";
	    	}
	        
	    }
	 @GetMapping("/loishowdangki")  
	    public String loicreate(Model model) {
	    	NguoiDung user = new NguoiDung();
	    	model.addAttribute("user",user);
	    	model.addAttribute("loi","Email Đã Được Sử Dụng");
	        return "dangki";
	    }
	 @GetMapping("/showdoiqmk")  
	    public String showFormDoiQKM(Model model,@RequestParam(value = "token") String token) {
	    	NguoiDung user = ndDetailsServiceImpl.TimNguoiDungforToken(token);
	    	if (user==null) {
	    		 return "redirect:/login";
			}else {
				System.out.println(user);
		    	model.addAttribute("user",user);
		        return "ThucHienDoiMK";
			}
	    	
	    }
	 @PostMapping("/doiQuenMatKhau")  
	    public String doiQuenMatKhau(@ModelAttribute("user") NguoiDung theUser,@RequestParam(value = "emailUser") String emailUser) {
		 	NguoiDung nguoiDung=ndDetailsServiceImpl.TimNguoiDung(emailUser);
		 	nguoiDung.setMatKhau(theUser.getMatKhau());
		 	nguoiDung.setTokenQuenMatKhau("");
		 	ndDetailsServiceImpl.saveQMK(nguoiDung);
	        return "redirect:/login";
	    }
	 @PostMapping("/quenMatKhau")
	    public String quenMatKhau(@ModelAttribute("user") NguoiDung theUser){
		 String link = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();

			if (ndDetailsServiceImpl.TimNguoiDung(theUser.getEmail())!=null) {
				NguoiDung nguoiDung;
				nguoiDung=ndDetailsServiceImpl.TimNguoiDung(theUser.getEmail());
				String confirmationToken = UUID.randomUUID().toString();
				nguoiDung.setTokenQuenMatKhau(confirmationToken);
				ndDetailsServiceImpl.saveTokenQMK(nguoiDung);
				MimeMessage message = emailSender.createMimeMessage();
		    	boolean multipart = true;
		        
		        MimeMessageHelper helper;
				try {
					helper = new MimeMessageHelper(message, multipart, "utf-8");
					String htmlMsg = "<a href=\""+link+"/showdoiqmk?token="+confirmationToken+"\">Đặt lại mật khẩu tại đây</a>";
			        
			        message.setContent(htmlMsg, "text/html;charset=UTF-8");
			        
			        helper.setTo(nguoiDung.getEmail());
			        
			        helper.setSubject("Test send HTML email");
			        this.emailSender.send(message);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(nguoiDung);
				return "redirect:/showdoiqmkNoti?inform=thanhcong";
			}else {
				return "redirect:/showdoiqmkNoti?inform=kothanhcong";
			}
		   
	    }
	@PostMapping("/dangki")
	    public String savePerson(@ModelAttribute("user") NguoiDung theUser){
			System.out.println(theUser);
			if (ndDetailsServiceImpl.TimNguoiDung(theUser.getEmail())!=null) {
				return "redirect:/loishowdangki";
				
			}else {
				ndDetailsServiceImpl.save(theUser);
				System.out.println(theUser);
				return "redirect:/login";
			}
		   
	    }
	@GetMapping("/lichSuDatVe")  
    public String lichSuDatVe(HttpSession session,Model model) {
		String email = (String) session.getAttribute("username");
		NguoiDung nd = ndDetailsServiceImpl.findByEmail(email);
		List<LichSuDatVeDOT> list  = chiTietHoaDonDetailsServiceImpl.lichSuDatVe(nd.getId());
		List<GheLichSuDvDOT> list2 = chiTietHoaDonDetailsServiceImpl.lichSuCtDatVe(nd.getId());
    	model.addAttribute("ls", list);
    	model.addAttribute("g", list2);
        return "lichSuDatVe";
    }

	 
	
}
