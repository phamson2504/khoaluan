package com.project.khoaluan.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.project.khoaluan.model.NguoiDung;

public interface NguoiDungDetailsService {
	public UserDetails loadUserByUsername(String username);
	public void save(NguoiDung nd);
	public void saveTokenQMK(NguoiDung nd);
	public void saveQMK(NguoiDung nd);
	public void saveAdmin(NguoiDung nd);
	public NguoiDung TimNguoiDung(String email);
	public NguoiDung TimNguoiDungforToken(String token);
	public NguoiDung findbyid (int id);
	public List<NguoiDung> allNguoiDung();
	public void XoaNguoiDung(int id);
	public void SuaNguoiDung(NguoiDung nd);
	public void SuaNguoiDungkhongcapnhatMK(NguoiDung nd);
	public NguoiDung findByEmail(String email);
}
