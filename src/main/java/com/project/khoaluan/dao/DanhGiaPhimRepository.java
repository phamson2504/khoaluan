package com.project.khoaluan.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.DanhGiaPhim;
import com.project.khoaluan.model.SuatChieu;

public interface DanhGiaPhimRepository extends CrudRepository<DanhGiaPhim, Integer>{
	@Query("SELECT DISTINCT s FROM NguoiDung nd INNER JOIN nd.hoaDons hd INNER JOIN hd.chiTHDs ct"
			+ " INNER JOIN ct.suatChieu s INNER JOIN s.phim ph where nd.id =:idNd and ph.id =:idPhim")
	List<SuatChieu> suatChieu(@Param("idNd") int idNd,@Param("idPhim") int idPhim);
	
	@Query("SELECT dgp FROM NguoiDung nd INNER JOIN nd.dGPs dgp INNER JOIN nd.hoaDons hd INNER JOIN hd.chiTHDs ct"
			+ " INNER JOIN ct.suatChieu s INNER JOIN dgp.phim ph where nd.id =:idNd and ph.id =:idPhim")
	DanhGiaPhim timDanhGia(@Param("idNd") int idNd,@Param("idPhim") int idPhim);
	
	@Query("SELECT DISTINCT dgp FROM DanhGiaPhim dgp INNER JOIN dgp.phim ph where ph.id =:idPhim")
	List<DanhGiaPhim> allDanhGiaPhim(@Param("idPhim") int idPhim);
	
}
