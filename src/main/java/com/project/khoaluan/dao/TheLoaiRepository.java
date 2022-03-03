package com.project.khoaluan.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.TheLoai;

public interface TheLoaiRepository extends CrudRepository<TheLoai, Integer>{
	TheLoai findById(int id);
	@Query(value="select DISTINCT tl "
			+ " FROM KhuVuc kv INNER JOIN kv.raps r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl where ph.id=:idPhim "
			+ "and  s.ngayChieu =:startDate and kv.id =:idKv")
	List<TheLoai> TheLoaiCuaPhim(@Param("idPhim") int idPhim,@Param("startDate") LocalDate startDate,@Param("idKv") int idKv);
	
	@Query(value="select DISTINCT tl "
			+ " FROM KhuVuc kv INNER JOIN kv.raps r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl where "
			+ "s.ngayChieu =:startDate and r.id =:idRap")
	List<TheLoai> TheLoaiCuaRap(@Param("startDate") LocalDate startDate,@Param("idRap") int idRap);
}
