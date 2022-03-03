package com.project.khoaluan.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.khoaluan.dao.GheNgoiRepository;
import com.project.khoaluan.dao.NguoiDungRepository;
import com.project.khoaluan.model.GheNgoi;
import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.TheLoai;
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
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedString = date.format(formatter);
		System.out.println(username);
		List<Phim> phims = phimDetailsServicelmpl.loadPhim(date);
		model.addAttribute("phim",phims);
		model.addAttribute("date",formattedString);
        return "index";
    }
	@RequestMapping("/phimsapchieu")
	
	 public String phimsapchieu (Model model) {
		LocalDate date = LocalDate.now();
		List<Phim> phims = phimDetailsServicelmpl.phimSapChieu(date);
		model.addAttribute("phim",phims);
		return "phimSapChieu";
	}
	@RequestMapping("/kiemtrasuat")
	
	 public String kiemtrasuat (@RequestParam("idPhim") int idPhim) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ngayChieuGanNhat = suatChieuDetailsServiceImpl.ngayChieuGannhat(date, idPhim);
		String ngaychieu = ngayChieuGanNhat.format(formatter);
		if (ngayChieuGanNhat!=null) {
			 return "redirect:/datve/lichPhim?idPhim="+idPhim+"&ngay="+ngaychieu+"";
		}else {
			return "redirect:/phimsapchieu";
		}
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
	    public String showformquenmatkhau(Model model) {
	    	NguoiDung user = new NguoiDung();
	    	model.addAttribute("user",user);
	        return "quenmatkhau";
	    }
	
	 @GetMapping("/showdoiqmkNoti")  
	    public String showformdoiqkmNoti(Model model,@RequestParam(value = "inform") String inform) {
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
	    public String showformdoiqkm(Model model,@RequestParam(value = "token") String token) {
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
	    	System.out.println("adfadfdsdsafsf"+nguoiDung);
	        return "redirect:/login";
	    }
	 @PostMapping("/quenMatKhau")
	    public String quenMatKhau(@ModelAttribute("user") NguoiDung theUser){
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
					String htmlMsg = "<a href=\"http://localhost:8080/showdoiqmk?token="+confirmationToken+"\">Đặt lại mật khẩu tại đây</a>";
			        
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
	@Autowired
	GheNgoiRepository gheNgoiRepository;
	 @GetMapping("/datve")
	 
	    public String datve(Model model) {
		 List<GheNgoi> gheNgois= gheNgoiRepository.gheNgoiCuaPhong();
		
			model.addAttribute("h", gheNgois);
	        return "datve";
	    }
	 @GetMapping("/vitridatve")
	 @ResponseBody
	 public List<GheNgoi> vitridatve(HttpSession session,@RequestParam(value = "vitri") int[] vitri) {
		 List<GheNgoi> gheNgois= gheNgoiRepository.gheNgoiCuaPhong();
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
