package com.project.khoaluan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.SuatChieu;

public interface SuatChieuRepository extends CrudRepository<SuatChieu, Integer>{
	
	@Query(value="select new com.project.khoaluan.entity.ChiTietSuat(s.id,s.gioBatDau,s.ngayChieu,s.giaVe,r.id,r.tenRap,p.id,ph.id,ph.tenPhim,tl.ten)  FROM KhuVuc kv INNER JOIN kv.raps r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl where ph.id=?1")
	List<ChiTietSuat> findChiTiet(int idPhim);
}
