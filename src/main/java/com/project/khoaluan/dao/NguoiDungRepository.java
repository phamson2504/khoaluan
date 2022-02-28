package com.project.khoaluan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.model.NguoiDung;



public interface NguoiDungRepository extends CrudRepository<NguoiDung, Integer> {
	NguoiDung findByEmail(String email);
	
	NguoiDung findByTokenQuenMatKhau(String token);
	
	@Query("SELECT u.hoTen,u.sdt,u.email FROM NguoiDung u WHERE u.hoTen = ?1 and u.sdt = ?2")
	Object findmany(String hoTen ,String sdt);
}
