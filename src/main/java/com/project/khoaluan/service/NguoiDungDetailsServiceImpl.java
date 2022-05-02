package com.project.khoaluan.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.NguoiDungRepository;
import com.project.khoaluan.dao.VaiTroRepository;
import com.project.khoaluan.model.NguoiDung;
import com.project.khoaluan.model.VaiTro;



@Service
public class NguoiDungDetailsServiceImpl implements UserDetailsService,NguoiDungDetailsService{

	@Autowired
	NguoiDungRepository ndRepository;
	
	@Autowired
	VaiTroRepository vtRepository;
	
	  @Autowired 
	    private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 NguoiDung nd = ndRepository.findByEmail(username);
         if (nd == null) {
             throw new UsernameNotFoundException("User not found");
         }

         Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
         Set<VaiTro> vaitros = nd.getVaitros();
         for (VaiTro vaitro : vaitros) {
             grantedAuthorities.add(new SimpleGrantedAuthority(vaitro.getTen()));
         }

         return new org.springframework.security.core.userdetails.User(
                 nd.getEmail(), nd.getMatKhau(), grantedAuthorities);
	}
	  public void save(NguoiDung nd) {
	    	if (vtRepository.findByTen("ROLE_ADMIN") == null) {
	    		vtRepository.save(new VaiTro("ROLE_ADMIN"));
	        }

	        if (vtRepository.findByTen("ROLE_MEMBER") == null) {
	        	vtRepository.save(new VaiTro("ROLE_MEMBER"));
	        }
	        if (ndRepository.findByEmail(nd.getEmail()) == null) {
	            NguoiDung user1 = new NguoiDung();
	            user1.setEmail(nd.getEmail());
	            user1.setHoTen(nd.getHoTen());
	            user1.setGioiTinh(nd.getGioiTinh());
	            user1.setNgaySinh(nd.getNgaySinh());
	            user1.setSdt(nd.getSdt());
	            user1.setMatKhau(passwordEncoder.encode(nd.getMatKhau()));
	            HashSet<VaiTro> roles = new HashSet<>();
	            roles.add(vtRepository.findByTen("ROLE_MEMBER"));
	            user1.setVaitros(roles);
	            ndRepository.save(user1);
	        }
		}
	  public void saveTokenQMK(NguoiDung nd) {
          ndRepository.save(nd);  
	  }
	  public void saveQMK(NguoiDung nd) {
		  nd.setMatKhau(passwordEncoder.encode(nd.getMatKhau()));
          ndRepository.save(nd);  
	  }
	  public void saveAdmin(NguoiDung nd) {
		  if (vtRepository.findByTen("ROLE_ADMIN") == null) {
	    		vtRepository.save(new VaiTro("ROLE_ADMIN"));
	        }

	        if (vtRepository.findByTen("ROLE_MEMBER") == null) {
	        	vtRepository.save(new VaiTro("ROLE_MEMBER"));
	        }
		  NguoiDung user1 = new NguoiDung();
          user1.setEmail(nd.getEmail());
          user1.setHoTen(nd.getHoTen());
          user1.setGioiTinh(nd.getGioiTinh());
          user1.setNgaySinh(nd.getNgaySinh());
          user1.setSdt(nd.getSdt());
          user1.setMatKhau(passwordEncoder.encode(nd.getMatKhau()));
          HashSet<VaiTro> roles = new HashSet<>();
          roles.add(vtRepository.findByTen("ROLE_ADMIN"));
          roles.add(vtRepository.findByTen("ROLE_MEMBER"));
          user1.setVaitros(roles);
          ndRepository.save(user1);
	  }
	  public NguoiDung TimNguoiDung(String email) {
		  if(ndRepository.findByEmail(email)==null) {
			  return null;
		  }else {
			  return ndRepository.findByEmail(email);
		  }
		   
	  }
	  public NguoiDung TimNguoiDungforToken(String token) {
		  if(ndRepository.findByTokenQuenMatKhau(token)==null) {
			  return null;
		  }else {
			  return ndRepository.findByTokenQuenMatKhau(token);
		  }
		   
	  }
	  public NguoiDung findbyid (int id) {
		  return ndRepository.findById(id);
	  }
	  public List<NguoiDung> allNguoiDung(){
		  return (List<NguoiDung>) ndRepository.findAll();
	  }
	  public void XoaNguoiDung(int id) {
		  ndRepository.deleteById(id);;
	  }
	  public void SuaNguoiDung(NguoiDung nd) {
		  NguoiDung nguoiDung=  ndRepository.findById(nd.getId());
		  nguoiDung.setEmail(nd.getEmail());
		  nguoiDung.setGioiTinh(nd.getGioiTinh());
		  nguoiDung.setHoTen(nd.getHoTen());
		  nguoiDung.setMatKhau(passwordEncoder.encode(nd.getMatKhau()));
		  nguoiDung.setNgaySinh(nd.getNgaySinh());
		  nguoiDung.setSdt(nd.getSdt());
		  ndRepository.save(nguoiDung);
	  }
	  public void SuaNguoiDungkhongcapnhatMK(NguoiDung nd) {
		  NguoiDung nguoiDung=  ndRepository.findById(nd.getId());
		  nguoiDung.setEmail(nd.getEmail());
		  nguoiDung.setGioiTinh(nd.getGioiTinh());
		  nguoiDung.setHoTen(nd.getHoTen());
		  nguoiDung.setNgaySinh(nd.getNgaySinh());
		  nguoiDung.setSdt(nd.getSdt());
		  ndRepository.save(nguoiDung);
	  }
	@Override
	public NguoiDung findByEmail(String email) {
		// TODO Auto-generated method stub
		return ndRepository.findByEmail(email);
	}
	  
	

}
