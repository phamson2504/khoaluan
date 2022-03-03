package com.project.khoaluan.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.SuatChieu;
import com.project.khoaluan.model.TheLoai;


public interface PhimRepository extends CrudRepository<Phim, Integer> {
	
	Phim findById(int id);
	
	@Query(value="select DISTINCT p from Phim p INNER JOIN p.suats s where s.ngayChieu =:startDate")
	public List<Phim> loadPhim(@Param("startDate") LocalDate startDate);
	
	@Query(value="select p from Phim p where p.ngayCongChieu > :startDate")
	public List<Phim> phimSapChieu(@Param("startDate") LocalDate startDate);
	
	@Query(value="select DISTINCT ph "
			+ " FROM KhuVuc kv INNER JOIN kv.raps r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl where "
			+ "s.ngayChieu =:startDate and r.id =:idRap and tl.id =:idTl")
	List<Phim> PhimsCuaRap(@Param("startDate") LocalDate startDate,@Param("idRap") int idRap,@Param("idTl") int idTl);
}
