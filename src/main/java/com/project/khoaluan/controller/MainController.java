package com.project.khoaluan.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.khoaluan.dao.NguoiDungRepository;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.service.NguoiDungDetailsServiceImpl;

@Controller  
public class MainController {
	
	@Autowired
	NguoiDungDetailsServiceImpl ndDetailsServiceImpl;
	@Autowired
	public JavaMailSender emailSender;
	
	@RequestMapping("/")
    public String index(HttpSession session) {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println(authorities.size());
		session.setAttribute("username", username);
        return "index";
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
	 @GetMapping("/datve")  
	    public String datve() {
	        return "datve";
	    }
}
